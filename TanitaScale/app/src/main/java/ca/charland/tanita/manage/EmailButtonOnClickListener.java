package ca.charland.tanita.manage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import ca.charland.tanita.R;
import ca.charland.tanita.base.activity.BaseActivity;
import ca.charland.tanita.base.db.Data;
import ca.charland.tanita.base.db.DataTable;
import ca.charland.tanita.base.utils.Email;
import ca.charland.tanita.db.PersonData;
import ca.charland.tanita.db.PersonDataSource;
import ca.charland.tanita.db.PersonDataTable;
import ca.charland.tanita.db.TanitaData;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.db.TanitaDatabaseConnection;

/**
 * The listener interface for receiving emailButtonOnClick events. The class that is interested in processing a emailButtonOnClick event implements
 * this interface, and the object created with that class is registered with a component using the component's
 * <code>addEmailButtonOnClickListener<code> method. When
 * the emailButtonOnClick event occurs, that object's appropriate
 * method is invoked.
 * 
 * @author mcharland
 */
public class EmailButtonOnClickListener implements OnClickListener {

	private final Activity activity;
	private final TanitaData tanitaData;

	public EmailButtonOnClickListener(Activity activity, TanitaData td) {
		this.activity = activity;
		this.tanitaData = td;
		setEmailSentAmount();
	}

	@Override
	public void onClick(View v) {
		Intent intent = getEmail();
		sendEmail(intent);
		incrementEmailValue();
	}

	private void incrementEmailValue() {
		tanitaData.incrementEmailsSent();
		
		int id = tanitaData.getId();
		
		TanitaDataSource datasource = new TanitaDataSource(new TanitaDatabaseConnection(activity));
		datasource.openDatabaseConnection();
		ContentValues values = new ContentValues();
		values.put(TanitaDataTable.Column.EMAILS_SENT.toString(), tanitaData.getEmailsSent());
		datasource.updateTableRow(DataTable.ID_COLUMN_NAME, id, values);
		datasource.closeDatabaseConnection();
		
		setEmailSentAmount();
	}

	private void setEmailSentAmount() {
		TextView inc = (TextView) activity.findViewById(R.id.emailSentAmount);
		inc.setText(String.valueOf(tanitaData.getEmailsSent()));
	}

	private Intent getEmail() {
		Email email = new Email();
		email.setToAdress(getEmailToAddress());
		email.setSubject(getSubject());
		setEmailBody(email);
		return email.getIntent();
	}

	private void sendEmail(Intent intent) {
		try {
			activity.startActivity(Intent.createChooser(intent, "Send mail..."));
			activity.finish();
		} catch (ActivityNotFoundException ex) {
			Toast.makeText(activity, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		}
	}

	private String getEmailToAddress() {
		PersonDataSource datasource = new PersonDataSource(activity);
		datasource.openDatabaseConnection();
		final List<Data> data = datasource.query(getSelection());
		PersonData pd = (PersonData) data.get(0);
		String email = pd.getEmail();

		datasource.closeDatabaseConnection();

		return email;
	}

	private String getSelection() {
		long person = tanitaData.getPerson();
		return PersonDataTable.Column.ID.toString() + " = " + person;
	}

	private void setEmailBody(Email email) {

		email.addToBody(getTextFromResource(R.string.date), getDate());
		email.addToBodyDouble(getTextFromResource(R.string.weight), tanitaData.getWeight());
		email.addToBodyInteger(getTextFromResource(R.string.dci), tanitaData.getDailyCaloricIntake());
		email.addToBodyInteger(getTextFromResource(R.string.metabolic_age), tanitaData.getMetabolicAge());
		email.addToBodyPercent(getTextFromResource(R.string.body_water_percentage), tanitaData.getBodyWaterPercentage());
		email.addToBodyInteger(getTextFromResource(R.string.visceral_fat), tanitaData.getVisceralFat());
		email.addToBodyDouble(getTextFromResource(R.string.bone_mass), tanitaData.getBoneMass());

		email.addToBodyPercent(getTextFromResource(R.string.body_fat_total), tanitaData.getBodyFatTotal());
		email.addToBodyPercent(getTextFromResource(R.string.body_fat_arm_left), tanitaData.getBodyFatLeftArm());
		email.addToBodyPercent(getTextFromResource(R.string.body_fat_arm_right), tanitaData.getBodyFatRightArm());
		email.addToBodyPercent(getTextFromResource(R.string.body_fat_leg_left), tanitaData.getBodyFatLeftLeg());
		email.addToBodyPercent(getTextFromResource(R.string.body_fat_leg_right), tanitaData.getBodyFatRightLeg());
		email.addToBodyPercent(getTextFromResource(R.string.body_fat_trunk), tanitaData.getBodyFatTrunk());

		email.addToBodyDouble(getTextFromResource(R.string.muscle_mass_total), tanitaData.getMuscleMassTotal());
		email.addToBodyDouble(getTextFromResource(R.string.muscle_mass_arm_left), tanitaData.getMuscleMassLeftArm());
		email.addToBodyDouble(getTextFromResource(R.string.muscle_mass_arm_right), tanitaData.getMuscleMassRightArm());
		email.addToBodyDouble(getTextFromResource(R.string.muscle_mass_leg_right), tanitaData.getMuscleMassRightLeg());
		email.addToBodyDouble(getTextFromResource(R.string.muscle_mass_leg_left), tanitaData.getMuscleMassLeftLeg());
		email.addToBodyDouble(getTextFromResource(R.string.muscle_mass_trunk), tanitaData.getMuscleMassTrunk());

		email.addToBodyInteger(getTextFromResource(R.string.physic_rating), tanitaData.getPhysicRating());
	}

	private String getDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		String date = df.format(tanitaData.getDate());
		return date;
	}

	private String getTextFromResource(int id) {
		Resources resources = activity.getResources();
		CharSequence text = resources.getString(id);
		return text.toString();
	}

	private String getSubject() {
		return tanitaData.toString();
	}

}

package ca.charland.tanita.manage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import ca.charland.R;
import ca.charland.db.Data;
import ca.charland.tanita.db.PersonData;
import ca.charland.tanita.db.PersonDataSource;
import ca.charland.tanita.db.PersonDataTable;
import ca.charland.tanita.db.TanitaData;
import ca.charland.utils.Email;

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

	private Activity activity;

	private final TanitaData tanitadata;

	public EmailButtonOnClickListener(Activity activity, TanitaData td) {
		this.activity = activity;
		this.tanitadata = td;
	}

	@Override
	public void onClick(View v) {
		Intent intent = getEmail();
		sendEmail(intent);
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
		long person = tanitadata.getPerson();
		return PersonDataTable.Column.ID.toString() + " = " + person;
	}

	private void setEmailBody(Email email) {

		email.addToBody(getTextFromResource(R.string.date), getDate());
		email.addToBodyDouble(getTextFromResource(R.string.weight), tanitadata.getWeight());
		email.addToBodyInteger(getTextFromResource(R.string.dci), tanitadata.getDailyCaloricIntake());
		email.addToBodyInteger(getTextFromResource(R.string.metabolic_age), tanitadata.getMetabolicAge());
		email.addToBodyPercent(getTextFromResource(R.string.body_water_percentage), tanitadata.getBodyWaterPercentage());
		email.addToBodyInteger(getTextFromResource(R.string.visceral_fat), tanitadata.getVisceralFat());
		email.addToBodyDouble(getTextFromResource(R.string.bone_mass), tanitadata.getBoneMass());

		email.addToBodyPercent(getTextFromResource(R.string.body_fat_total), tanitadata.getBodyFatTotal());
		email.addToBodyPercent(getTextFromResource(R.string.body_fat_arm_left), tanitadata.getBodyFatLeftArm());
		email.addToBodyPercent(getTextFromResource(R.string.body_fat_arm_right), tanitadata.getBodyFatRightArm());
		email.addToBodyPercent(getTextFromResource(R.string.body_fat_leg_left), tanitadata.getBodyFatLeftLeg());
		email.addToBodyPercent(getTextFromResource(R.string.body_fat_leg_right), tanitadata.getBodyFatRightLeg());
		email.addToBodyPercent(getTextFromResource(R.string.body_fat_trunk), tanitadata.getBodyFatTrunk());

		email.addToBodyDouble(getTextFromResource(R.string.muscle_mass_total), tanitadata.getMuscleMassTotal());
		email.addToBodyDouble(getTextFromResource(R.string.muscle_mass_arm_left), tanitadata.getMuscleMassLeftArm());
		email.addToBodyDouble(getTextFromResource(R.string.muscle_mass_arm_right), tanitadata.getMuscleMassRightArm());
		email.addToBodyDouble(getTextFromResource(R.string.muscle_mass_leg_right), tanitadata.getMuscleMassRightLeg());
		email.addToBodyDouble(getTextFromResource(R.string.muscle_mass_leg_left), tanitadata.getMuscleMassLeftLeg());
		email.addToBodyDouble(getTextFromResource(R.string.muscle_mass_trunk), tanitadata.getMuscleMassTrunk());

		email.addToBodyInteger(getTextFromResource(R.string.physic_rating), tanitadata.getPhysicRating());
	}

	private String getDate() {
		DateFormat df = new SimpleDateFormat("yyyy - MM - dd", Locale.US);
		String date = df.format(tanitadata.getDate());
		return date;
	}

	private String getTextFromResource(int id) {
		Resources resources = activity.getResources();
		CharSequence text = resources.getString(id);
		return text.toString();
	}

	private String getSubject() {
		return tanitadata.toString();
	}

}

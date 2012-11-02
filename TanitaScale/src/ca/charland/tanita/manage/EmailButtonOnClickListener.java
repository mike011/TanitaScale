package ca.charland.tanita.manage;

import java.util.List;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import ca.charland.tanita.R;
import ca.charland.tanita.db.Data;
import ca.charland.tanita.db.PersonData;
import ca.charland.tanita.db.PersonDataSource;
import ca.charland.tanita.db.PersonDataTable;
import ca.charland.tanita.db.TanitaData;

/**
 * The listener interface for receiving emailButtonOnClick events. The class that is interested in processing a emailButtonOnClick event implements
 * this interface, and the object created with that class is registered with a component using the component's
 * <code>addEmailButtonOnClickListener<code> method. When
 * the emailButtonOnClick event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see EmailButtonOnClickEvent
 * 
 * @author mcharland
 */
public class EmailButtonOnClickListener implements OnClickListener {

	/** The activity. */
	private Activity activity;

	/** The Tanita data to input into the email. */
	private final TanitaData tanitadata;

	/**
	 * Instantiates a new email button on click listener.
	 * 
	 * @param activity
	 *            the activity
	 * @param td
	 *            The tanita data.
	 */
	EmailButtonOnClickListener(Activity activity, TanitaData td) {
		this.activity = activity;
		this.tanitadata = td;
	}

	/** {@inheritDoc} */
	@Override
	public void onClick(View v) {
		Intent intent = getEmail();
		sendEmail(intent);
	}

	/**
	 * Creates the email.
	 * 
	 * @return the intent
	 */
	private Intent getEmail() {
		Email email = new Email();
		email.setToAdress(getEmailToAddress());
		email.setSubject(getSubject());
		setEmailBody(email);
		return email.getIntent();
	}

	/**
	 * Send email.
	 * 
	 * @param intent
	 *            the intent
	 */
	private void sendEmail(Intent intent) {
		try {
			activity.startActivity(Intent.createChooser(intent, "Send mail..."));
		} catch (ActivityNotFoundException ex) {
			Toast.makeText(activity, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		}
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	private String getEmailToAddress() {
		PersonDataSource datasource = new PersonDataSource(activity);
		datasource.open();
		final List<Data> data = datasource.query(getSelection());
		PersonData pd = (PersonData) data.get(0);
		String email = pd.getEmail();

		datasource.close();

		return email;
	}

	/**
	 * Gets the selection.
	 * 
	 * @return the selection
	 */
	private String getSelection() {
		long person = tanitadata.getPerson();
		return PersonDataTable.Column.ID.toString() + " = " + person;
	}

	/**
	 * Gets the body.
	 * 
	 * @param email
	 *            THe email to use.
	 */
	private void setEmailBody(Email email) {

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

	/**
	 * Gets the text from resource.
	 *
	 * @param id the id
	 * @return the text from resource
	 */
	private String getTextFromResource(int id) {
		Resources resources = activity.getResources();
		CharSequence text = resources.getString(id);
		return text.toString();
	}

	/**
	 * Gets the subject.
	 * 
	 * @return the subject
	 */
	private String getSubject() {
		return tanitadata.toString();
	}

}

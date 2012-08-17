package ca.charland.tanita.manage;

import java.util.List;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import ca.charland.tanita.R;
import ca.charland.tanita.db.AbstractData;
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
	private final TanitaData td;

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
		this.td = td;
	}

	/** {@inheritDoc} */
	@Override
	public void onClick(View v) {
		Intent intent = createEmail();
		sendEmail(intent);
	}

	/**
	 * Creates the email.
	 *
	 * @return the intent
	 */
	private Intent createEmail() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("message/rfc822");
		intent.putExtra(Intent.EXTRA_EMAIL, new String[] { getEmail() });
		intent.putExtra(Intent.EXTRA_SUBJECT, getSubject());
		intent.putExtra(Intent.EXTRA_TEXT, getBody());
		return intent;
	}

	/**
	 * Send email.
	 *
	 * @param intent the intent
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
	private String getEmail() {
		/** The database source. */
		PersonDataSource datasource = new PersonDataSource(activity);
		datasource.open();
		final List<AbstractData> data = datasource.query(getSelection());
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
		long person = td.getPerson();
		return PersonDataTable.Column.ID.toString() + " = " + person;
	}

	/**
	 * Gets the body.
	 * 
	 * @return the body
	 */
	private String getBody() {
		String weight = String.valueOf(td.getWeight());
		String dci = String.valueOf(td.getDailyCaloricIntake());
		String metabolicAge = String.valueOf(td.getMetabolicAge());
		String bodyWaterPercentage = String.valueOf(td.getBodyWaterPercentage());
		String visceralFat = String.valueOf(td.getVisceralFat());
		String boneMass = String.valueOf(td.getBoneMass());

		String bodyFatTotal = String.valueOf(td.getBodyFatTotal());
		String bodyfatArmLeft = String.valueOf(td.getBodyFatLeftArm());
		String bodyFatArmRight = String.valueOf(td.getBodyFatRightArm());
		String bodyFatLegLeft = String.valueOf(td.getBodyFatLeftLeg());
		String bodyFatLegRight = String.valueOf(td.getBodyFatRightLeg());
		String bodyFatTrunk = String.valueOf(td.getBodyFatTrunk());

		String muscleMassTotal = String.valueOf(td.getMuscleMassTotal());
		String muscleMassArmLeft = String.valueOf(td.getMuscleMassLeftArm());
		String muscleMassArmRight = String.valueOf(td.getMuscleMassRightArm());
		String muscleMassLegRight = String.valueOf(td.getMuscleMassRightLeg());
		String muscleMassLegLeft = String.valueOf(td.getMuscleMassLeftLeg());
		String muscleMassTrunk = String.valueOf(td.getMuscleMassTrunk());

		String physicRating = String.valueOf(td.getPhysicRating());

		StringBuffer email = new StringBuffer();
		email.append(getLine(R.string.weight, weight));
		email.append(getLine(R.string.dci, dci));
		email.append(getLine(R.string.metabolic_age, metabolicAge));
		email.append(getLine(R.string.body_water_percentage, bodyWaterPercentage));
		email.append(getLine(R.string.visceral_fat, visceralFat));
		email.append(getLine(R.string.bone_mass, boneMass));
		email.append(getLine(R.string.body_fat_total, bodyFatTotal));
		email.append(getLine(R.string.body_fat_arm_left, bodyfatArmLeft));
		email.append(getLine(R.string.body_fat_arm_right, bodyFatArmRight));
		email.append(getLine(R.string.body_fat_leg_left, bodyFatLegLeft));
		email.append(getLine(R.string.body_fat_leg_right, bodyFatLegRight));
		email.append(getLine(R.string.body_fat_trunk, bodyFatTrunk));
		email.append(getLine(R.string.muscle_mass_total, muscleMassTotal));
		email.append(getLine(R.string.muscle_mass_arm_left, muscleMassArmLeft));
		email.append(getLine(R.string.muscle_mass_arm_right, muscleMassArmRight));
		email.append(getLine(R.string.muscle_mass_leg_right, muscleMassLegRight));
		email.append(getLine(R.string.muscle_mass_leg_left, muscleMassLegLeft));
		email.append(getLine(R.string.muscle_mass_trunk, muscleMassTrunk));
		email.append(getLine(R.string.physic_rating, physicRating));
		return email.toString();
	}

	/**
	 * A quick format to make the lines outputted to the email body consistent.
	 * 
	 * @param id
	 *            the id
	 * @param extracted
	 *            (value) the value
	 * @return the line
	 */
	private String getLine(int id, String value) {
		StringBuffer line = new StringBuffer();
		line.append(activity.getResources().getText(id).toString());
		line.append(" = ");
		line.append(value);
		line.append('\n');
		return line.toString();
	}

	/**
	 * Gets the subject.
	 * 
	 * @return the subject
	 */
	private String getSubject() {
		return td.toString();
	}

}

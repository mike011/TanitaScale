package ca.charland.tanita.manage;

import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.widget.TextView;
import ca.charland.tanita.R;
import ca.charland.tanita.db.AbstractData;
import ca.charland.tanita.db.TanitaData;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class PersonDateActivity which shows the data entered for a specific date.
 * 
 * @author mcharland.
 */
public class PersonDateActivity extends RoboActivity {

	/** The weight. */
	@InjectView(R.id.weight)
	private TextView weight;

	/** The dci. */
	@InjectView(R.id.dci)
	private TextView dci;
	
	/** The metabolic age. */
	@InjectView(R.id.metabolic_age)
	private TextView metabolicAge;

	/** The body water percentage. */
	@InjectView(R.id.body_water_percentage)
	private TextView bodyWaterPercentage;

	/** The visceral fat. */
	@InjectView(R.id.visceral_fat)
	private TextView visceralFat;

	/** The bone mass. */
	@InjectView(R.id.bone_mass)
	private TextView boneMass;

	/** The body fat total. */
	@InjectView(R.id.body_fat_total)
	private TextView bodyFatTotal;

	/** The body fat arm left. */
	@InjectView(R.id.body_fat_arm_left)
	private TextView bodyfatArmLeft;

	/** The body fat arm right. */
	@InjectView(R.id.body_fat_arm_right)
	private TextView bodyFatArmRight;
	
	/** The body fat leg left. */
	@InjectView(R.id.body_fat_leg_left)
	private TextView bodyFatLegLeft;

	/** The body fat leg right. */
	@InjectView(R.id.body_fat_leg_right)
	private TextView bodyFatLegRight;

	/** The body fat trunk. */
	@InjectView(R.id.body_fat_trunk)
	private TextView bodyFatTrunk;

	/** The muscle mass total. */
	@InjectView(R.id.muscle_mass_total)
	private TextView muscleMassTotal;

	/** The muscle mass arm left. */
	@InjectView(R.id.muscle_mass_arm_left)
	private TextView muscleMassArmLeft;

	/** The muscle mass arm right. */
	@InjectView(R.id.muscle_mass_arm_right)
	private TextView muscleMassArmRight;

	/** The muscle mass leg right. */
	@InjectView(R.id.muscle_mass_leg_right)
	private TextView muscleMassLegRight;

	/** The muscle mass leg left. */
	@InjectView(R.id.muscle_mass_leg_left)
	private TextView muscleMassLegLeft;

	/** The muscle mass trunk. */
	@InjectView(R.id.muscle_mass_trunk)
	private TextView muscleMassTrunk;

	/** The physic rating. */
	@InjectView(R.id.physic_rating)
	private TextView physicRating;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.person_date);

		TanitaDataSource datasource = new TanitaDataSource(this);
		datasource.open();
		Bundle extras = getIntent().getExtras();
		String selection = TanitaDataTable.Column.ID.toString() + " = " + extras.getInt(DateListActivity.ID);

		List<AbstractData> data = datasource.query(selection);
		TanitaData td = (TanitaData) data.get(0);

		weight.setText(String.valueOf(td.getWeight()));
		dci.setText(String.valueOf(td.getDailyCaloricIntake()));
		metabolicAge.setText(String.valueOf(td.getMetabolicAge()));
		bodyWaterPercentage.setText(String.valueOf(td.getBodyWaterPercentage()));
		visceralFat.setText(String.valueOf(td.getVisceralFat()));
		boneMass.setText(String.valueOf(td.getBoneMass()));
		
		bodyFatTotal.setText(String.valueOf(td.getBodyFatTotal()));
		bodyfatArmLeft.setText(String.valueOf(td.getBodyFatLeftArm()));
		bodyFatArmRight.setText(String.valueOf(td.getBodyFatRightArm()));
		bodyFatLegLeft.setText(String.valueOf(td.getBodyFatLeftLeg()));
		bodyFatLegRight.setText(String.valueOf(td.getBodyFatLeftLeg()));
		bodyFatTrunk.setText(String.valueOf(td.getBodyFatTrunk()));
		
		muscleMassTotal.setText(String.valueOf(td.getMuscleMassTotal()));
		muscleMassArmLeft.setText(String.valueOf(td.getMuscleMassLeftArm()));
		muscleMassArmRight.setText(String.valueOf(td.getMuscleMassRightArm()));
		muscleMassLegRight.setText(String.valueOf(td.getMuscleMassRightLeg()));
		muscleMassLegLeft.setText(String.valueOf(td.getMuscleMassLeftLeg()));
		muscleMassTrunk.setText(String.valueOf(td.getMuscleMassTrunk()));
		
		physicRating.setText(String.valueOf(td.getPhysicRating()));

		datasource.close();
	}
}

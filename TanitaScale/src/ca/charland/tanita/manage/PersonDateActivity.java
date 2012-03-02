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

	@InjectView(R.id.weight)
	private TextView weight;
	
	@InjectView(R.id.metabolic_age)
	private TextView metabolicAge;
	
	@InjectView(R.id.body_water_percentage)
	private TextView bodyWaterPercentage;
	
	@InjectView(R.id.visceral_fat)
	private TextView visceralFat;
	
	@InjectView(R.id.bone_mass)
	private TextView boneMass;
	
	@InjectView(R.id.body_fat_total)
	private TextView bodyFatTotal;
	
	@InjectView(R.id.body_fat_arm_left)
	private TextView bodyfatArmLeft;
	
	@InjectView(R.id.body_fat_arm_right)
	private TextView bodyFatArmRight;
	
	@InjectView(R.id.body_fat_leg_right)
	private TextView bodyFatLegRight;
	
	@InjectView(R.id.body_fat_trunk)
	private TextView bodyFatTrunk;
	
	@InjectView(R.id.muscle_mass_total)
	private TextView muscleMassTotal;
	
	@InjectView(R.id.muscle_mass_arm_left)
	private TextView muscleMassArmLeft;
	
	@InjectView(R.id.muscle_mass_arm_right)
	private TextView muscleMassArmRight;
	
	@InjectView(R.id.muscle_mass_leg_right)
	private TextView muscleMassLegRight;
	
	@InjectView(R.id.muscle_mass_leg_left)
	private TextView muscleMassLegLeft;
	
	@InjectView(R.id.muscle_mass_trunk)
	private TextView muscleMassTrunk;
	
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
		datasource.close();
	}
}

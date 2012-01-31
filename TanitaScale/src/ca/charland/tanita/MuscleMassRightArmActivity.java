package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class MuscleMassRightArmActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.muscle_mass_right_arm)
public class MuscleMassRightArmActivity extends AbstractNextActivity {

	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return MuscleMassRightLegActivity.class;
	}
}

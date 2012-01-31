package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class MuscleMassLeftArmActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.muscle_mass_left_arm)
public class MuscleMassLeftArmActivity extends AbstractNextActivity {
	
	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return MuscleMassRightArmActivity.class;
	}
}

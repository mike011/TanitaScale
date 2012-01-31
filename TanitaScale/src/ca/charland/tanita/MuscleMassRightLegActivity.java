package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class MuscleMassRightLegActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.muscle_mass_right_leg)
public class MuscleMassRightLegActivity extends AbstractNextActivity {

	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return MuscleMassLeftLegActivity.class;
	}
}

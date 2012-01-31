package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class MuscleMassLeftLegActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.muscle_mass_left_leg)
public class MuscleMassLeftLegActivity extends AbstractNextActivity {

	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return MuscleMassTrunkActivity.class;
	}
}

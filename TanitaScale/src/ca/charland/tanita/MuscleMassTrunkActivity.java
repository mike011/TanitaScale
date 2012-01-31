package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class MuscleMassTrunkActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.muscle_mass_trunk)
public class MuscleMassTrunkActivity extends AbstractNextActivity {
	
	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return PhysicRatingActivity.class;
	}
}

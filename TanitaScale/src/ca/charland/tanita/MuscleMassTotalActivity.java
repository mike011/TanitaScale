package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class MuscleMassTotalActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.muscle_mass_total)
public class MuscleMassTotalActivity extends AbstractNextActivity {

	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return MuscleMassLeftArmActivity.class;
	}
}

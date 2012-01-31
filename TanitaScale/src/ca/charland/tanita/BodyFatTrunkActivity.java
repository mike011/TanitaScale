package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class BodyFatTrunkActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.body_fat_trunk)
public class BodyFatTrunkActivity extends AbstractNextActivity {

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MuscleMassTotalActivity.class;
	}
}

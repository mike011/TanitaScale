package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class BodyFatLeftLegActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.body_fat_left_leg)
public class BodyFatLeftLegActivity extends AbstractNextActivity {

	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return BodyFatTrunkActivity.class;
	}
}

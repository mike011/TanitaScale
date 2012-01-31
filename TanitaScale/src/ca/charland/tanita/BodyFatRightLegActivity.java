package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class BodyFatRightLegActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.body_fat_right_leg)
public class BodyFatRightLegActivity extends AbstractNextActivity {

	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return BodyFatLeftLegActivity.class;
	}
}

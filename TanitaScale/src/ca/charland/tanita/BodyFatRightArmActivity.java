package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class BodyFatRightArmActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.body_fat_right_arm)
public class BodyFatRightArmActivity extends AbstractNextActivity {

	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return BodyFatRightLegActivity.class;
	}
}

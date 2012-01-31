package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class BodyFatLeftArmActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.body_fat_left_arm)
public class BodyFatLeftArmActivity extends AbstractNextActivity {
	
	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return BodyFatRightArmActivity.class;
	}
}

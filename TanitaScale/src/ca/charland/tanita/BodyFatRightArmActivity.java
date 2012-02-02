package ca.charland.tanita;

import roboguice.inject.ContentView;
import android.content.ContentValues;

/**
 * The Class BodyFatRightArmActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.body_fat_right_arm)
public class BodyFatRightArmActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyFatRightLegActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		return null;
	}
}

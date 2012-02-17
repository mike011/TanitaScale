package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class BodyFatRightArmActivity.
 * 
 * @author mcharland
 */
public class BodyFatRightArmActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.body_fat_right_arm;
	}
	
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

package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class BodyFatLeftArmActivity.
 * 
 * @author mcharland
 */
public class BodyFatLeftArmActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.body_fat_left_arm;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyFatRightArmActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}

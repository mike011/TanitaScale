package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class BodyFatRightLegActivity.
 * 
 * @author mcharland
 */
public class BodyFatRightLegActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.body_fat_right_leg;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyFatLeftLegActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		return null;
	}
}

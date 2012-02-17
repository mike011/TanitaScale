package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class BodyFatLeftLegActivity.
 * 
 * @author mcharland
 */
public class BodyFatLeftLegActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.body_fat_left_leg;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyFatTrunkActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}

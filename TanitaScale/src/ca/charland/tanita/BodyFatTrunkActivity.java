package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class BodyFatTrunkActivity.
 * 
 * @author mcharland
 */
public class BodyFatTrunkActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.body_fat_trunk;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MuscleMassTotalActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		return null;
	}
}

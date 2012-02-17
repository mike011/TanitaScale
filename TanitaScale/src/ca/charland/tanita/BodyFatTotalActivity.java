package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class BodyFatTotalActivity.
 * 
 * @author mcharland
 */
public class BodyFatTotalActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.body_fat_total;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyFatLeftArmActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		return null;
	}
}

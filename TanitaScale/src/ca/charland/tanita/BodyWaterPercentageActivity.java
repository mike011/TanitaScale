package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class BodyWaterPercentageActivity.
 * 
 * @author mcharland
 */
public class BodyWaterPercentageActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.body_water_percentage;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return VisceralFatActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}

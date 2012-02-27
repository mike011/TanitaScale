package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class MetabolicAgeActivity.
 * 
 * @author mcharland
 */
public class MetabolicAgeActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.metabolic_age;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyWaterPercentageActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		return null;
	}
}

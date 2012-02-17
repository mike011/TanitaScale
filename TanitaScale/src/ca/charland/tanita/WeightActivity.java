package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class WeightActivity.
 * 
 * @author mcharland
 */
public class WeightActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.weight;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return DCIActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}

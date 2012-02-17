package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class DCIActivity.
 * 
 * @author mcharland
 */
public class DCIActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.dci;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MetabolicAgeActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		return null;
	}
}

package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class VisceralFatActivity.
 * 
 * @author mcharland
 */
public class VisceralFatActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.visceral_fat;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BoneMassActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}

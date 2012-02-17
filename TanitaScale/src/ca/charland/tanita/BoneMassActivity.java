package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class BoneMassActivity.
 * 
 * @author mcharland
 */
public class BoneMassActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.bone_mass;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyFatTotalActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}

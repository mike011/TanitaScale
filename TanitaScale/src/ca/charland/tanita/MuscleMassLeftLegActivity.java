package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class MuscleMassLeftLegActivity.
 * 
 * @author mcharland
 */
public class MuscleMassLeftLegActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.muscle_mass_left_leg;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MuscleMassTrunkActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}

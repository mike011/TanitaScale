package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class MuscleMassRightLegActivity.
 * 
 * @author mcharland
 */
public class MuscleMassRightLegActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.muscle_mass_right_leg;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MuscleMassLeftLegActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}

package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class MuscleMassRightArmActivity.
 * 
 * @author mcharland
 */
public class MuscleMassRightArmActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.muscle_mass_right_arm;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MuscleMassRightLegActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}

package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class MuscleMassLeftArmActivity.
 * 
 * @author mcharland
 */
public class MuscleMassLeftArmActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.muscle_mass_left_arm;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MuscleMassRightArmActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}

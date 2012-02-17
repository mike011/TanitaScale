package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class MuscleMassTrunkActivity.
 * 
 * @author mcharland
 */
public class MuscleMassTrunkActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.muscle_mass_trunk;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return PhysicRatingActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		return null;
	}
}

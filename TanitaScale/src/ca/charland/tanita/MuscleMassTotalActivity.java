package ca.charland.tanita;

import android.content.ContentValues;

/**
 * The Class MuscleMassTotalActivity.
 * 
 * @author mcharland
 */
public class MuscleMassTotalActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.muscle_mass_total;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MuscleMassLeftArmActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}

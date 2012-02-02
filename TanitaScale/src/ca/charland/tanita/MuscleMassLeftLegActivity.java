package ca.charland.tanita;

import roboguice.inject.ContentView;
import android.content.ContentValues;

/**
 * The Class MuscleMassLeftLegActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.muscle_mass_left_leg)
public class MuscleMassLeftLegActivity extends AbstractBaseActivity {

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

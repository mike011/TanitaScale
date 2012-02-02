package ca.charland.tanita;

import roboguice.inject.ContentView;
import android.content.ContentValues;

/**
 * The Class MuscleMassRightLegActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.muscle_mass_right_leg)
public class MuscleMassRightLegActivity extends AbstractBaseActivity {

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

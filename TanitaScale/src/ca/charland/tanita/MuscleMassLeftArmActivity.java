package ca.charland.tanita;

import roboguice.inject.ContentView;
import android.content.ContentValues;

/**
 * The Class MuscleMassLeftArmActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.muscle_mass_left_arm)
public class MuscleMassLeftArmActivity extends AbstractBaseActivity {

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

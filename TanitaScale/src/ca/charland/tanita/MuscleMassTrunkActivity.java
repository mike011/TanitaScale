package ca.charland.tanita;

import roboguice.inject.ContentView;
import android.content.ContentValues;

/**
 * The Class MuscleMassTrunkActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.muscle_mass_trunk)
public class MuscleMassTrunkActivity extends AbstractBaseActivity {

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

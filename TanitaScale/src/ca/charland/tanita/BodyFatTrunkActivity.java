package ca.charland.tanita;

import roboguice.inject.ContentView;
import android.content.ContentValues;

/**
 * The Class BodyFatTrunkActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.body_fat_trunk)
public class BodyFatTrunkActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MuscleMassTotalActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		return null;
	}
}

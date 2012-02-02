package ca.charland.tanita;

import roboguice.inject.ContentView;
import android.content.ContentValues;

/**
 * The Class BodyFatRightLegActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.body_fat_right_leg)
public class BodyFatRightLegActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyFatLeftLegActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		return null;
	}
}

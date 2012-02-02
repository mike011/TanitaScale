package ca.charland.tanita;

import roboguice.inject.ContentView;
import android.content.ContentValues;

/**
 * The Class MetabolicAgeActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.metabolic_age)
public class MetabolicAgeActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyWaterPercentageActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}

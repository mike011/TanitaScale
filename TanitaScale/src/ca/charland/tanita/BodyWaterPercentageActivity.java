package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class BodyWaterPercentageActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.body_water_percentage)
public class BodyWaterPercentageActivity extends AbstractNextActivity {
	
	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return VisceralFatActivity.class;
	}
}

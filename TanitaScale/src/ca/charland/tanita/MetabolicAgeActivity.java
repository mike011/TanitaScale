package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class MetabolicAgeActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.metabolic_age)
public class MetabolicAgeActivity extends AbstractNextActivity {

	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return BodyWaterPercentageActivity.class;
	}
}

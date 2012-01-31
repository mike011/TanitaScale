package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class WeightActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.weight)
public class WeightActivity extends AbstractNextActivity {

	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return DCIActivity.class;
	}
}

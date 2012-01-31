package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class DCIActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.dci)
public class DCIActivity extends AbstractNextActivity {
	
	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return MetabolicAgeActivity.class;
	}
}

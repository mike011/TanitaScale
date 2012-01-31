package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class VisceralFatActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.visceral_fat)
public class VisceralFatActivity extends AbstractNextActivity {

	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return BoneMassActivity.class;
	}
}

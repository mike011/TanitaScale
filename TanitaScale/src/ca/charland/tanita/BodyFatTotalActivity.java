package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class BodyFatTotalActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.body_fat_total)
public class BodyFatTotalActivity extends AbstractNextActivity {

	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return BodyFatLeftArmActivity.class;
	}
}

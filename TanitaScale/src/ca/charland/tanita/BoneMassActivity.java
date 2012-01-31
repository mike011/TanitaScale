package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class BoneMassActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.bone_mass)
public class BoneMassActivity extends AbstractNextActivity {

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyFatTotalActivity.class;
	}
}

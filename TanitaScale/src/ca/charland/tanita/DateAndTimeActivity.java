package ca.charland.tanita;

import roboguice.inject.ContentView;

/**
 * The Class DataAndTimeActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.date)
public class DateAndTimeActivity extends AbstractNextActivity {

	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return WeightActivity.class;
	}
}

package ca.charland.tanita.base.activity.manage;

import roboguice.activity.RoboActivity;
import android.os.Bundle;
import ca.charland.tanita.R;

/**
 * Shows the data entered for a specific date.
 * 
 * @author mcharland.
 */
public abstract class BaseSingleDateValuesEnteredActivity extends RoboActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.person_date);
	}
}

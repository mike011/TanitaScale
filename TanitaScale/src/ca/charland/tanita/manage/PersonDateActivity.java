package ca.charland.tanita.manage;

import ca.charland.tanita.R;
import android.os.Bundle;
import roboguice.activity.RoboActivity;

/**
 * The Class PersonDateActivity which shows the data entered for a specific date.
 * 
 * @author mcharland.
 */
public class PersonDateActivity extends RoboActivity {

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.person_date);
	}
}

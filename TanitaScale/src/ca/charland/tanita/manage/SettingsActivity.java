package ca.charland.tanita.manage;

import android.os.Bundle;
import ca.charland.tanita.R;
import roboguice.activity.RoboActivity;

public class SettingsActivity extends RoboActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
	}
}

package ca.charland.tanita.manage;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import ca.charland.tanita.DateAndTimeActivity;
import ca.charland.tanita.R;

/**
 * The Class PickActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.pick)
public class PickActivity extends RoboActivity {

	/** The next button. */
	@InjectView(R.id.add)
	Button add;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		add.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(),
						DateAndTimeActivity.class));
			}
		});
	}
}

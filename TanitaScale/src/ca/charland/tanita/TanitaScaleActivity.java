package ca.charland.tanita;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * The Class TanitaScaleActivity this is the first screen you will see and will
 * allow you basic account maintenance.
 * 
 * @author mcharland
 */
@ContentView(R.layout.main)
public class TanitaScaleActivity extends RoboActivity {
	@InjectView(R.id.add)
	Button add;

	@InjectView(R.id.view)
	Button view;

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState
	 *            the saved instance state
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		add.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				startActivity(new Intent(getBaseContext(), AddActivity.class));
			}
		});

		view.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				startActivity(new Intent(getBaseContext(), ViewActivity.class));
			}
		});
	}
}
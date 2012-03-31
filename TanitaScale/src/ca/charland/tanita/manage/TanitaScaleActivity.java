package ca.charland.tanita.manage;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import ca.charland.tanita.R;

/**
 * The Class TanitaScaleActivity this is the first screen you will see and will allow you basic account maintenance.
 * 
 * @author mcharland
 */
public class TanitaScaleActivity extends RoboActivity {

	/** The add button. */
	@InjectView(R.id.add)
	private Button add;

	/** The view button. */
	@InjectView(R.id.view)
	private Button view;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		add.setOnClickListener(new OnClickListener() {

			/** {@inheritDoc} */
			public void onClick(View view) {
				startActivity(new Intent(getBaseContext(), AddActivity.class));
			}
		});

		view.setOnClickListener(new OnClickListener() {

			/** {@inheritDoc} */
			public void onClick(View view) {
				startActivity(new Intent(getBaseContext(), PeopleListActivity.class));
			}
		});
	}
	
	/** {@inheritDoc} */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// replaces the default 'Back' button action
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			finish();
            System.exit(0);
		}
		return true;
	}
}
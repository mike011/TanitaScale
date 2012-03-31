package ca.charland.tanita.manage;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import ca.charland.tanita.DateAndTimeActivity;
import ca.charland.tanita.R;

/**
 * This is the first person specific screen which allows you to choose what you want to do.
 * 
 * @author mcharland
 */
public class PersonHomeActivity extends RoboActivity {

	/** The next button. */
	@InjectView(R.id.add)
	private Button add;

	/** The view button. */
	@InjectView(R.id.view)
	private Button view;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.person_home);
		add.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), DateAndTimeActivity.class);
				Bundle extras = getIntent().getExtras();
				intent.putExtra(PeopleListActivity.PERSON_ID, extras.getInt(PeopleListActivity.PERSON_ID));
				startActivity(intent);
			}
		});

		view.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), DateListActivity.class);
				Bundle extras = getIntent().getExtras();
				intent.putExtra(PeopleListActivity.PERSON_ID, extras.getInt(PeopleListActivity.PERSON_ID));
				startActivity(intent);
			}			
		});
	}

	/** {@inheritDoc} */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// replaces the default 'Back' button action
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			this.startActivity(new Intent(this, PeopleListActivity.class));
		}
		return true;
	}
}

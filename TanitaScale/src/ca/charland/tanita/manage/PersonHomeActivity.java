package ca.charland.tanita.manage;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import ca.charland.tanita.DateAndTimeActivity;
import ca.charland.tanita.R;

/**
 * This is the first person specific screen which allows you to choose what you want to do.
 * 
 * @author mcharland
 */
public class PersonHomeActivity extends RoboActivity {

	@InjectView(R.id.add)
	private Button add;

	@InjectView(R.id.view)
	private Button view;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.person_home);
		setOnClickListeners();
	}

	private void setOnClickListeners() {
		add.setOnClickListener(getOnClickListener(true));
		view.setOnClickListener(getOnClickListener(false));
	}

	private OnClickListener getOnClickListener(final boolean add) {
		return new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Class<?> nextClass = DateListOfPreviousEntriesActivity.class;
				if (add) {
					nextClass = DateAndTimeActivity.class;
				}
				startActivity(getActivity(getBaseContext(), getIntent(), nextClass));
			}
		};
	}

	private static Intent getActivity(Context context, Intent oldIntent, Class<?> nextClass) {
		Intent intent = new Intent(context, nextClass);
		Bundle extras = oldIntent.getExtras();
		intent.putExtra(AllPeopleListActivity.PERSON_ID, extras.getInt(AllPeopleListActivity.PERSON_ID));
		return intent;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// replaces the default 'Back' button action
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent(this, AllPeopleListActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

			startActivity(intent);
			finish();
		}
		return true;
	}
}

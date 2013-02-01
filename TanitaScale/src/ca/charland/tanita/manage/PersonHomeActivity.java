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
	
	private PersonHomeActivityDataHolder activityData;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.person_home);
		activityData = new PersonHomeActivityDataHolder();
		setOnClickListeners();
	}

	private void setOnClickListeners() {
		add.setOnClickListener(getOnClickListener(activityData.getNextAddClass()));
		view.setOnClickListener(getOnClickListener(activityData.getNextViewClass()));
	}

	private OnClickListener getOnClickListener(final Class<?> nextClass) {
		return new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
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
			activityData.onKeyBackDown(this);
		}
		return true;
	}
}

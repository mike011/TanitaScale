package ca.charland.activity.manage;

import android.app.Activity;
import android.content.Intent;
import ca.charland.R;
import ca.charland.tanita.DateAndTimeActivity;
import ca.charland.tanita.manage.AllPeopleListActivity;
import ca.charland.tanita.manage.DateListOfPreviousEntriesActivity;

public class PersonHomeActivityDataHolder implements MultipleActivityData {

	@Override
	public int getAdd() {
		return R.string.add;
	}

	@Override
	public int getView() {
		return R.string.view;
	}

	@Override
	public Class<?> getNextAddClass() {
		return DateAndTimeActivity.class;
	}

	@Override
	public Class<?> getNextViewClass() {
		return DateListOfPreviousEntriesActivity.class;
	}
	
	@Override
	public void onKeyBackDown(Activity activity) {
		Intent intent = new Intent(activity, AllPeopleListActivity.class);
		activity.startActivity(intent);
		activity.finish();
	}

}

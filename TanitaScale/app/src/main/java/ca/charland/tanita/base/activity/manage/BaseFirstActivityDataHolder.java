package ca.charland.tanita.base.activity.manage;

import android.app.Activity;
import ca.charland.tanita.R;

public abstract class BaseFirstActivityDataHolder implements MultipleActivityData {

	@Override
	public int getAdd() {
		return R.string.add_new_person;
	}

	@Override
	public int getView() {
		return R.string.view_person;
	}

	@Override
	public void onKeyBackDown(Activity activity) {
		exit(activity);		
	}

	public static void exit(Activity activity) {
		activity.finish();
		System.exit(0);
	}

	@Override
	public Class<?> getNextAddClass() {
		return BaseAddANewPersonActivity.class;
	}
}

package ca.charland.activity.manage;

import android.app.Activity;

public interface MultipleActivityData {
	int getAdd();

	int getView();

	Class<?> getNextAddClass();

	Class<?> getNextViewClass();

	void onKeyBackDown(Activity activity);
}

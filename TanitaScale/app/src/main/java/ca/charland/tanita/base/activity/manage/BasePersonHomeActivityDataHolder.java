package ca.charland.tanita.base.activity.manage;

import android.app.Activity;
import android.content.Intent;
import ca.charland.tanita.R;

public abstract class BasePersonHomeActivityDataHolder implements MultipleActivityData {

	@Override
	public int getAdd() {
		return R.string.add;
	}

	@Override
	public int getView() {
		return R.string.view;
	}

	@Override
	public void onKeyBackDown(Activity activity) {
		Intent intent = new Intent(activity, getNextClass());
		activity.startActivity(intent);
		activity.finish();
	}

	protected abstract Class<?> getNextClass();

}

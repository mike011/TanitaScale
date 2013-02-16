package ca.charland.tanita.manage;

import ca.charland.activity.manage.BaseFirstActivity;
import ca.charland.activity.manage.BaseFirstActivityDataHolder;
import ca.charland.activity.manage.BasePersonHomeActivityDataHolder;

public class FirstActivity extends BaseFirstActivity {
	
	@Override
	protected BasePersonHomeActivityDataHolder getSingleUserModeDataHolder() {
		return new PersonHomeActivityDataHolder();
	}

	@Override
	protected BaseFirstActivityDataHolder getMultipleUserModeDataHolder() {
		return new FirstActivityDataHolder();
	}

}

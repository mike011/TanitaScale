package ca.charland.tanita.manage;

import ca.charland.tanita.base.activity.manage.BaseFirstActivity;
import ca.charland.tanita.base.activity.manage.BaseFirstActivityDataHolder;
import ca.charland.tanita.base.activity.manage.BasePersonHomeActivityDataHolder;

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

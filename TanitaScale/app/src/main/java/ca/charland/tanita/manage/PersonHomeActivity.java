package ca.charland.tanita.manage;

import ca.charland.tanita.base.activity.manage.BasePersonHomeActivity;
import ca.charland.tanita.base.activity.manage.BasePersonHomeActivityDataHolder;

public class PersonHomeActivity extends BasePersonHomeActivity{

	@Override
	protected BasePersonHomeActivityDataHolder getPersonHomActivityDataHolder() {
		return new PersonHomeActivityDataHolder();
	}

}

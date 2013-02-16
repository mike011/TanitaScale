package ca.charland.tanita.manage;

import ca.charland.activity.manage.BasePersonHomeActivity;
import ca.charland.activity.manage.BasePersonHomeActivityDataHolder;

public class PersonHomeActivity extends BasePersonHomeActivity{

	@Override
	protected BasePersonHomeActivityDataHolder getPersonHomActivityDataHolder() {
		return new PersonHomeActivityDataHolder();
	}

}

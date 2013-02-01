package ca.charland.tanita.manage;

import ca.charland.activity.manage.PersonHomeActivity;
import ca.charland.activity.manage.PersonHomeActivityDataHolder;

public class TanitaPersonHomeActivity extends PersonHomeActivity{

	@Override
	protected PersonHomeActivityDataHolder getPersonHomActivityDataHolder() {
		return new TanitaPersonHomeActivityDataHolder();
	}

}

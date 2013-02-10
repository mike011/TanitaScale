package ca.charland.tanita.manage;

import ca.charland.activity.manage.BaseFirstActivity;
import ca.charland.activity.manage.FirstActivityDataHolder;
import ca.charland.activity.manage.PersonHomeActivityDataHolder;

public class TanitaFirstActivity extends BaseFirstActivity {
	
	@Override
	protected PersonHomeActivityDataHolder getSingleUserModeDataHolder() {
		return new TanitaPersonHomeActivityDataHolder();
	}

	@Override
	protected FirstActivityDataHolder getMultipleUserModeDataHolder() {
		return new TanitaFirstActivityDataHolder();
	}

}

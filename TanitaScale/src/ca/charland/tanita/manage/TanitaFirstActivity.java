package ca.charland.tanita.manage;

import ca.charland.activity.manage.FirstActivity;
import ca.charland.activity.manage.FirstActivityDataHolder;
import ca.charland.activity.manage.PersonHomeActivityDataHolder;

public class TanitaFirstActivity extends FirstActivity {
	
	@Override
	protected PersonHomeActivityDataHolder getSingleUserModeDataHolder() {
		return new TanitaPersonHomeActivityDataHolder();
	}

	@Override
	protected FirstActivityDataHolder getMultipleUserModeDataHolder() {
		return new TanitaFirstActivityDataHolder();
	}

}

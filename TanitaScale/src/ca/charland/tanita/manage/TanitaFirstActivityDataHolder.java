package ca.charland.tanita.manage;

import ca.charland.activity.manage.FirstActivityDataHolder;

public class TanitaFirstActivityDataHolder extends FirstActivityDataHolder {

	@Override
	public Class<?> getNextAddClass() {
		return TanitaAddANewPersonActivity.class;
	}

	@Override
	public Class<?> getNextViewClass() {
		return TanitaAllPeopleListActivity.class;
	}
}

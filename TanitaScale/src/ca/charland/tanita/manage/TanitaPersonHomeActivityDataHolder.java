package ca.charland.tanita.manage;

import ca.charland.activity.manage.PersonHomeActivityDataHolder;
import ca.charland.tanita.TanitaDateAndTimeActivity;

public class TanitaPersonHomeActivityDataHolder extends PersonHomeActivityDataHolder {

	@Override
	public Class<?> getNextAddClass() {
		return TanitaDateAndTimeActivity.class;
	}

	@Override
	public Class<?> getNextViewClass() {
		return TanitaDateListOfPreviousEntriesActivity.class;
	}

	@Override
	protected Class<?> getNextClass() {
		return TanitaAllPeopleListActivity.class;
	}
}

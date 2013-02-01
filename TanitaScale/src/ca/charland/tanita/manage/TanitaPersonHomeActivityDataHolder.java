package ca.charland.tanita.manage;

import ca.charland.activity.manage.DateListOfPreviousEntriesActivity;
import ca.charland.activity.manage.PersonHomeActivityDataHolder;
import ca.charland.tanita.DateAndTimeActivity;

public class TanitaPersonHomeActivityDataHolder extends PersonHomeActivityDataHolder {

	@Override
	public Class<?> getNextAddClass() {
		return DateAndTimeActivity.class;
	}

	@Override
	public Class<?> getNextViewClass() {
		return DateListOfPreviousEntriesActivity.class;
	}
}

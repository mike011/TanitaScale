package ca.charland.tanita.manage;

import ca.charland.tanita.DateAndTimeActivity;
import ca.charland.tanita.base.activity.manage.BasePersonHomeActivityDataHolder;

public class PersonHomeActivityDataHolder extends BasePersonHomeActivityDataHolder {

	@Override
	public Class<?> getNextAddClass() {
		return DateAndTimeActivity.class;
	}

	@Override
	public Class<?> getNextViewClass() {
		return DateListOfPreviousEntriesActivity.class;
	}

	@Override
	protected Class<?> getNextClass() {
		return AllPeopleListActivity.class;
	}
}

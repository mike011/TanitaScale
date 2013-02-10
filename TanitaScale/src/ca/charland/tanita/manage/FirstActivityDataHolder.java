package ca.charland.tanita.manage;

import ca.charland.activity.manage.BaseFirstActivityDataHolder;

public class FirstActivityDataHolder extends BaseFirstActivityDataHolder {

	@Override
	public Class<?> getNextAddClass() {
		return AddANewPersonActivity.class;
	}

	@Override
	public Class<?> getNextViewClass() {
		return AllPeopleListActivity.class;
	}
}

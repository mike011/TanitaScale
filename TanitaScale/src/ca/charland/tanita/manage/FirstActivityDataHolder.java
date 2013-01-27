package ca.charland.tanita.manage;

import ca.charland.tanita.R;

public class FirstActivityDataHolder extends MultipleActivityData {

	@Override
	public int getAdd() {
		return R.string.add_new_person;
	}

	@Override
	public int getView() {
		return R.string.view_person;
	}

	@Override
	public Class<?> getNextAddClass() {
		return AddANewPersonActivity.class;
	}

	@Override
	public Class<?> getNextViewClass() {
		return AllPeopleListActivity.class;
	}
}

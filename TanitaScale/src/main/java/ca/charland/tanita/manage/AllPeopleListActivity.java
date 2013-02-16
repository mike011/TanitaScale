package ca.charland.tanita.manage;

import ca.charland.activity.manage.BaseAllPeopleListActivity;
import ca.charland.db.AbstractPersonDataSource;
import ca.charland.tanita.db.PersonDataSource;

public class AllPeopleListActivity extends BaseAllPeopleListActivity {

	@Override
	protected Class<?> getFirstClass() {
		return FirstActivity.class;
	}

	@Override
	protected AbstractPersonDataSource getPersonDataSource() {
		return new PersonDataSource(this);
	}

	@Override
	protected Class<?> getHomeActivity() {
		return PersonHomeActivity.class;
	}
}

package ca.charland.tanita.manage;

import ca.charland.activity.manage.AllPeopleListActivity;
import ca.charland.db.AbstractPersonDataSource;
import ca.charland.tanita.db.PersonDataSource;

public class TanitaAllPeopleListActivity extends AllPeopleListActivity {

	@Override
	protected Class<?> getFirstClass() {
		return TanitaFirstActivity.class;
	}

	@Override
	protected AbstractPersonDataSource getPersonDataSource() {
		return new PersonDataSource(this);
	}

	@Override
	protected Class<?> getHomeActivity() {
		return TanitaPersonHomeActivity.class;
	}
}

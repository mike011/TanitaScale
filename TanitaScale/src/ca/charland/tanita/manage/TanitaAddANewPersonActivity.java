package ca.charland.tanita.manage;

import ca.charland.activity.manage.AddANewPersonActivity;
import ca.charland.tanita.db.PersonDataSource;

public class TanitaAddANewPersonActivity extends AddANewPersonActivity {

	@Override
	protected PersonDataSource getDataSource() {
		return new PersonDataSource(this);
	}

}

package ca.charland.tanita.manage;

import ca.charland.activity.manage.DateListOfPreviousEntriesActivity;
import ca.charland.tanita.db.DateListDataSource;

public class TanitaDateListOfPreviousEntriesActivity extends DateListOfPreviousEntriesActivity {

	@Override
	protected DateListDataSource getDataListDataSource() {
		return new DateListDataSource(this);
	}
}

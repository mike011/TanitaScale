package ca.charland.tanita.manage;

import ca.charland.activity.manage.DateListOfPreviousEntriesActivity;
import ca.charland.tanita.db.TanitaDateListDataSource;

public class TanitaDateListOfPreviousEntriesActivity extends DateListOfPreviousEntriesActivity {

	@Override
	protected TanitaDateListDataSource getDateListDataSource() {
		return new TanitaDateListDataSource(this);
	}

	@Override
	protected Class<?> getPreviousEntryClass() {
		return TanitaSingleDateValuesEnteredActivity.class;
	}
}

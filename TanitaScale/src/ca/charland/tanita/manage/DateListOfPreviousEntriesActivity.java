package ca.charland.tanita.manage;

import ca.charland.tanita.base.activity.manage.BaseDateListOfPreviousEntriesActivity;
import ca.charland.tanita.db.TanitaDateListDataSource;

public class DateListOfPreviousEntriesActivity extends BaseDateListOfPreviousEntriesActivity {

	@Override
	protected TanitaDateListDataSource getDateListDataSource() {
		return new TanitaDateListDataSource(this);
	}

	@Override
	protected Class<?> getPreviousEntryClass() {
		return DateValuesEnteredActivity.class;
	}
}

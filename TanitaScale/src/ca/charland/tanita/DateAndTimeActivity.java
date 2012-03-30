package ca.charland.tanita;

import java.util.Date;

import roboguice.inject.InjectView;
import android.content.ContentValues;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.manage.PeopleListActivity;

/**
 * The Class DataAndTimeActivity.
 * 
 * @author mcharland
 */
public class DateAndTimeActivity extends AbstractBaseActivity {

	/** The date. */
	@InjectView(R.id.entry_date)
	private DatePicker datePicker;

	/** The time. */
	@InjectView(R.id.entry_time)
	private TimePicker timePicker;

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.date_view;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return WeightActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {

		ContentValues values = new ContentValues();

		// This is the first item and needs to add the person.
		Bundle extras = getIntent().getExtras();
		long person = extras.getInt(PeopleListActivity.PERSON_ID.toString());
		values.put(TanitaDataTable.Column.PERSON.toString(), person);

		// Now add the date and time.
		int year = datePicker.getYear();
		int month = datePicker.getMonth();
		int day = datePicker.getDayOfMonth();

		Integer hourObject = timePicker.getCurrentHour();
		int hour = 0;
		if (hourObject != null) {
			hour = hourObject;
		}

		Integer minuteObject = timePicker.getCurrentMinute();
		int minute = 0;
		if (minuteObject != null) {
			minute = minuteObject;
		}

		Date date = new Date(year - 1900, month, day, hour, minute, 0);
		values.put(TanitaDataTable.Column.DATE.toString(), date.getTime());

		return values;
	}
}

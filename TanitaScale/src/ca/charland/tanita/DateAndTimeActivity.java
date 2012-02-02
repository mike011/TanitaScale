package ca.charland.tanita;

import java.util.Date;

import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.ContentValues;
import android.widget.DatePicker;
import android.widget.TimePicker;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class DataAndTimeActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.date)
public class DateAndTimeActivity extends AbstractBaseActivity {
	
	/** The date. */
	@InjectView(R.id.date)
	private DatePicker datePicker;

	/** The time. */
	@InjectView(R.id.time)
	private TimePicker timePicker;

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return WeightActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		ContentValues values = new ContentValues();
		int year = datePicker.getYear();
		int month = datePicker.getMonth();
		int day = datePicker.getDayOfMonth();
		int hour = timePicker.getCurrentHour();
		int minute = timePicker.getCurrentMinute();
		Date date = new Date(year, month, day, hour, minute, 0);
		values.put(TanitaDataTable.COLUMN_DATE, date.getTime());

		return values;
	}
}

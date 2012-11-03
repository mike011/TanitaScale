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
 * @author mcharland
 */
public class DateAndTimeActivity extends BaseActivity {

	private static final int SECONDS = 0;

	@InjectView(R.id.entry_date)
	private DatePicker datePicker;

	@InjectView(R.id.entry_time)
	private TimePicker timePicker;

	@Override
	protected int getResourceIDForLayout() {
		return R.layout.date_view;
	}

	@Override
	public Class<?> getNextClass() {
		return WeightActivity.class;
	}

	@Override
	protected ContentValues getValues() {

		ContentValues content = new ContentValues();

		addPerson(content);

		content.put(TanitaDataTable.Column.DATE.toString(), getTime());

		return content;
	}

	private long getTime() {
		Date date = new Date(getYear(), getMonth(), getDay(), getHours(), getMinutes(), SECONDS);
		return date.getTime();
	}

	private int getYear() {
		int year = datePicker.getYear();
		return year - 1900;
	}
	
	private int getMonth() {
		int month = datePicker.getMonth();
		return month;
	}
	
	private int getDay() {
		int day = datePicker.getDayOfMonth();
		return day;
	}

	private void addPerson(ContentValues values) {
		Bundle extras = getIntent().getExtras();
		long person = extras.getInt(PeopleListActivity.PERSON_ID.toString());
		values.put(TanitaDataTable.Column.PERSON.toString(), person);
	}

	private int getMinutes() {
		Integer minuteObject = timePicker.getCurrentMinute();
		return updateBasedOnNull(minuteObject);
	}

	private int getHours() {
		Integer hourObject = timePicker.getCurrentHour();
		return updateBasedOnNull(hourObject);
	}
	
	private int updateBasedOnNull(Integer timeObject) {
		int time = 0;
		if (timeObject != null) {
			time = timeObject;
		}
		return time;
	}
}

package ca.charland.activity;

import java.util.Date;

import roboguice.inject.InjectView;
import android.content.ContentValues;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import ca.charland.R;
import ca.charland.activity.manage.AllPeopleListActivity;
import ca.charland.db.DataTable;

/**
 * @author mcharland
 */
public abstract class DateAndTimeActivity extends BaseActivity {

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
	protected ContentValues getValues() {

		ContentValues content = new ContentValues();

		addPerson(content);

		content.put(DataTable.DATE_COLUMN_NAME, getTime());

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
		long person = extras.getInt(AllPeopleListActivity.PERSON_ID.toString());
		values.put(DataTable.PERSON_COLUMN_NAME, person);
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

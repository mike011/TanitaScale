package ca.charland.tanita.base.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import ca.charland.tanita.base.activity.manage.BaseAllPeopleListActivity;
import ca.charland.tanita.base.db.DataSource;
import ca.charland.tanita.base.db.DataTable;

/**
 * @author mcharland
 */
public abstract class NextButtonListener {

	/** A unique identifier of a row in the table. */
	static final String ID = "ROW_ID";

	protected final BaseActivity activity;
	private final DataSource datasource;

	public NextButtonListener(BaseActivity activity, DataSource datasource) {
		this.activity = activity;
		this.datasource = datasource;
	}

	public boolean click(View v) {

		if(!datasource.isDatabaseConnectionOpen()) {
			datasource.openDatabaseConnection();
		}
		if (!isContentValid()) {
			return false;
		}
		updateIDIfInserted();

		activity.startActivity(getNextIntent());
		datasource.closeDatabaseConnection();
		return true;
	}

	private void updateIDIfInserted() {
		ContentValues values = activity.getValues();
		long id = getID();
		if (id == -1) {
			long newId = datasource.insertTableRow(values);
			activity.getIntent().putExtra(ID, newId);
		} else {
			datasource.updateTableRow(DataTable.ID_COLUMN_NAME, id, values);
		}
	}

	private Intent getNextIntent() {
		Intent newIntent = new Intent(activity.getBaseContext(), activity.getNextClass());
		newIntent.putExtra(ID, getID());

		if (isLastActivity(activity)) {
			newIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		}
		newIntent.putExtra(BaseAllPeopleListActivity.PERSON_ID.toString(), getPerson());
		return newIntent;
	}

	protected boolean isLastActivity(Activity activity) {
		return false;
	}

	private long getID() {
		long id = -1;
		Intent intent = activity.getIntent();
		if (intent != null) {
			// Don't know how inject extras in testing.
			return getIDFromExtras(intent);
		}
		return id;
	}

	private long getIDFromExtras(Intent intent) {
		long id = -1;
		Bundle extras = intent.getExtras();
		if (extras.containsKey(ID)) {
			return extras.getLong(ID);
		}
		return id;
	}

	private int getPerson() {
		Intent intent = activity.getIntent();
		int person = 0;
		if (intent != null) {
			// Don't know how inject extras in testing.
			Bundle extras = intent.getExtras();
			person = extras.getInt(BaseAllPeopleListActivity.PERSON_ID.toString());
		}
		return person;
	}

	protected boolean isContentValid() {
		return true;
	}
}
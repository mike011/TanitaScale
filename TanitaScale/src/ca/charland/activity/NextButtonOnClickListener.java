package ca.charland.activity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import ca.charland.activity.manage.AllPeopleListActivity;
import ca.charland.db.DataSource;
import ca.charland.db.DataTable;

/**
 * The listener interface for receiving nextButtonOnClick events. The class that is interested in processing a nextButtonOnClick event implements this
 * interface, and the object created with that class is registered with a component using the component's <code>addNextButtonOnClickListener<code> 
 * method. When the nextButtonOnClick event occurs, that object's appropriate method is invoked.
 * 
 * @author mcharland
 */
public abstract class NextButtonOnClickListener implements View.OnClickListener {

	/** A unique identifier of a row in the table. */
	static final String ID = "ROW_ID";
	
	protected final BaseActivity activity;
	private final DataSource datasource;

	protected NextButtonOnClickListener(BaseActivity activity, DataSource datasource) {
		this.activity = activity;
		this.datasource = datasource;
	}

	@Override
	public void onClick(View v) {

		if (!isContentValid()) {
			return;
		}
		updateIDIfInserted();

		activity.startActivity(getNextIntent());
		datasource.closeDatabaseConnection();
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
		newIntent.putExtra(AllPeopleListActivity.PERSON_ID.toString(), getPerson());
		return newIntent;
	}

	protected abstract boolean isLastActivity(Activity activity);

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
			person = extras.getInt(AllPeopleListActivity.PERSON_ID.toString());
		}
		return person;
	}

	protected abstract boolean isContentValid();
}
package ca.charland.tanita;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import ca.charland.R;
import ca.charland.activity.manage.AllPeopleListActivity;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * The listener interface for receiving nextButtonOnClick events. The class that is interested in processing a nextButtonOnClick event implements this
 * interface, and the object created with that class is registered with a component using the component's <code>addNextButtonOnClickListener<code> 
 * method. When the nextButtonOnClick event occurs, that object's appropriate method is invoked.
 * 
 * @author mcharland
 */
class NextButtonOnClickListener implements View.OnClickListener {

	/** A unique identifier of a row in the table. */
	static final String ID = "ROW_ID";
	private final BaseActivity activity;
	private final TanitaDataSource datasource;

	NextButtonOnClickListener(BaseActivity activity, TanitaDataSource datasource) {
		this.activity = activity;
		this.datasource = datasource;
	}

	@Override
	public void onClick(View v) {

		if (!isTextValid()) {
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
			datasource.updateTableRow(TanitaDataTable.Column.ID.toString(), id, values);
		}
	}

	private Intent getNextIntent() {
		Intent newIntent = new Intent(activity.getBaseContext(), activity.getNextClass());
		newIntent.putExtra(ID, getID());
		
		if (isPhysicRating(activity)) {
			newIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		}
		newIntent.putExtra(AllPeopleListActivity.PERSON_ID.toString(), getPerson());
		return newIntent;
	}

	private boolean isPhysicRating(Activity activity) {
		String name = activity.getClass().getName();
		String physic = PhysicRatingActivity.class.toString();
		return physic.contains(name);
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
			person = extras.getInt(AllPeopleListActivity.PERSON_ID.toString());
		}
		return person;
	}

	private boolean isTextValid() {
		TextView findViewById = (TextView) activity.findViewById(R.id.editTextEntry);
		if (findViewById != null) {
			CharSequence string = findViewById.getText();
			if (string.length() == 0) {
				getToast().show();
				return false;
			}
		}
		return true;
	}

	private Toast getToast() {
		return Toast.makeText(activity.getBaseContext(), getGenericErrorMessage(), Toast.LENGTH_SHORT);
	}

	private String getGenericErrorMessage() {
		return activity.getResources().getString(R.string.generic_error_message);
	}
}
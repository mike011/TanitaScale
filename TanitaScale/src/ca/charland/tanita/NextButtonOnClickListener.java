package ca.charland.tanita;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.manage.PeopleListActivity;

/**
 * The listener interface for receiving nextButtonOnClick events. The class that is interested in processing a nextButtonOnClick event implements this
 * interface, and the object created with that class is registered with a component using the component's
 * <code>addNextButtonOnClickListener<code> method. When
 * the nextButtonOnClick event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see NextButtonOnClickEvent
 * 
 * @author mcharland
 */
class NextButtonOnClickListener implements View.OnClickListener {

	/** The Constant ID. */
	private static final String ID = "ROW_ID";

	/** The data source. */
	private final TanitaDataSource datasource;

	/** The activity. */
	private final AbstractBaseActivity activity;

	NextButtonOnClickListener(AbstractBaseActivity activity) {
		this.activity = activity;
		datasource = new TanitaDataSource(activity);
	}

	/** {@inheritDoc} */
	@Override
	public void onClick(View v) {
		datasource.open();
		ContentValues values = activity.getValues();

		Bundle bundle = activity.getIntent().getExtras();
		long person = bundle.getLong(PeopleListActivity.PERSON);
		values.put(TanitaDataTable.Column.PERSON.toString(), person);
		long id = datasource.insert(values);

		Intent intent = new Intent(activity.getBaseContext(), activity.getNextClass());

		Bundle extras = activity.getIntent().getExtras();
		intent.putExtra(PeopleListActivity.PERSON, extras.getLong(PeopleListActivity.PERSON));

		intent.putExtra(ID, id);

		activity.startActivity(intent);
		datasource.close();
	}
}
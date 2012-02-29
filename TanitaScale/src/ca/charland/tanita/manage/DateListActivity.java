package ca.charland.tanita.manage;

import java.util.List;

import roboguice.activity.RoboListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import ca.charland.tanita.R;
import ca.charland.tanita.db.AbstractData;
import ca.charland.tanita.db.DateListDataSource;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * This activity allows you to chose a previously entered entry by date!
 * 
 * @author mcharland
 * 
 */
public class DateListActivity extends RoboListActivity {

	/** The database source. */
	private DateListDataSource datasource;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		datasource = new DateListDataSource(this);
		datasource.open();

		Bundle extras = getIntent().getExtras();
		String selection = TanitaDataTable.Column.PERSON.toString() + " = " + extras.getInt(PeopleListActivity.PERSON);

		final List<AbstractData> data = datasource.query(selection);
		ArrayAdapter<AbstractData> adapter = new ArrayAdapter<AbstractData>(this, R.layout.date_list, data);

		setListAdapter(adapter);
	}

	/** {@inheritDoc} */
	@Override
	protected void onResume() {
		datasource.open();
		super.onResume();
	}

	/** {@inheritDoc} */
	@Override
	protected void onPause() {
		datasource.close();
		super.onPause();
	}
}

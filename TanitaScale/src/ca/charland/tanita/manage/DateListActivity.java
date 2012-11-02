package ca.charland.tanita.manage;

import java.util.List;

import roboguice.activity.RoboListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import ca.charland.tanita.R;
import ca.charland.tanita.db.Data;
import ca.charland.tanita.db.DateListDataSource;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * For a specific person this activity show a list of previous entries by date and allows you to choose one to view.
 * 
 * @author mcharland
 * 
 */
public class DateListActivity extends RoboListActivity {

	/** The Constant ID. */
	static final String ID = "DATE";

	/** The database source. */
	private DateListDataSource datasource;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		datasource = new DateListDataSource(this);
		datasource.open();

		Bundle extras = getIntent().getExtras();
		String selection = TanitaDataTable.Column.PERSON.toString() + " = " + extras.getInt(PeopleListActivity.PERSON_ID);

		final List<Data> data = datasource.query(selection);
		ArrayAdapter<Data> adapter = new ArrayAdapter<Data>(this, R.layout.date_list, data);

		setListAdapter(adapter);

		ListView lv = getListView();
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> par, View view, int pos, long id) {
				Intent intent = new Intent(getBaseContext(), PersonDateActivity.class);

				Data selectedItem = data.get(pos);
				intent.putExtra(ID, selectedItem.getId());

				startActivity(intent);
			}
		});
		datasource.close();
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

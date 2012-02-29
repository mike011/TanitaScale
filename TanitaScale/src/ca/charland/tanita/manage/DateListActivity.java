package ca.charland.tanita.manage;

import java.util.List;

import roboguice.activity.RoboListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
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
		
		ListView lv = getListView();
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> par, View view, int pos, long id) {
				Intent intent = new Intent(getBaseContext(), PersonDateActivity.class);

				AbstractData selectedItem = data.get(pos);
				intent.putExtra(PeopleListActivity.PERSON, selectedItem.getId());

				startActivity(intent);
			}
		});
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

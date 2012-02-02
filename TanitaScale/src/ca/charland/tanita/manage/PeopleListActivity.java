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
import ca.charland.tanita.db.AbstractData;
import ca.charland.tanita.db.PersonDataSource;

/**
 * The Class PeopleListActivity which views currently added people.
 * 
 * @author mcharland
 */
public class PeopleListActivity extends RoboListActivity {

	/** The Constant PERSON. */
	public static final String PERSON = "ROW_PERSON_ID";

	/** The database source. */
	private PersonDataSource datasource;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		datasource = new PersonDataSource(this);
		datasource.open();

		final List<AbstractData> data = datasource.getAll();
		ArrayAdapter<AbstractData> adapter = new ArrayAdapter<AbstractData>(this, R.layout.people_list, data);

		setListAdapter(adapter);

		ListView lv = getListView();
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> par, View view, int pos, long id) {
				Intent intent = new Intent(getBaseContext(), PersonHomeActivity.class);

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

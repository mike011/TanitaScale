package ca.charland.tanita.manage;

import java.util.List;

import roboguice.activity.RoboListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import ca.charland.db.Data;
import ca.charland.tanita.R;
import ca.charland.tanita.db.PersonDataSource;

/**
 * Views currently added people and allows you to choose a person to view.
 * 
 * @author mcharland
 */
public class AllPeopleListActivity extends RoboListActivity {

	public static final String PERSON_ID = "ROW_PERSON_ID";

	private PersonDataSource datasource;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		datasource = new PersonDataSource(this);
		datasource.openDatabaseConnection();

		final List<Data> data = datasource.getAllValues();

		setListAdapter();
		setupListView(data);

		datasource.closeDatabaseConnection();
	}

	private void setListAdapter() {
		ArrayAdapter<Data> adapter = new ArrayAdapter<Data>(this, R.layout.people_list, datasource.getAllValues());
		setListAdapter(adapter);
	}

	private void setupListView(final List<Data> data) {
		ListView lv = getListView();
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> par, View view, int pos, long id) {
				Intent intent = new Intent(getBaseContext(), PersonHomeActivity.class);

				Data selectedItem = data.get(pos);
				intent.putExtra(AllPeopleListActivity.PERSON_ID, selectedItem.getId());

				startActivity(intent);
			}
		});
	}

	@Override
	protected void onResume() {
		datasource.openDatabaseConnection();
		super.onResume();
	}

	@Override
	protected void onPause() {
		datasource.closeDatabaseConnection();
		super.onPause();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// replaces the default 'Back' button action
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			this.startActivity(new Intent(this, FirstActivity.class));
			this.finish();
		}
		return true;
	}
}

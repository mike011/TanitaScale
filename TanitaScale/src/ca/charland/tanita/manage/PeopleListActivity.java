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
import ca.charland.tanita.R;
import ca.charland.tanita.db.Data;
import ca.charland.tanita.db.PersonDataSource;

/**
 * The Class PeopleListActivity which views currently added people and allows you to choose a person to view.
 * 
 * @author mcharland
 */
public class PeopleListActivity extends RoboListActivity {

	/** The Constant PERSON ID. */
	public static final String PERSON_ID = "ROW_PERSON_ID";

	/** The database source. */
	private PersonDataSource datasource;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		datasource = new PersonDataSource(this);
		datasource.open();

		final List<Data> data = datasource.getAll();
		ArrayAdapter<Data> adapter = new ArrayAdapter<Data>(this, R.layout.people_list, datasource.getAll());

		setListAdapter(adapter);

		ListView lv = getListView();
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> par, View view, int pos, long id) {
				Intent intent = new Intent(getBaseContext(), PersonHomeActivity.class);

				Data selectedItem = data.get(pos);
				intent.putExtra(PeopleListActivity.PERSON_ID, selectedItem.getId());

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
	
	/** {@inheritDoc} */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// replaces the default 'Back' button action
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			this.startActivity(new Intent(this, TanitaScaleActivity.class));
		}
		return true;
	}
}

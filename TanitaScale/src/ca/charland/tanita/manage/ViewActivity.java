package ca.charland.tanita.manage;

import roboguice.activity.RoboListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import ca.charland.tanita.R;
import ca.charland.tanita.db.Person;
import ca.charland.tanita.db.PersonDataSource;

/**
 * The Class ViewActivity which views currently added people.
 * 
 * @author mcharland
 */
public class ViewActivity extends RoboListActivity {

	/** The database source. */
	private PersonDataSource datasource;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		datasource = new PersonDataSource(this);
		datasource.open();

		ArrayAdapter<Person> adapter = new ArrayAdapter<Person>(this,
				R.layout.view, datasource.getAllPeople());

		setListAdapter(adapter);

		ListView lv = getListView();
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> par, View view, int pos,
					long id) {
				startActivity(new Intent(getBaseContext(), PickActivity.class));
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

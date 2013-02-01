package ca.charland.activity.manage;

import java.util.List;

import roboguice.activity.RoboListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import ca.charland.R;
import ca.charland.db.Data;
import ca.charland.tanita.db.DateListDataSource;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * For a specific person shows a list of previous entries reverse sorted by date and allows you to choose one to view.
 * 
 * @author mcharland
 * 
 */
public class DateListOfPreviousEntriesActivity extends RoboListActivity {

	public static final String ID = "DATE";

	private DateListDataSource datasource;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		datasource = new DateListDataSource(this);
		datasource.openDatabaseConnection();

		final List<Data> data = datasource.queryWithOrdering(getSelection(), getOrderBy());

		setListAdapter(data);
		setupListView(data);

		datasource.closeDatabaseConnection();
	}

	private String getOrderBy() {
		return TanitaDataTable.Column.DATE.toString() + " DESC";
	}

	private void setListAdapter(final List<Data> data) {
		ArrayAdapter<Data> adapter = new ArrayAdapter<Data>(this, R.layout.date_list, data);
		setListAdapter(adapter);
	}

	private String getSelection() {
		String selection = TanitaDataTable.Column.PERSON.toString() + " = " + getID();
		return selection;
	}

	private int getID() {
		Bundle extras = getIntent().getExtras();
		int id = extras.getInt(AllPeopleListActivity.PERSON_ID);
		return id;
	}

	private void setupListView(List<Data> data) {
		ListView lv = getListView();
		lv.setOnItemClickListener(getOnItemClickListener(data));
	}

	private OnItemClickListener getOnItemClickListener(final List<Data> data) {
		OnItemClickListener onItemClickListener = new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> par, View view, int pos, long id) {
				Intent intent = new Intent(getBaseContext(), SingleDateValuesEnteredActivity.class);

				Data selectedItem = data.get(pos);
				intent.putExtra(ID, selectedItem.getId());

				startActivity(intent);
			}
		};
		return onItemClickListener;
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
}

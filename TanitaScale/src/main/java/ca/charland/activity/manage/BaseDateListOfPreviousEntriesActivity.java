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
import ca.charland.tanita.R;
import ca.charland.db.Data;
import ca.charland.db.DataTable;
import ca.charland.db.DateListDataSource;

/**
 * For a specific person shows a list of previous entries reverse sorted by date and allows you to choose one to view.
 * 
 * @author mcharland
 * 
 */
public abstract class BaseDateListOfPreviousEntriesActivity extends RoboListActivity {

	public static final String ID = "DATE";

	private DateListDataSource datasource;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		datasource = getDateListDataSource();
		datasource.openDatabaseConnection();

		final List<Data> data = datasource.queryWithOrdering(getSelection(), getOrderBy());

		setListAdapter(data);
		setupListView(data);

		datasource.closeDatabaseConnection();
	}

	protected abstract DateListDataSource getDateListDataSource();

	private String getOrderBy() {
		return DataTable.DATE_COLUMN_NAME + " DESC";
	}

	private void setListAdapter(final List<Data> data) {
		ArrayAdapter<Data> adapter = new ArrayAdapter<Data>(this, R.layout.date_list, data);
		setListAdapter(adapter);
	}

	private String getSelection() {
		String selection = DataTable.PERSON_COLUMN_NAME + " = " + getID();
		return selection;
	}

	private int getID() {
		Bundle extras = getIntent().getExtras();
		int id = extras.getInt(BaseAllPeopleListActivity.PERSON_ID);
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
				Intent intent = new Intent(getBaseContext(), getPreviousEntryClass());

				Data selectedItem = data.get(pos);
				intent.putExtra(ID, selectedItem.getId());

				startActivity(intent);
			}
		};
		return onItemClickListener;
	}

	protected abstract Class<?> getPreviousEntryClass();
	
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

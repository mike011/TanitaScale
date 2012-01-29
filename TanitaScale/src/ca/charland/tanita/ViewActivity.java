package ca.charland.tanita;

import roboguice.activity.RoboListActivity;
import roboguice.inject.ContentView;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * The Class ViewActivity which views currently added people.
 * 
 * @author mcharland
 */
@ContentView(R.layout.view)
public class ViewActivity extends RoboListActivity {

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState
	 *            the saved instance state
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.view, Database.getPeople());

		setListAdapter(adapter);

		ListView lv = getListView();
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//startActivity(new Intent(getBaseContext(), ViewActivity.class));
			}
		});
	}
}

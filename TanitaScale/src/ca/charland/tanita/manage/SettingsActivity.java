package ca.charland.tanita.manage;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import ca.charland.db.Data;
import ca.charland.tanita.R;
import ca.charland.tanita.db.PersonDataSource;

public class SettingsActivity extends PreferenceActivity {

	private CheckBox singleUser;

	private PersonDataSource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        
		singleUser = (CheckBox) this.findViewById(R.id.singleUser);
		//people = (Spinner) this.findViewById(R.id.people);

		singleUser.setOnClickListener(getClickListener());
		datasource = new PersonDataSource(this);
		datasource.openDatabaseConnection();

		ArrayAdapter<Data> adapter = new ArrayAdapter<Data>(this, R.layout.spinner, datasource.getAllValues());
//		people.setAdapter(adapter);
	//	people.setEnabled(false);
		// spinner.setOnItemSelectedListener(new OnItemSelectedListener()

		datasource.closeDatabaseConnection();
	}

	private OnClickListener getClickListener() {
		OnClickListener listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
	//				people.setEnabled(checked(v));
			}

			private boolean checked(View v) {
				CheckBox checkBox = (CheckBox) v;
				return checkBox.isChecked();
			}
		};
		return listener;

	}
}

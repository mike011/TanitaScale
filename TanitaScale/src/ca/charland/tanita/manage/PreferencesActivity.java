package ca.charland.tanita.manage;

import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import ca.charland.db.Data;
import ca.charland.tanita.R;
import ca.charland.tanita.db.PersonData;
import ca.charland.tanita.db.PersonDataSource;

public class PreferencesActivity extends PreferenceActivity {

	private static final String SINGLE_USER_KEY = "singleUser";

	private static final String PEOPLE_KEY = "people";

	private CheckBoxPreference singleUser;

	private PersonDataSource datasource;

	private ListPreference people;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);

		datasource = new PersonDataSource(this);
		datasource.openDatabaseConnection();

		inflatePeopleList();
		createSingleUserCheckBox();

		datasource.closeDatabaseConnection();
	}

	private void createSingleUserCheckBox() {
		singleUser = (CheckBoxPreference) this.findPreference(SINGLE_USER_KEY);
		singleUser.setOnPreferenceClickListener(getClickListener());
		if (!singleUser.isChecked()) {
			people.setEnabled(false);
		}
	}

	private void inflatePeopleList() {
		people = (ListPreference) super.findPreference(PEOPLE_KEY);
		people.setEntries(getEntries());
		people.setEntryValues(getEntryValues());
	}

	private CharSequence[] getEntries() {
		List<Data> allValues = datasource.getAllValues();
		CharSequence[] entries = new CharSequence[allValues.size()];
		int x = 0;
		for (Data data : allValues) {
			PersonData pd = (PersonData) data;
			entries[x++] = pd.getName();
		}
		return entries;
	}

	private CharSequence[] getEntryValues() {
		List<Data> allValues = datasource.getAllValues();
		CharSequence[] values = new CharSequence[allValues.size()];
		for (int x = 0; x < allValues.size(); x++) {
			values[x] = String.valueOf(x + 1);
		}
		return values;
	}

	private OnPreferenceClickListener getClickListener() {
		OnPreferenceClickListener listener = new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(Preference p) {
				people.setEnabled(isChecked(p));
				return false;
			}

			private boolean isChecked(Preference p) {
				CheckBoxPreference checkBox = (CheckBoxPreference) p;
				return checkBox.isChecked();
			}
		};
		return listener;
	}

	public static boolean isSingleUserModeSet(Context context) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
		boolean result = sharedPreferences.getBoolean(SINGLE_USER_KEY, false);
		return result;
	}

	public static int getPersonID(Context context) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		char c = preferences.getString(PEOPLE_KEY, "-1").toCharArray()[0];
		int result = Character.getNumericValue(c);
		return result;
	}
}

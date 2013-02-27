package ca.charland.tanita;

import android.os.SystemClock;
import android.preference.ListPreference;
import android.test.ActivityInstrumentationTestCase2;
import ca.charland.tanita.base.activity.manage.PreferencesActivity;

import com.jayway.android.robotium.solo.Solo;

public class SettingsTest extends ActivityInstrumentationTestCase2<PreferencesActivity>{

	private Solo solo;

	public SettingsTest() {
		super("ca.charland.tanita.base.activity.manage", PreferencesActivity.class);
	}
	
	@Override
	public void setUp() throws Exception {
		//setUp() is run before a test case is started. 
		//This is where the solo object is created.
		solo = new Solo(getInstrumentation(), getActivity());
	}
	
	@Override
	public void tearDown() throws Exception {
		//tearDown() is run after a test case has finished. 
		//finishOpenedActivities() will finish all the activities that have been opened during the test execution.
		solo.finishOpenedActivities();
	}

	public void testCantPressYet() throws Exception {
		ListPreference people = (ListPreference) getActivity().findPreference("people");
		SystemClock.sleep(500);
		assertFalse(people.isEnabled());
	}
}

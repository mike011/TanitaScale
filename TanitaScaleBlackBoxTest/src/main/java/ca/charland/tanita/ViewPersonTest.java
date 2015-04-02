package ca.charland.tanita;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import ca.charland.tanita.base.activity.manage.BaseAllPeopleListActivity;
import ca.charland.tanita.manage.PersonHomeActivity;

import com.robotium.solo.Solo;

public class ViewPersonTest extends ActivityInstrumentationTestCase2<PersonHomeActivity> {

	private Solo solo;

	public ViewPersonTest() {
		super("ca.charland.tanita.manage", PersonHomeActivity.class);
		Intent i = new Intent();
		i.putExtra(BaseAllPeopleListActivity.PERSON_ID, 5);
		setActivityIntent(i);
	}
	
	@Override
	public void setUp() throws Exception {
		//setUp() is run before a test case is started. 
		//This is where the solo object is created.
		solo = new Solo(getInstrumentation(), getActivity());
		solo.unlockScreen();
	}
	
	@Override
	public void tearDown() throws Exception {
		//tearDown() is run after a test case has finished. 
		//finishOpenedActivities() will finish all the activities that have been opened during the test execution.
		solo.finishOpenedActivities();
	}
	
	public void testAddingData() throws Exception {
		solo.sleep(5000);
		solo.assertCurrentActivity("Expected Person home ctivity", "PersonHomeActivity");
		solo.clickOnButton("Add");
		solo.sleep(5000);
		solo.assertCurrentActivity("Expected date and time activity", "DateAndTimeActivity");
	}

	public void testViewingData() throws Exception {
		solo.sleep(5000);
		solo.assertCurrentActivity("Expected Person home ctivity", "PersonHomeActivity");
		solo.clickOnButton("View");
		solo.sleep(5000);
		solo.assertCurrentActivity("Expected Date of previous entries", "DateListOfPreviousEntriesActivity");
	}
}

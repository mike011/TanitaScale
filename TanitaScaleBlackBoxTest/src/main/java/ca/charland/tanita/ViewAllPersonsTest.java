package ca.charland.tanita;

import android.test.ActivityInstrumentationTestCase2;
import ca.charland.tanita.manage.AllPeopleListActivity;

import com.jayway.android.robotium.solo.Solo;

public class ViewAllPersonsTest extends ActivityInstrumentationTestCase2<AllPeopleListActivity>{

	private Solo solo;

	public ViewAllPersonsTest() {
		super("ca.charland.tanita.manage", AllPeopleListActivity.class);
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
	
	public void testChoosingAPerson() throws Exception {
		solo.sleep(5000);
		solo.assertCurrentActivity("Expected All Person activity", "AllPeopleListActivity");
		solo.clickInList(0);
		solo.sleep(5000);
		solo.assertCurrentActivity("Expected Person home activity", "PersonHomeActivity");
	}
}

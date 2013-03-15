package ca.charland.tanita;

import android.test.ActivityInstrumentationTestCase2;

import com.jayway.android.robotium.solo.Solo;

public class PhysicRatingTest extends ActivityInstrumentationTestCase2<PhysicRatingActivity>{

	private Solo solo;

	public PhysicRatingTest() {
		super("ca.charland.tanita", PhysicRatingActivity.class);
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

	public void testOpenAddANewPerson() throws Exception {
		solo.clickOnMenuItem("Add a New Person");
		solo.assertCurrentActivity("Expected Add a new Person activity", "AddANewPersonActivity"); 
	}

}

package ca.charland.tanita;

import android.test.ActivityInstrumentationTestCase2;
import ca.charland.tanita.manage.AddANewPersonActivity;

import com.robotium.solo.Solo;


public class AddAPersonTest extends ActivityInstrumentationTestCase2<AddANewPersonActivity>{

		private Solo solo;

		public AddAPersonTest() {
			super("ca.charland.tanita.manage", AddANewPersonActivity.class);
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
		
		public void testAddingAPerson() throws Exception {
			solo.sleep(5000);
			solo.assertCurrentActivity("Expected Add a new Person activity", "AddANewPersonActivity");
			solo.enterText(0, "name");
			solo.enterText(1, "email");
			solo.clickOnRadioButton(0); //male
			solo.clickOnButton("Save");
			solo.sleep(5000);
			solo.assertCurrentActivity("Expected Add a new Person activity", "AddANewPersonActivity");
		}

}

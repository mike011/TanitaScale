package ca.charland.tanita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;
import android.widget.TextView;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class TextViewActivityTest {

	private BaseActivity activity;

	@Before
	public void setUp() throws Exception {
		activity = new TestBaseActivity();
		activity.onCreate(null);

	}

	@Test
	public void testEnterText() {
		TextView enter = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.enter_your);
		
		assertNotNull("Enter not set", enter);
		CharSequence text = enter.getText();
		assertNotNull("Enter text not set", text);
		assertEquals("Enter your Body Fat for your Left Arm", text.toString());
	}

	@Test
	public void testPreviousText() {
		TextView previous = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity,R.id.PreviousText);

		assertNotNull("Previous not set", previous);
		CharSequence text = previous.getText();
		assertNotNull("Previous text not set", text);
		assertEquals("Previous", text.toString());
	}

	@Test
	public void testAverageText() {
		TextView average = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity,R.id.AverageText);
		
		assertNotNull("Average not set", average);
		CharSequence text = average.getText();
		assertNotNull("Average text not set", text);
		assertEquals("Average", text.toString());
	}

	private static class BodyFatLeftArmActivityUnderTest extends BodyFatLeftArmActivity {

		@Override
		protected void setSex(int id, int female) {
		}
		
		@Override 
		protected void createDataSource() {
		}
	}

	@Test
	public void testGetValues() {

		BodyFatLeftArmActivityUnderTest activity = new BodyFatLeftArmActivityUnderTest();
		activity.onCreate(null);

		assertNotNull(activity);
		ContentValues values = activity.getValues();
		assertEquals(1, values.size());

		assertTrue(values.containsKey(TanitaDataTable.Column.BODY_FAT_LEFT_ARM.toString()));
		assertEquals("", values.get(TanitaDataTable.Column.BODY_FAT_LEFT_ARM.toString()));
	}

}

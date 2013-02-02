package ca.charland.tanita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;
import android.widget.TextView;
import ca.charland.R;
import ca.charland.activity.BaseActivity;
import ca.charland.robolectric.TanitaRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.db.TestTanitaDataSource;
/**
 * @author mcharland
 */
@RunWith(TanitaRobolectricTestRunner.class)
public class TextViewActivityTest {

	private BaseActivity activity;

	@Before
	public void setUp() throws Exception {
		activity = new TestBaseActivity();
		activity.onCreate(null);

	}

	@Test
	public void testEnterText() {
		TextView enter = (TextView)TanitaRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.enter_your);
		
		assertNotNull("Enter not set", enter);
		CharSequence text = enter.getText();
		assertNotNull("Enter text not set", text);
		assertEquals("Enter your Body Fat for your Left Arm", text.toString());
	}

	@Test
	public void testPreviousText() {
		TextView previous = (TextView)TanitaRobolectricTestRunner.getViewFromShadowActivity(activity,R.id.previous);

		assertNotNull("Previous not set", previous);
		CharSequence text = previous.getText();
		assertNotNull("Previous text not set", text);
		assertEquals("0.00", text.toString());
	}

	@Test
	public void testAverageText() {
		TextView average = (TextView)TanitaRobolectricTestRunner.getViewFromShadowActivity(activity,R.id.average);
		
		assertNotNull("Average not set", average);
		CharSequence text = average.getText();
		assertNotNull("Average text not set", text);
		assertEquals("0.00",text.toString());
	}

	private static class BodyFatLeftArmActivityUnderTest extends BodyFatLeftArmActivity {

		@Override
		protected void setSex(int id, int female) {
		}
		
		@Override 
		protected TanitaDataSource getDataSource() {
			return new TestTanitaDataSource();
		}
		
		@Override
		protected void setData() {
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

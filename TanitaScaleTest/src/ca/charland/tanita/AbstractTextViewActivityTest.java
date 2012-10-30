package ca.charland.tanita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import roboguice.inject.InjectView;
import android.content.ContentValues;
import android.widget.TextView;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataTable;

import com.google.inject.Inject;

/**
 * Testing of Abstract Text View Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class AbstractTextViewActivityTest {

	private static class BodyFatLeftArmActivityUnderTest extends BodyFatLeftArmActivity {
		
		@Override
		protected void setSex(int id, int female) {
		}
	}
	
	/** The class under test. */
	@Inject
	private BodyFatLeftArmActivityUnderTest activity;

	/** The enter text. */
	@InjectView(R.id.enter_your)
	private TextView enter;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method to make sure the text is set correctly.
	 */
	@Test
	public void testText() {
		assertEquals("Enter your Body Fat for your Left Arm", enter.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.AbstractTextViewActivity#getValues()}.
	 */
	@Test
	public void testGetValues() {
		ContentValues values = activity.getValues();
		assertEquals(1, values.size());

		assertTrue(values.containsKey(TanitaDataTable.Column.BODY_FAT_LEFT_ARM.toString()));
		assertEquals("", values.get(TanitaDataTable.Column.BODY_FAT_LEFT_ARM.toString()));
	}

}

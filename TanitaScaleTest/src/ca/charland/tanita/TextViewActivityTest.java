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
 * @author mcharland
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class TextViewActivityTest {

	private static class BodyFatLeftArmActivityUnderTest extends BodyFatLeftArmActivity {
		
		@Override
		protected void setSex(int id, int female) {
		}
	}
	
	@Inject
	private BodyFatLeftArmActivityUnderTest activity;

	@InjectView(R.id.enter_your)
	private TextView enter;

	@Before
	public void setup() {
		activity.onCreate(null);
	}

	@Test
	public void testText() {
		assertEquals("Enter your Body Fat for your Left Arm", enter.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.TextViewActivity#getValues()}.
	 */
	@Test
	public void testGetValues() {
		ContentValues values = activity.getValues();
		assertEquals(1, values.size());

		assertTrue(values.containsKey(TanitaDataTable.Column.BODY_FAT_LEFT_ARM.toString()));
		assertEquals("", values.get(TanitaDataTable.Column.BODY_FAT_LEFT_ARM.toString()));
	}

}

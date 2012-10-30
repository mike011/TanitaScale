package ca.charland.tanita;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataTable;

import com.google.inject.Inject;

/**
 * Testing Body Fat Left Arm Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class BodyFatLeftArmActivityTest {

	private static class BodyFatLeftArmActivityUnderTest extends BodyFatLeftArmActivity {
		
		@Override
		protected void setSex(int id, int female) {
		}
	}
	
	/** The class under test. */
	@Inject
	private BodyFatLeftArmActivityUnderTest activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatLeftArmActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.body_fat_left_arm, activity.getLayoutResID());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatLeftArmActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.BODY_FAT_LEFT_ARM, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatLeftArmActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(BodyFatRightArmActivity.class, activity.getNextClass());
	}

}

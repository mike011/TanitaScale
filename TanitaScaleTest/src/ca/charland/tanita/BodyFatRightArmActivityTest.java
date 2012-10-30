package ca.charland.tanita;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataTable;

import com.google.inject.Inject;

/**
 * Testing Body Fat Right Arm Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class BodyFatRightArmActivityTest {

	private static class BodyFatRightArmActivityUnderTest extends BodyFatRightArmActivity {

		@Override
		protected void setSex(int id, int female) {
		}
	}
	
	/** The class under test. */
	@Inject
	private BodyFatRightArmActivityUnderTest activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatRightArmActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.body_fat_right_arm, activity.getLayoutResID());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatRightArmActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.BODY_FAT_RIGHT_ARM, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatRightArmActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(BodyFatRightLegActivity.class, activity.getNextClass());
	}

}

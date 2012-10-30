package ca.charland.tanita;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataTable;

import com.google.inject.Inject;

/**
 * Testing Body Fat Left Leg Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class BodyFatLeftLegActivityTest {

	private static class BodyFatLeftLegActivityUnderTest extends BodyFatLeftLegActivity {

		@Override
		protected void setSex(int id, int female) {
		}
	}
	
	/** The class under test. */
	@Inject
	private BodyFatLeftLegActivityUnderTest activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatLeftLegActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.body_fat_left_leg, activity.getLayoutResID());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatLeftLegActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.BODY_FAT_LEFT_LEG, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatLeftLegActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(BodyFatTrunkActivity.class, activity.getNextClass());
	}

}

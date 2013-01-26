package ca.charland.tanita;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataTable;

import com.google.inject.Inject;

/**
 * @author mcharland
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class BodyFatLeftArmActivityTest {

	private static class ActivityUnderTest extends BodyFatLeftArmActivity {

		@Override
		protected void setSex(int id, int female) {
		}
		
		@Override 
		protected void createDataSource() {
		}
	}
	
	@Inject
	private ActivityUnderTest activity;

	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatLeftArmActivity#getResourceIDForLayout()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.body_fat_left_arm, activity.getResourceIDForLayout());
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

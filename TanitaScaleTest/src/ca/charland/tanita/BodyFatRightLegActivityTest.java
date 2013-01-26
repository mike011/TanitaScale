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
public class BodyFatRightLegActivityTest {

	private static class ActivityUnderTest extends BodyFatRightLegActivity {

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
	 * Test method for {@link ca.charland.tanita.BodyFatRightLegActivity#getResourceIDForLayout()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.body_fat_right_leg, activity.getResourceIDForLayout());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatRightLegActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.BODY_FAT_RIGHT_LEG, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatRightLegActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(BodyFatLeftLegActivity.class, activity.getNextClass());
	}

}

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
public class MuscleMassRightArmActivityTest {

	private static class ActivityUnderTest extends MuscleMassRightArmActivity {

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
	 * Test method for {@link ca.charland.tanita.MuscleMassRightArmActivity#getResourceIDForLayout()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.muscle_mass_right_arm, activity.getResourceIDForLayout());
	}

	/**
	 * Test method for {@link ca.charland.tanita.MuscleMassRightArmActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.MUSCLE_MASS_RIGHT_ARM, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.MuscleMassRightArmActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(MuscleMassRightLegActivity.class, activity.getNextClass());
	}

}

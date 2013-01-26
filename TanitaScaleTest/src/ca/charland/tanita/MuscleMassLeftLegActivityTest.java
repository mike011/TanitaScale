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
public class MuscleMassLeftLegActivityTest {

	private static class ActivityUnderTest extends MuscleMassLeftLegActivity {

		@Override
		protected void setSex(int id, int female) {
		}
		
		@Override 
		protected void createDataSource() {
		}

		@Override
		protected void setData() {
		}
	}
	
	@Inject
	private ActivityUnderTest activity;

	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.MuscleMassLeftLegActivity#getResourceIDForLayout()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.muscle_mass_left_leg, activity.getResourceIDForLayout());
	}

	/**
	 * Test method for {@link ca.charland.tanita.MuscleMassLeftLegActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.MUSCLE_MASS_LEFT_LEG, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.MuscleMassLeftLegActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(MuscleMassTrunkActivity.class, activity.getNextClass());
	}

}

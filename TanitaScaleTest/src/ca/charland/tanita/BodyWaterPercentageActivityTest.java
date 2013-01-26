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
public class BodyWaterPercentageActivityTest {

	private static class ActivityUnderTest extends BodyWaterPercentageActivity {

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
	 * Test method for {@link ca.charland.tanita.BodyWaterPercentageActivity#getResourceIDForLayout()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.body_water_percentage, activity.getResourceIDForLayout());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyWaterPercentageActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.BODY_WATER_PERCENTAGE, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyWaterPercentageActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(VisceralFatActivity.class, activity.getNextClass());
	}

}

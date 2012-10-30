package ca.charland.tanita;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataTable;

import com.google.inject.Inject;

/**
 * Testing Body Water Percentage Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class BodyWaterPercentageActivityTest {

	private static class BodyWaterPercentageActivityUnderTest extends BodyWaterPercentageActivity {
		
		@Override
		protected void setSex(int id, int female) {
		}
	}
	
	/** The class under test. */
	@Inject
	private BodyWaterPercentageActivityUnderTest activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyWaterPercentageActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.body_water_percentage, activity.getLayoutResID());
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

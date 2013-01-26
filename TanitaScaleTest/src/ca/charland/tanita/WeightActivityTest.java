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
public class WeightActivityTest {

	private static class ActivityUnderTest extends WeightActivity {

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
	 * Test method for {@link ca.charland.tanita.WeightActivity#getResourceIDForLayout()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.weight, activity.getResourceIDForLayout());
	}

	/**
	 * Test method for {@link ca.charland.tanita.WeightActivity#getValues()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.WEIGHT, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.WeightActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(DailyCaloricIntakeActivity.class, activity.getNextClass());
	}

}

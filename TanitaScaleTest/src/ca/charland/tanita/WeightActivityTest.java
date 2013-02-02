package ca.charland.tanita;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.R;
import ca.charland.robolectric.TanitaRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.db.TestTanitaDataSource;

import com.google.inject.Inject;
/**
 * @author mcharland
 */
@RunWith(TanitaRobolectricTestRunner.class)
public class WeightActivityTest {

	private static class ActivityUnderTest extends WeightActivity {

		@Override
		protected void setSex(int id, int female) {
		}
		
		@Override 
		protected TanitaDataSource getDataSource() {
			return new TestTanitaDataSource();
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

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
public class DailyCaloricIntakeActivityTest {

	private static class ActivityUnderTest extends DailyCaloricIntakeActivity {

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
	 * Test method for {@link ca.charland.tanita.DailyCaloricIntakeActivity#getResourceIDForLayout()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.dci, activity.getResourceIDForLayout());
	}

	/**
	 * Test method for {@link ca.charland.tanita.DailyCaloricIntakeActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.DAILY_CALORIC_INTAKE, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.DailyCaloricIntakeActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(MetabolicAgeActivity.class, activity.getNextClass());
	}

}

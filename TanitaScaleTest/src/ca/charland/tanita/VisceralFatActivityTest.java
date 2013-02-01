package ca.charland.tanita;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.R;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.db.TestTanitaDataSource;

import com.google.inject.Inject;
/**
 * @author mcharland
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class VisceralFatActivityTest {

	private static class ActivityUnderTest extends VisceralFatActivity {

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
	 * Test method for {@link ca.charland.tanita.VisceralFatActivity#getResourceIDForLayout()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.visceral_fat, activity.getResourceIDForLayout());
	}

	/**
	 * Test method for {@link ca.charland.tanita.VisceralFatActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.VISCERAL_FAT, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.VisceralFatActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(BoneMassActivity.class, activity.getNextClass());
	}

}

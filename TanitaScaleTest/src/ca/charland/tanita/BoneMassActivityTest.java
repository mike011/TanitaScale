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
public class BoneMassActivityTest {

	private static class BoneMassActivityUnderTest extends BoneMassActivity {

		@Override
		protected void setSex(int id, int female) {
		}
	}

	@Inject
	private BoneMassActivityUnderTest activity;

	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.BoneMassActivity#getResourceIDForLayout()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.bone_mass, activity.getResourceIDForLayout());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BoneMassActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.BONE_MASS, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BoneMassActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(BodyFatTotalActivity.class, activity.getNextClass());
	}

}

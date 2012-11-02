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
public class MuscleMassTotalActivityTest {

	@Inject
	private MuscleMassTotalActivity activity;

	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.MuscleMassTotalActivity#getResourceIDForLayout()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.muscle_mass_total, activity.getResourceIDForLayout());
	}

	/**
	 * Test method for {@link ca.charland.tanita.MuscleMassTotalActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.MUSCLE_MASS_TOTAL, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.MuscleMassTotalActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(MuscleMassLeftArmActivity.class, activity.getNextClass());
	}

}

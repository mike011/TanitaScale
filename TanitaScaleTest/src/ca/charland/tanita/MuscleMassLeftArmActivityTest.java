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
public class MuscleMassLeftArmActivityTest {

	@Inject
	private MuscleMassLeftArmActivity activity;

	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.MuscleMassLeftArmActivity#getResourceIDForLayout()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.muscle_mass_left_arm, activity.getResourceIDForLayout());
	}

	/**
	 * Test method for {@link ca.charland.tanita.MuscleMassLeftArmActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.MUSCLE_MASS_LEFT_ARM, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.MuscleMassLeftArmActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(MuscleMassRightArmActivity.class, activity.getNextClass());
	}

}

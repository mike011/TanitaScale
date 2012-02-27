package ca.charland.tanita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;

import com.google.inject.Inject;

/**
 * Testing Muscle Mass Trunk Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class MuscleMassTrunkActivityTest {

	/** The class under test. */
	@Inject
	private MuscleMassTrunkActivity activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.MuscleMassTrunkActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.muscle_mass_trunk, activity.getLayoutResID());
	}

	/**
	 * Test method for {@link ca.charland.tanita.MuscleMassTrunkActivity#getValues()}.
	 */
	@Test
	public void testGetValues() {
		ContentValues values = activity.getValues();
		assertNull(values);
	}

	/**
	 * Test method for {@link ca.charland.tanita.MuscleMassTrunkActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(PhysicRatingActivity.class, activity.getNextClass());
	}

}

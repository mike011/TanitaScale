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
 * Testing Body Fat Trunk Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class BodyFatTrunkActivityTest {

	/** The class under test. */
	@Inject
	private BodyFatTrunkActivity activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatTrunkActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.body_fat_trunk, activity.getLayoutResID());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatTrunkActivity#getValues()}.
	 */
	@Test
	public void testGetValues() {
		ContentValues values = activity.getValues();
		assertNull(values);
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatTrunkActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(MuscleMassTotalActivity.class, activity.getNextClass());
	}

}

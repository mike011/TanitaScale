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
 * Testing Bone Mass Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class BoneMassActivityTest {

	/** The class under test. */
	@Inject
	private BoneMassActivity activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.BoneMassActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.bone_mass, activity.getLayoutResID());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BoneMassActivity#getValues()}.
	 */
	@Test
	public void testGetValues() {
		ContentValues values = activity.getValues();
		assertNull(values);
	}

	/**
	 * Test method for {@link ca.charland.tanita.BoneMassActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(BodyFatTotalActivity.class, activity.getNextClass());
	}

}

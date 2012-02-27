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
 * Testing Body Fat Right Leg Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class BodyFatRightLegActivityTest {

	/** The class under test. */
	@Inject
	private BodyFatRightLegActivity activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatRightLegActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.body_fat_right_leg, activity.getLayoutResID());
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatRightLegActivity#getValues()}.
	 */
	@Test
	public void testGetValues() {
		ContentValues values = activity.getValues();
		assertNull(values);
	}

	/**
	 * Test method for {@link ca.charland.tanita.BodyFatRightLegActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(BodyFatLeftLegActivity.class, activity.getNextClass());
	}

}

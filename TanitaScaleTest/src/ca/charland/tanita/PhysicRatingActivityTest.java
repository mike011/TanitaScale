package ca.charland.tanita;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.manage.PersonHomeActivity;

import com.google.inject.Inject;

/**
 * Testing Physic Rating Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class PhysicRatingActivityTest {

	/** The class under test. */
	@Inject
	private PhysicRatingActivity activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.PhysicRatingActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.physic_rating, activity.getLayoutResID());
	}

	/**
	 * Test method for {@link ca.charland.tanita.PhysicRatingActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.PHYSIC_RATING, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.PhysicRatingActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(PersonHomeActivity.class, activity.getNextClass());
	}

}

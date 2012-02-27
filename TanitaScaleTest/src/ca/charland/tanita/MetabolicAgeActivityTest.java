package ca.charland.tanita;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataTable;

import com.google.inject.Inject;

/**
 * Testing Metabolic Age Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class MetabolicAgeActivityTest {

	/** The class under test. */
	@Inject
	private MetabolicAgeActivity activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.MetabolicAgeActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.metabolic_age, activity.getLayoutResID());
	}
	
	/**
	 * Test method for {@link ca.charland.tanita.MetabolicAgeActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.METABOLIC_AGE, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.MetabolicAgeActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(BodyWaterPercentageActivity.class, activity.getNextClass());
	}

}

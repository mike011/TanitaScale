package ca.charland.tanita;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;

import com.google.inject.Inject;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * Testing DCI Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class DCIActivityTest {

	/** The class under test. */
	@Inject
	private DCIActivity activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.DCIActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.dci, activity.getLayoutResID());
	}

	/**
	 * Test method for {@link ca.charland.tanita.DCIActivity#getValues()}.
	 */
	@Test
	public void testGetValues() {
		ContentValues values = activity.getValues();
		assertNotNull(values);
		assertTrue(values.containsKey(TanitaDataTable.Column.DAILY_CALORIC_INTAKE.toString()));
		String s = (String) values.get(TanitaDataTable.Column.DAILY_CALORIC_INTAKE.toString());
		assertEquals("", s);
	}

	/**
	 * Test method for {@link ca.charland.tanita.DCIActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(MetabolicAgeActivity.class, activity.getNextClass());
	}

}

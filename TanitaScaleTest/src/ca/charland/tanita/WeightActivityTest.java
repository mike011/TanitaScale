package ca.charland.tanita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataTable;

import com.google.inject.Inject;

/**
 * Testing Weight Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class WeightActivityTest {
	
	/** The class under test. */
	@Inject
	private WeightActivity activity;
	
	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.WeightActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.weight, activity.getLayoutResID());
	}

	/**
	 * Test method for {@link ca.charland.tanita.WeightActivity#getValues()}.
	 */
	@Test
	public void testGetValues() {
		ContentValues values = activity.getValues();
		assertNotNull(values);
		assertTrue(values.containsKey(TanitaDataTable.Column.WEIGHT.toString()));
		String s = (String)values.get(TanitaDataTable.Column.WEIGHT.toString());
		assertEquals("", s);
	}

	/**
	 * Test method for {@link ca.charland.tanita.WeightActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(DCIActivity.class, activity.getNextClass());
	}

}

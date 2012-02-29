package ca.charland.tanita;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataTable;

import com.google.inject.Inject;

/**
 * Testing Visceral Fat Activity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class VisceralFatActivityTest {

	/** The class under test. */
	@Inject
	private VisceralFatActivity activity;

	/** Ran before each test. */
	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.VisceralFatActivity#getLayoutResID()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertEquals(R.layout.visceral_fat, activity.getLayoutResID());
	}

	/**
	 * Test method for {@link ca.charland.tanita.VisceralFatActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertEquals(TanitaDataTable.Column.VISCERAL_FAT, activity.getColumnName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.VisceralFatActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertEquals(BoneMassActivity.class, activity.getNextClass());
	}

}

package ca.charland.tanita.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;

/**
 * Tests for Tanita Data Source.
 * 
 * @author mcharland
 *
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class TanitaDataSourceTest {
	
	/**
	 * Class under test.
	 */
	private TanitaDataSource tds;
	
	/** Sets things up. */
	@Before
	public void setup() {
		tds = new TanitaDataSource(null);
	}
	

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#TanitaDataSource(android.content.Context)}.
	 */
	@Test
	public void testTanitaDataSource() {
		assertNotNull(tds);
	}


	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#cursorConverter(android.database.Cursor)}.
	 */
	@Test
	public void testCursorConverter() {
		long id = 5;
		String name = "bob";
		
		MyCursor cursor = new MyCursor();
		cursor.setLong(id);
		cursor.setString(name);
		
		AbstractData person = tds.cursorConverter(cursor);
		
		assertNull(person);
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#getAllColumns()}.
	 */
	@Test
	public void testGetAllColumns() {
		String[] allColumns = tds.getAllColumns();
		assertNotNull(allColumns);
		assertEquals(2, allColumns.length);
		assertEquals("_id", allColumns[0]);
		assertEquals("date", allColumns[1]);
	}
}

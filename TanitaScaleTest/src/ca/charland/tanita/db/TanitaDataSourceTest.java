package ca.charland.tanita.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.List;

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
		long person = 3;
		Date name = new Date(1324);
		double weight = 134.0;

		MyCursor cursor = new MyCursor();
		cursor.setLong(id);
		cursor.setLong(person);
		cursor.setLong(name.getTime());
		cursor.setDouble(weight);

		TanitaData td = tds.cursorConverter(cursor);

		assertNotNull(td);

		assertEquals(id, td.getId());
		assertEquals(person, td.getPerson());
		assertEquals(name, td.getDate());
		assertEquals(weight, td.getWeight(), 0.1);
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#getAllColumns()}.
	 */
	@Test
	public void testGetAllColumns() {
		List<String> allColumns = tds.getAllColumns();
		assertNotNull(allColumns);
		assertEquals(4, allColumns.size());
		assertEquals("_id", allColumns.get(0));
		assertEquals("person", allColumns.get(1));
		assertEquals("date", allColumns.get(2));
		assertEquals("weight", allColumns.get(3));
	}
}

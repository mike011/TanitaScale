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
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#convertToAbstractData(android.database.Cursor)}.
	 */
	@Test
	public void testCursorConverter() {

		// Setup
		int id = 5;
		int person = 3;
		Date name = new Date(1324);
		double weight = 134.0;
		int dci = 23;

		MyCursor cursor = new MyCursor();
		cursor.setInt(id);
		cursor.setInt(person);
		cursor.setLong(name.getTime());
		cursor.setDouble(weight);
		cursor.setInt(dci);

		// Exercise
		TanitaData td = tds.convertToAbstractData(cursor);

		// Verify
		assertNotNull(td);
		assertEquals(id, td.getId());
		assertEquals(person, td.getPerson());
		assertEquals(name, td.getDate());
		assertEquals(weight, td.getWeight(), 0.1);
		assertEquals(dci, td.getDailyCaloricIntake());
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#getAllColumns()}.
	 */
	@Test
	public void testGetAllColumnsLength() {
		List<String> allColumns = tds.getAllColumns();
		assertNotNull(allColumns);
		assertEquals(5, allColumns.size());
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#getAllColumns()}.
	 */
	@Test
	public void testGetAllColumnsID() {
		List<String> allColumns = tds.getAllColumns();
		assertEquals("_id", allColumns.get(0));
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#getAllColumns()}.
	 */
	@Test
	public void testGetAllColumnsPerson() {
		List<String> allColumns = tds.getAllColumns();
		assertEquals("person", allColumns.get(1));
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#getAllColumns()}.
	 */
	@Test
	public void testGetAllColumnsDate() {
		List<String> allColumns = tds.getAllColumns();
		assertEquals("date", allColumns.get(2));
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#getAllColumns()}.
	 */
	@Test
	public void testGetAllColumnsWeight() {
		List<String> allColumns = tds.getAllColumns();
		assertEquals("weight", allColumns.get(3));
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#getAllColumns()}.
	 */
	@Test
	public void testGetAllColumnsDCI() {
		List<String> allColumns = tds.getAllColumns();
		assertEquals("daily_caloric_intake", allColumns.get(4));
	}
}

package ca.charland.tanita.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;

/**
 * Testing Person Data Source.
 * 
 * @author mcharland.
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class PersonDataSourceTest {

	/** The class under test. */
	private PersonDataSource pds;

	/** Sets things up. */
	@Before
	public void setup() {
		pds = new PersonDataSource(null);
	}

	/** Tears things down. */
	@After
	public void tearDown() {
		pds.close();
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.PersonDataSource#PersonDataSource(android.content.Context)} .
	 */
	@Test
	public void testPersonDataSource() {
		assertNotNull(pds);
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.PersonDataSource#create(java.lang.String)} .
	 */
	@Test
	public void testCreatePerson() {
		pds.open();
		long create = pds.create("bob");
		assertTrue(create != 0);
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.PersonDataSource#delete(ca.charland.tanita.db.Person)} .
	 */
	@Test
	public void testDeletePerson() {
		pds.open();
		int delete = pds.delete(new Person());
		assertEquals(0, delete);
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.PersonDataSource#getAll()}.
	 */
	@Test
	public void testGetAllPeople() {
		pds.open();
		List<AbstractData> allPeople = pds.getAll();
		assertNotNull(allPeople);
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.PersonDataSource#cursorConverter(android.database.Cursor)} .
	 */
	@Test
	public void testCursorConverter() {
		long id = 5;
		String name = "bob";
		
		MyCursor cursor = new MyCursor();
		cursor.setLong(id);
		cursor.setString(name);
		
		Person person = pds.cursorConverter(cursor);
		
		assertEquals(id, person.getId());
		assertEquals(name, person.getName());
	}
	
	/**
	 * Test method for {@link ca.charland.tanita.db.PersonDataSource#getAllColumns()} .
	 */
	@Test
	public void testGetAllColumns() {
		List<String> allColumns = pds.getAllColumns();
		assertEquals(2, allColumns.size());
		assertEquals("_id", allColumns.get(0));
		assertEquals("name", allColumns.get(1));
	}

}

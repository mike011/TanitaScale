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
	 * Test method for {@link ca.charland.tanita.db.PersonDataSource#create(java.lang.String, String)} .
	 */
	@Test
	public void testCreatePerson() {
		pds.open();
		long create = pds.create("bob", "a@b.ca", "boy");
		assertTrue(create != 0);
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.PersonDataSource#delete(ca.charland.tanita.db.PersonData)} .
	 */
	@Test
	public void testDeletePerson() {
		pds.open();
		int delete = pds.delete(new PersonData());
		assertEquals(0, delete);
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.PersonDataSource#getAll()}.
	 */
	@Test
	public void testGetAllPeople() {
		pds.open();
		List<Data> allPeople = pds.getAll();
		assertNotNull(allPeople);
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.PersonDataSource#convertToAbstractData(android.database.Cursor)} .
	 */
	@Test
	public void testCursorConverter() {
		int id = 5;
		String name = "bob";
		String email = "q@r.co.uk";

		CustomCursor cursor = new CustomCursor();
		cursor.setInt(0, id);
		cursor.setString(1, name);
		cursor.setString(2, email);

		PersonData person = pds.convertToAbstractData(cursor);
		
		assertEquals(id, person.getId());
		assertEquals(name, person.getName());
		assertEquals(email, person.getEmail());
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.PersonDataSource#getAllColumns()} .
	 */
	@Test
	public void testGetAllColumns() {
		List<String> allColumns = pds.getAllColumns();
		assertEquals(4, allColumns.size());
		assertEquals("_id", allColumns.get(0));
		assertEquals("name", allColumns.get(1));
		assertEquals("email", allColumns.get(2));
		assertEquals("sex", allColumns.get(3));
	}
}

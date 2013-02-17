package ca.charland.tanita.db;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaRobolectricTestRunner;
import ca.charland.tanita.base.db.CustomCursor;
import ca.charland.tanita.base.db.Data;

@RunWith(TanitaRobolectricTestRunner.class)
public class PersonDataSourceTest {

	private PersonDataSource pds;

	@Before
	public void setup() {
		pds = new PersonDataSource(null);
	}

	@After
	public void tearDown() {
		pds.closeDatabaseConnection();
	}

	@Test
	public void testPersonDataSource() {
		assertThat(pds, is(notNullValue()));
	}

	@Test
	public void testCreatePerson() {
		pds.openDatabaseConnection();
		long create = pds.create("bob", "a@b.ca", "boy");
		assertThat(create, is(not((long) 0)));
	}

	@Test
	public void testGetAllPeople() {
		pds.openDatabaseConnection();
		List<Data> allPeople = pds.getAllValues();
		assertThat(allPeople, is(notNullValue()));
	}

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

		assertThat(person.getId(), is(id));
		assertThat(person.getName(), is(name));
		assertThat(person.getEmail(), is(email));
	}

	@Test
	public void testGetAllColumns() {
		List<String> allColumns = pds.getAllColumns();
		assertThat(allColumns.size(), is(4));
		assertThat(allColumns.get(0), is("_id"));
		assertThat(allColumns.get(1), is("name"));
		assertThat(allColumns.get(2), is("email"));
		assertThat(allColumns.get(3), is("sex"));
	}
}

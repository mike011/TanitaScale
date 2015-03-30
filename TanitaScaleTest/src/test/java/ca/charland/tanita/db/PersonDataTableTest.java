package ca.charland.tanita.db;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PersonDataTableTest {

	@Test
	public void testCreate() {
		assertThat(PersonDataTable.CREATE_PEOPLE_TABLE,
				is("create table person( _id integer primary key autoincrement, name text not null, email text not null, sex text not null);"));
	}

}

package ca.charland.tanita.base.db;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BasicPersonDataTableTest {

	/**
	 * Test that the CREATE method has been generated correctly.
	 */
	@Test
	public void testCreate() {
		assertThat(BasicPersonDataTable.CREATE_PEOPLE_TABLE, is("create table person( _id integer primary key autoincrement, name text not null);"));
	}

}

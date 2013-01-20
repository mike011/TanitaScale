package ca.charland.tanita.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonDataTableTest {

	/**
	 * Test that the CREATE method has been generated correctly.
	 */
	@Test
	public void testCreate() {
		assertEquals("create table person( _id integer primary key autoincrement, name text not null, email text not null, sex text not null);", PersonDataTable.CREATE_PEOPLE_TABLE);
	}

}

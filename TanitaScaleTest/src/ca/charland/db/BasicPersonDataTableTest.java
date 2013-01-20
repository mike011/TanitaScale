package ca.charland.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicPersonDataTableTest {

	/**
	 * Test that the CREATE method has been generated correctly.
	 */
	@Test
	public void testCreate() {
		assertEquals("create table person( _id integer primary key autoincrement, name text not null);", BasicPersonDataTable.CREATE_PEOPLE_TABLE);
	}

}

package ca.charland.tanita.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import ca.charland.tanita.db.Database;

/**
 * Testing Database.
 * 
 * @author mcharland
 *
 */
public class DatabaseTest {

	/**
	 * Test method for {@link ca.charland.tanita.db.Database#getPeople()}.
	 */
	@Test
	public void testGetPeople() {
		List<String> peeps = Database.getPeople();
		assertNotNull(peeps);
		assertEquals(2, peeps.size());
	}

}

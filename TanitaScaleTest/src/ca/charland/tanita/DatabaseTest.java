package ca.charland.tanita;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

/**
 * Testing Database.
 * 
 * @author mcharland
 *
 */
public class DatabaseTest {

	/**
	 * Test method for {@link ca.charland.tanita.Database#getPeople()}.
	 */
	@Test
	public void testGetPeople() {
		List<String> peeps = Database.getPeople();
		assertNotNull(peeps);
		assertEquals(2, peeps.size());
	}

}

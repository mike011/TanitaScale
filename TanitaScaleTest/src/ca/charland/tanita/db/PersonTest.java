package ca.charland.tanita.db;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for Person
 * 
 * @author defected
 * 
 */
public class PersonTest {

	/**
	 * Test method for get and set ID.
	 */
	@Test
	public void testID() {
		Person p = new Person();
		int id = 1234;
		p.setId(id);
		assertEquals(id, p.getId());

	}

	/**
	 * Test method for get and set name..
	 */
	@Test
	public void testName() {
		Person p = new Person();
		String name = "bob";
		p.setName(name);
		assertEquals(name, p.getName());
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.Person#toString()}.
	 */
	@Test
	public void testToString() {
		Person p = new Person();
		String name = "bob";
		p.setName(name);
		assertEquals(name, p.toString());
	}

}

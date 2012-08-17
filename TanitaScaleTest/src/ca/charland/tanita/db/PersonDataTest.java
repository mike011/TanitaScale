package ca.charland.tanita.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for Person Data
 * 
 * @author defected
 * 
 */
public class PersonDataTest {

	/**
	 * Test method for get and set ID.
	 */
	@Test
	public void testID() {
		PersonData p = new PersonData();
		int id = 1234;
		p.setId(id);
		assertEquals(id, p.getId());

	}

	/**
	 * Test method for get and set name.
	 */
	@Test
	public void testName() {
		PersonData p = new PersonData();
		String name = "Bob";
		p.setName(name);
		assertEquals(name, p.getName());
	}
	
	/**
	 * Test method for get and set for email.
	 */
	@Test
	public void testEmail() {
		PersonData p = new PersonData();
		String email = "a@b.ca";
		p.setEmail(email);
		assertEquals(email, p.getEmail());
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.PersonData#toString()}.
	 */
	@Test
	public void testToString() {
		PersonData p = new PersonData();
		String name = "Frank";
		p.setName(name);
		assertEquals(name, p.toString());
	}

}

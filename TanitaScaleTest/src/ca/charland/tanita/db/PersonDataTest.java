package ca.charland.tanita.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author mcharland
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
	public void testSex() {
		PersonData p = new PersonData();
		String sex = "boy";
		p.setSex(sex);
		assertEquals(sex, p.getSex());
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
}

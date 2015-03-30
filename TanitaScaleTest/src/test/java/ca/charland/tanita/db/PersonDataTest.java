package ca.charland.tanita.db;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
		assertThat(p.getId(), is(id));

	}

	/**
	 * Test method for get and set name.
	 */
	@Test
	public void testSex() {
		PersonData p = new PersonData();
		String sex = "boy";
		p.setSex(sex);
		assertThat(p.getSex(), is(sex));
	}

	/**
	 * Test method for get and set for email.
	 */
	@Test
	public void testEmail() {
		PersonData p = new PersonData();
		String email = "a@b.ca";
		p.setEmail(email);
		assertThat(p.getEmail(), is(email));
	}
}

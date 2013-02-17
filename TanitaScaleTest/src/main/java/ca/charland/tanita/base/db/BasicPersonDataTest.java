package ca.charland.tanita.base.db;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BasicPersonDataTest {

	@Test
	public void testName() {
		BasicPersonData p = new BasicPersonData();
		String name = "Bob";
		p.setName(name);
		assertThat(p.getName(), is(name));
	}

	@Test
	public void testToString() {
		BasicPersonData p = new BasicPersonData();
		String name = "Frank";
		p.setName(name);
		assertEquals(name, p.toString());
		assertThat(p.toString(), is(name));
	}
}

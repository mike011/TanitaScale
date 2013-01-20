package ca.charland.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicPersonDataTest {

	@Test
	public void testName() {
		BasicPersonData p = new BasicPersonData();
		String name = "Bob";
		p.setName(name);
		assertEquals(name, p.getName());
	}

	@Test
	public void testToString() {
		BasicPersonData p = new BasicPersonData();
		String name = "Frank";
		p.setName(name);
		assertEquals(name, p.toString());
	}
}

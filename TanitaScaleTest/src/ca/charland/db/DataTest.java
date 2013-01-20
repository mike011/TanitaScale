package ca.charland.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DataTest {

	@Test
	public void testId() throws Exception {
		Data data = new Data();
		int id = 234;
		data.setId(id);
		assertEquals(id, data.getId());
	}
}

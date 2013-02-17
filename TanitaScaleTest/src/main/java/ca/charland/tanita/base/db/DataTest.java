package ca.charland.tanita.base.db;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class DataTest {

	@Test
	public void testId() throws Exception {
		Data data = new Data();
		int id = 234;
		data.setId(id);
		assertThat(data.getId(), is(id));
	}
}

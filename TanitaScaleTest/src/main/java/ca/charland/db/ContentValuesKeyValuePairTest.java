package ca.charland.db;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ContentValuesKeyValuePairTest {

	/**
	 * Test method for {@link ca.charland.db.ContentValuesKeyValuePair#getKey()}.
	 */
	@Test
	public void testGetKey() {
		String key = "monkey";
		ContentValuesKeyValuePair pair = new ContentValuesKeyValuePair(key, "");
		assertThat(pair.getKey(), is(key));
	}

	/**
	 * Test method for {@link ca.charland.db.ContentValuesKeyValuePair#getValue()}.
	 */
	@Test
	public void testGetValue() {
		String value = "monkey";
		ContentValuesKeyValuePair pair = new ContentValuesKeyValuePair("", value);
		assertThat(pair.getValue(), is(value));
	}

}

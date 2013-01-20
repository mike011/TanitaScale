package ca.charland.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContentValuesKeyValuePairTest {

	/**
	 * Test method for {@link ca.charland.db.ContentValuesKeyValuePair#getKey()}.
	 */
	@Test
	public void testGetKey() {
		String key = "monkey";
		ContentValuesKeyValuePair pair = new ContentValuesKeyValuePair(key, "");
		assertEquals(key, pair.getKey());
	}

	/**
	 * Test method for {@link ca.charland.db.ContentValuesKeyValuePair#getValue()}.
	 */
	@Test
	public void testGetValue() {
		String value = "monkey";
		ContentValuesKeyValuePair pair = new ContentValuesKeyValuePair("", value);
		assertEquals(value, pair.getValue());
	}

}

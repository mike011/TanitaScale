package ca.charland.tanitascale;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class DayDataTest {

	@Test
	public void testKeySet() {
		Map<Column, String> values = new TreeMap<Column, String>();
		DayData dd = new DayData(values);
		assertTrue(dd.keySet().isEmpty());
	}

	@Test
	public void testGet() {
		DayData dd = getDayDataWithDate();
		assertEquals("2013-10-10", dd.get(Column.DATE));
	}

	@Test
	public void testCompareTo() {
		DayData dd = getDayDataWithDate();
		assertEquals(0, dd.compareTo(dd));
	}
	
	private DayData getDayDataWithDate() {
		Map<Column, String> values = new TreeMap<Column, String>();
		values.put(Column.DATE, "2013-10-10");
		DayData dd = new DayData(values);
		return dd;
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCompareToParseException() {
		Map<Column, String> values = new TreeMap<Column, String>();
		values.put(Column.DATE, "bla");
		DayData dd = new DayData(values);
		dd.compareTo(dd);
	}
}

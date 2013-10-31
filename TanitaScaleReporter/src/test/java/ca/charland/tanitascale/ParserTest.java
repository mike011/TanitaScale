package ca.charland.tanitascale;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ParserTest {

	@Test
	public void testParseSingleDay() {
		Parser p = new Parser();
		String[] args = new String[]{"Date", "=", "2013-10-09"};
		DayData dd = p.parseSingleDay(args);
		assertEquals(dd.get(Column.DATE), "2013-10-09");
	}

	@Test
	public void testParseFileContents() {
		Parser p = new Parser();
		List<String> contents = getContentsWithDate();
		DayData dd = p.parseFileContents(contents);
		assertEquals(dd.get(Column.DATE), "2013-10-09");
	}
	
	@Test
	public void testMultipleValues() {
		Parser p = new Parser();
		List<String> contents = getContentsWithDate();
		contents.add("Total Body Fat = 15%");
		DayData dd = p.parseFileContents(contents);
		assertEquals("0.15", dd.get(Column.BODY_FAT_TOTAL));
	}

	private List<String> getContentsWithDate() {
		List<String> contents = new ArrayList<String>();
		contents.add("Date = 2013-10-09");
		return contents;
	}
	

}

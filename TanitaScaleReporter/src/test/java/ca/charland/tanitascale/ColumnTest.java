package ca.charland.tanitascale;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColumnTest {

	@Test
	public void testToString() {
		assertEquals("Date", Column.DATE.toString());
	}

}

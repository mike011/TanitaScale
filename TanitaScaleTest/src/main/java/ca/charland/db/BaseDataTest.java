package ca.charland.db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class BaseDataTest {

	@Test
	public void testPerson() {
		BaseData bd = new BaseData();
		long person = 12341234L;
		bd.setPerson(person);
		assertThat(bd.getPerson(), is(person));
	}

	@Test
	public void testDate() {
		BaseData bd = new BaseData();
		Date date = Calendar.getInstance().getTime();
		bd.setDate(date);
		assertThat(bd.getDate(), is(date));
	}

}

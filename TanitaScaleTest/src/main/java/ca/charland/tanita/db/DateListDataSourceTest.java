package ca.charland.tanita.db;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaRobolectricTestRunner;
import ca.charland.tanita.base.db.CustomCursor;
import ca.charland.tanita.base.db.Data;

@RunWith(TanitaRobolectricTestRunner.class)
public class DateListDataSourceTest {

	private TanitaDateListDataSource dateList;

	@Before
	public void setup() {
		dateList = new TanitaDateListDataSource(null);
	}

	@After
	public void tearDown() {
		dateList.closeDatabaseConnection();
	}

	@Test
	public void testDateListDataSource() {
		assertThat(dateList, is(notNullValue()));
	}

	@Test
	public void testConvertToAbstractData() {
		int id = 5;
		int person = 53;
		long date = 112341234L;

		CustomCursor cursor = new CustomCursor();
		cursor.setInt(0, id);
		cursor.setInt(1, person);
		cursor.setLong(2, date);

		Data data = dateList.convertToAbstractData(cursor);

		assertThat(data.getId(), is(id));
	}

	@Test
	public void testGetAllColumns() {
		List<String> allColumns = dateList.getAllColumns();
		assertThat(allColumns.size(), is(3));
		assertThat(allColumns.get(0), is("_id"));
		assertThat(allColumns.get(1), is("person"));
		assertThat(allColumns.get(2), is("date"));
	}
}

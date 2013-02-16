package ca.charland.db;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DateListDataSourceTest {

	private DateListDataSource datasource;

	@Before
	public void setup() {
		datasource = new DateListDataSource(null);
	}

	@Test
	public void testConstructor() {
		assertThat(datasource, is(notNullValue()));
	}

	@Test
	public void testConvertToAbstractData() {
		CustomCursor c = new CustomCursor();
		c.setInt(DataTable.Column.ID.ordinal(), 1);
		c.setInt(DataTable.Column.PERSON.ordinal(), 2);
		c.setLong(DataTable.Column.DATE.ordinal(), 3);
		Data convertToAbstractData = datasource.convertToAbstractData(c);
		assertThat(convertToAbstractData, is(notNullValue()));

	}

	@Test
	public void testGetAllColumns() {
		List<String> allColumns = datasource.getAllColumns();
		assertThat(allColumns.size(), is(3));
	}

	@Test
	public void testGetData() {
		BaseData data = datasource.getData();
		assertThat(data, is(notNullValue()));
	}

}

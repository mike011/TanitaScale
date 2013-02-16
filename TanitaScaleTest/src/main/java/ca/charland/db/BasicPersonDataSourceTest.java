package ca.charland.db;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;
import ca.charland.robolectric.BaseRobolectricTestRunner;

@RunWith(BaseRobolectricTestRunner.class)
public class BasicPersonDataSourceTest {

	private BasicPersonDataSource bpds;

	@Before
	public void setup() {
		bpds = new BasicPersonDataSource(null, null, null, null);
	}

	@After
	public void tearDown() {
		bpds.closeDatabaseConnection();
	}

	@Test
	public void testBasicPersonDataSource() {
		assertThat(bpds, notNullValue());
	}

	@Test
	public void testGetAllColumns() {
		List<String> allColumns = bpds.getAllColumns();
		assertThat(allColumns.size(), is(2));
		assertThat(allColumns.get(0), is("_id"));
		assertThat(allColumns.get(1), is("name"));
	}

	@Test
	public void testPopulateContentValuesKeyValuePairs() {
		String value = "frank";
		bpds.populateContentValuesKeyValuePairs(value);
		ContentValues contentValues = bpds.getContentValues();
		assertThat(contentValues.size(), is(1));
		String columnValue = (String) contentValues.get(BasicPersonDataTable.Column.NAME.toString());
		assertThat(columnValue, is(value));
	}

	@Test
	public void testConvertToAbstractDataCursor() {
		int id = 5;
		String name = "bob";

		CustomCursor cursor = new CustomCursor();
		cursor.setInt(0, id);
		cursor.setString(1, name);

		BasicPersonData person = bpds.convertToAbstractData(cursor);

		assertThat(person.getId(), is(id));
		assertThat(person.getName(), is(name));
	}

}

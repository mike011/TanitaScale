package ca.charland.tanita.base.db;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import ca.charland.robolectric.BaseRobolectricTestRunner;

@RunWith(BaseRobolectricTestRunner.class)
public class DataSourceTest {

	private DataSource pds;

	private static class MyDataSource extends DataSource {

		public MyDataSource(Context context, String database, String table, String createTableSQL) {
			super(new DatabaseConnection(context, database, table, createTableSQL));
		}

		@Override
		protected Data convertToAbstractData(Cursor cursor) {
			return null;
		}

		@Override
		protected List<String> getAllColumns() {
			return new ArrayList<String>();
		}
	}

	@Before
	public void setup() {
		pds = new MyDataSource(null, "db", "table", "");
		pds.openDatabaseConnection();
	}

	@After
	public void tearDown() {
		pds.closeDatabaseConnection();
	}

	@Test
	public void testDataSource() {
		assertThat(pds, is(notNullValue()));
	}

	@Test
	public void testOpenDatabaseConnection() {
		assertThat(pds.isDatabaseConnectionOpen(), is(true));
	}

	@Test
	public void testInsertTableRow() {
		long id = pds.insertTableRow(new ContentValues());
		assertThat(id, equalTo((long) -1));
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testUpdateTableRow() {
		pds.updateTableRow("id", 0, new ContentValues());
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testGetAllValues() {
		pds.getAllValues();
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testQuery() {
		pds.query("");
	}

	@Test(expected = java.lang.RuntimeException.class)
	public void testQueryWithOrdering() {
		pds.queryWithOrdering("", "");
	}

	@Test
	public void testConvertToAbstractData() {
		assertThat(pds.convertToAbstractData(null), is(nullValue()));
	}

	@Test
	public void testGetAllColumns() {
		assertThat(pds.getAllColumns(), is(notNullValue()));
	}

	@Test
	public void testCloseDatabaseConnection() {
		pds.closeDatabaseConnection();
		assertThat(pds.isDatabaseConnectionOpen(), is(false));
	}
}

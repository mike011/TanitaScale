package ca.charland.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;

@RunWith(TanitaMeRobolectricTestRunner.class)
public class DataSourceTest {

	private DataSource pds;

	private static class MyDataSource extends DataSource {

		public MyDataSource(Context context, String database, String table, String createTableSQL) {
			super(new DatabaseHelper(context, database, table, createTableSQL));
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
		assertNotNull(pds);
	}

	@Test
	public void testOpenDatabaseConnection() {
		assertTrue(pds.isDatabaseConnectionOpen());
	}

	@Test
	public void testInsertTableRow() {
		long id = pds.insertTableRow(new ContentValues());
		assertEquals(-1, id);
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
		assertNull(pds.convertToAbstractData(null));
	}

	@Test
	public void testGetAllColumns() {
		assertNotNull(pds.getAllColumns());
	}

	@Test
	public void testCloseDatabaseConnection() {
		pds.closeDatabaseConnection();
		assertFalse(pds.isDatabaseConnectionOpen());
	}

}

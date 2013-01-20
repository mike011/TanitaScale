package ca.charland.db;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import android.database.Cursor;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.PersonDataSource;

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
			return null;
		}
	}

	@Before
	public void setup() {
		pds = new MyDataSource(null, null, null, null);
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
		pds.openDatabaseConnection();
		assertTrue(pds.isDatabaseConnectionOpen());
	}

	@Test
	public void testInsertTableRow() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTableRow() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllValues() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryWithOrdering() {
		fail("Not yet implemented");
	}

	@Test
	public void testConvertToAbstractData() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllColumns() {
		fail("Not yet implemented");
	}

	@Test
	public void testCloseDatabaseConnection() {
		pds.closeDatabaseConnection();
		assertFalse(pds.isDatabaseConnectionOpen());
	}

}

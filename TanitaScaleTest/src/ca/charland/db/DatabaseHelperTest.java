package ca.charland.db;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQuery;

@RunWith(TanitaMeRobolectricTestRunner.class)
public class DatabaseHelperTest {

	private DatabaseHelper helper;

	@Before
	public void setup() {
		helper = new DatabaseHelper(null, null, null, null);
	}
	
	@Test
	public void testDatabaseHelper() {
		assertNotNull(helper);
	}
	
	@Test
	public void testOnCreateSQLiteDatabase() {
//		helper.onCreate(create);
	}

	@Test
	public void testOnUpgradeSQLiteDatabaseIntInt() {
		helper.onUpgrade(null, 1, 2);
	}

	@Test
	public void testGetTableName() {
		fail("Not yet implemented");
	}

}

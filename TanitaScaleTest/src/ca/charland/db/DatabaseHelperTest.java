package ca.charland.db;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.database.sqlite.SQLiteDatabase;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.shadows.ShadowSQLiteDatabase;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;

@RunWith(TanitaMeRobolectricTestRunner.class)
public class DatabaseHelperTest {

	private DatabaseHelper helper;

	@BeforeClass 
	public static void beforeClass() {
		Robolectric.bindShadowClass(ShadowSQLiteDatabase.class);
	}
	
	@Before
	public void setup() {
		helper = new DatabaseHelper(null, null, null, "");
	}

	@Test
	public void testDatabaseHelper() {
		assertNotNull(helper);
	}

	@Test
	public void testOnCreateSQLiteDatabase() {
		SQLiteDatabase db = SQLiteDatabase.openDatabase("path", null, 0); 
		helper.onCreate(db);
	}

	@Test
	public void testOnUpgradeSQLiteDatabaseIntInt() {
		SQLiteDatabase db = SQLiteDatabase.openDatabase("path", null, 0);
		helper.onUpgrade(db, 1, 2);
	}

	@Test
	public void testGetTableName() {
		fail("Not yet implemented");
	}

}

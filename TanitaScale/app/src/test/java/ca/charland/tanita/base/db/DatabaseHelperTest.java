package ca.charland.tanita.base.db;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.BaseRobolectricTestRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(BaseRobolectricTestRunner.class)
public class DatabaseHelperTest
{

    private DatabaseConnection helper;
    private final String table = "bob";

	/*@BeforeClass
    public static void beforeClass() {
		Robolectric.bindShadowClass(ShadowSQLiteDatabase.class);
	}*/

    @Before
    public void setup()
    {
        helper = new DatabaseConnection(null, null, table, "");
    }

    @Test
    public void testDatabaseHelper()
    {
        assertThat(helper, is(notNullValue()));
    }

    @Test
    public void testOnCreateSQLiteDatabase()
    {
        SQLiteDatabase db = SQLiteDatabase.openDatabase("path", null, 0);
        helper.onCreate(db);
    }

    @Test(expected = SQLException.class)
    public void testOnUpgradeSQLiteDatabaseIntInt()
    {
        SQLiteDatabase db = SQLiteDatabase.openDatabase("path", null, 0);
        helper.onUpgrade(db, 1, 2);
    }

    @Test
    public void testGetTableName()
    {
        assertThat(helper.getTableName(), is(table));
    }
}

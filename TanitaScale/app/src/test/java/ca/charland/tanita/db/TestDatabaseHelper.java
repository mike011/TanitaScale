package ca.charland.tanita.db;

import android.content.Context;
import ca.charland.tanita.base.db.DatabaseConnection;

public class TestDatabaseHelper extends DatabaseConnection {

	public TestDatabaseHelper(Context context, String database, String table, String createTableSQL) {
		super(context, database, table, createTableSQL);
	}

}

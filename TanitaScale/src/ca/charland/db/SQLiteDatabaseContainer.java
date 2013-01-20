package ca.charland.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class SQLiteDatabaseContainer {
	
	private SQLiteDatabase db;

	public void create(CursorFactory factory) {
		db = SQLiteDatabase.create(factory);
	}
	
	public SQLiteDatabase get() {
		return db;
	}
}

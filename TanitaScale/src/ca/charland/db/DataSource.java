package ca.charland.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Holds common implementations for dealing with data sources.
 * 
 * @author mcharland
 * 
 */
public abstract class DataSource {

	protected SQLiteDatabase database;

	private final DatabaseHelper databaseHelper;

	private boolean open;

	public DataSource(DatabaseHelper helper) {
		this.databaseHelper = helper;
	}

	public void openDatabaseConnection() throws SQLException {
		database = databaseHelper.getWritableDatabase();
		open = true;
	}

	public void checkForTable() {
		if(!tableExists(databaseHelper.getTableName())) {
			databaseHelper.onCreate(database);
		}
	}

	private boolean tableExists(String tableName) {
		Cursor cursor = database.rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + tableName + "'", null);
		if (cursor != null) {
			if (cursor.getCount() > 0) {
				cursor.close();
				return true;
			}
			cursor.close();
		}
		return false;
	}

	public long insertTableRow(ContentValues values) {
		long insert = database.insert(databaseHelper.getTableName(), null, values);
		return insert;
	}

	public long updateTableRow(String id, Object idValue, ContentValues values) {
		long effected = database.update(databaseHelper.getTableName(), values, id + '=' + idValue, null);
		return effected;
	}

	public List<Data> getAllValues() {
		return query(null);
	}

	public List<Data> query(String selection) {
		return queryWithOrdering(selection, null);
	}

	public List<Data> queryWithOrdering(String selection, String orderBy) {
		String[] columns = getAllColumns().toArray(new String[0]);
		Cursor cursor = database.query(databaseHelper.getTableName(), columns, selection, null, null, null, orderBy);
		List<Data> populateAll = populateAll(cursor);
		cursor.close();
		return populateAll;
	}

	private List<Data> populateAll(Cursor cursor) {
		List<Data> all = new ArrayList<Data>();
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Data comment = convertToAbstractData(cursor);
			all.add(comment);
			cursor.moveToNext();
		}
		return all;
	}

	protected abstract Data convertToAbstractData(Cursor cursor);

	protected abstract List<String> getAllColumns();

	public void closeDatabaseConnection() {
		databaseHelper.close();
		if(database != null) {
			database.close();	
		}
		open = false;
	}

	public boolean isDatabaseConnectionOpen() {
		return open;
	}

	public DatabaseHelper getDatabaseHelper() {
		return databaseHelper;
	}
}

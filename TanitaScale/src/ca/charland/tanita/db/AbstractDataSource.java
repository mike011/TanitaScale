package ca.charland.tanita.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Holds common implementations for dealing with data sources.
 * 
 * @author mcharland
 * 
 */
public abstract class AbstractDataSource {

	/** The database. */
	protected SQLiteDatabase database;

	/** The database helper. */
	private DatabaseHelper databaseHelper;

	/** The table. */
	final private String table;

	/**
	 * Instantiates a new person data source.
	 * 
	 * @param context
	 *            the context
	 */
	public AbstractDataSource(Context context, String table) {
		this.databaseHelper = new DatabaseHelper(context);
		this.table = table;
	}

	/**
	 * Open the database connection.
	 * 
	 * @throws SQLException
	 *             the sQL exception
	 */
	public void open() throws SQLException {
		database = databaseHelper.getWritableDatabase();
	}

	/**
	 * Creates the table row.
	 * 
	 * @param values
	 *            the values
	 * @return the row ID
	 */
	public long insert(ContentValues values) {
		long insert = database.insert(table, null, values);
		return insert;
	}

	/**
	 * Updates the table row.
	 * 
	 * @param values
	 *            the values
	 * @return The number or rows effected.
	 */
	public long update(String id, Object idValue, ContentValues values) {
		long effected = database.update(table, values, id + '=' + idValue, null);
		return effected;
	}

	/**
	 * Gets the all values.
	 * 
	 * @return the all values
	 */
	public List<AbstractData> getAll() {
		return query(null);
	}

	/**
	 * Query.
	 * 
	 * @param selection
	 *            the selection to pair down the results.
	 * 
	 * @return the list
	 */
	public List<AbstractData> query(String selection) {
		List<AbstractData> all = new ArrayList<AbstractData>();
		String[] columns = getAllColumns().toArray(new String[0]);
		Cursor cursor = database.query(table, columns, selection, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			AbstractData comment = convertToAbstractData(cursor);
			all.add(comment);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return all;
	}

	/**
	 * Cursor conversion.
	 * 
	 * @param cursor
	 *            the cursor
	 * @return The converted value.
	 */
	protected abstract AbstractData convertToAbstractData(Cursor cursor);

	/**
	 * Gets all columns.
	 * 
	 * @return all columns
	 */
	protected abstract List<String> getAllColumns();

	/**
	 * Close the database connection.
	 */
	public void close() {
		databaseHelper.close();
	}
}

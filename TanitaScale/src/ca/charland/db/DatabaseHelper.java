package ca.charland.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * The Class DatabaseHelper, the base class that puts all the database stuff together.
 * 
 * @author mcharland
 */
public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "tanita.db";

	private static final int DATABASE_VERSION = 1;

	private final String tableName;

	private final String createTable;

	/**
	 * Instantiates a new names database.
	 * 
	 * @param context
	 *            the context
	 */
	public DatabaseHelper(Context context, String createTable, String table) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.createTable = createTable;
		this.tableName = table;
	}

	/** {@inheritDoc} */
	@Override
	public void onCreate(SQLiteDatabase database) {
		createTables(database);
	}

	private void createTables(SQLiteDatabase database) {
		database.execSQL(createTable);
	}

	/** {@inheritDoc} */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DatabaseHelper.class.getName(), getMessage(oldVersion, newVersion));
		dropTables(db);
		onCreate(db);
	}

	private void dropTables(SQLiteDatabase db) {
		db.execSQL("DROP TABLE IF EXISTS" + tableName);
	}

	private String getMessage(int oldVersion, int newVersion) {
		StringBuilder msg = new StringBuilder();
		msg.append("Upgrading database from version ");
		msg.append(oldVersion);
		msg.append(" to ");
		msg.append(newVersion);
		msg.append(", which will destroy all old data");
		return msg.toString();
	}

}
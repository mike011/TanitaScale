package ca.charland.tanita.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * The Class PeopleDatabaseHelper.
 * 
 * @author mcharland
 */
public class PeopleDatabaseHelper extends SQLiteOpenHelper {

	/** The Constant TABLE_PEOPLE. */
	public static final String TABLE_PEOPLE = "person";

	/** The Constant COLUMN_ID. */
	public static final String COLUMN_ID = "_id";

	/** The Constant COLUMN_NAME. */
	public static final String COLUMN_NAME = "name";

	/** The Constant DATABASE_NAME. */
	private static final String DATABASE_NAME = "tanita.db";

	/** The Constant DATABASE_VERSION. */
	private static final int DATABASE_VERSION = 1;

	/** Database creation SQL statement */
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_PEOPLE + "( " + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_NAME
			+ " text not null);";

	/**
	 * Instantiates a new names database.
	 * 
	 * @param context
	 *            the context
	 */
	public PeopleDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/** {@inheritDoc} */
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	/** {@inheritDoc} */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		StringBuilder msg = new StringBuilder();
		msg.append("Upgrading database from version ");
		msg.append(oldVersion);
		msg.append(" to ");
		msg.append(newVersion);
		msg.append(", which will destroy all old data");
		Log.w(PeopleDatabaseHelper.class.getName(), msg.toString());
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_PEOPLE);
		onCreate(db);
	}

}
package ca.charland.tanita.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * The Class DatabaseHelper, the base class that puts all the db stuff together.
 * 
 * @author mcharland
 */
public class DatabaseHelper extends SQLiteOpenHelper {

	/** The Constant DATABASE_NAME. */
	private static final String DATABASE_NAME = "tanita.db";

	/** The Constant DATABASE_VERSION. */
	private static final int DATABASE_VERSION = 1;

	/**
	 * Instantiates a new names database.
	 * 
	 * @param context
	 *            the context
	 */
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	/** {@inheritDoc} */
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(PeopleTable.CREATE);
		database.execSQL(TanitaDataTable.CREATE);
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
		Log.w(DatabaseHelper.class.getName(), msg.toString());
		db.execSQL("DROP TABLE IF EXISTS" + PeopleTable.TABLE);
		db.execSQL("DROP TABLE IF EXISTS" + TanitaDataTable.NAME);
		onCreate(db);
	}

}
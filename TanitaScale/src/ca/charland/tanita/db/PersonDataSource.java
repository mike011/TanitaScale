package ca.charland.tanita.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * The Class PersonDataSource.
 * 
 * @author mcharland
 */
public class PersonDataSource {

	/** The database. */
	private SQLiteDatabase database;

	/** The database helper. */
	private PeopleDatabaseHelper databaseHelper;

	/** The all columns. */
	private String[] allColumns = { PeopleDatabaseHelper.COLUMN_ID,
			PeopleDatabaseHelper.COLUMN_NAME };

	/**
	 * Instantiates a new person data source.
	 * 
	 * @param context
	 *            the context
	 */
	public PersonDataSource(Context context) {
		databaseHelper = new PeopleDatabaseHelper(context);
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
	 * Close the database connection.
	 */
	public void close() {
		databaseHelper.close();
	}

	/**
	 * Creates the person.
	 * 
	 * @param name
	 *            The name of the person.
	 * @return the long value
	 */
	public long createPerson(String name) {
		ContentValues values = new ContentValues();
		values.put(PeopleDatabaseHelper.COLUMN_NAME, name);
		long insert = database.insert(PeopleDatabaseHelper.TABLE_PEOPLE, null,
				values);
		return insert;
	}

	/**
	 * Delete a person.
	 * 
	 * @param name
	 *            the name
	 * @return the return value
	 */
	public int deletePerson(Person name) {
		long id = name.getId();
		System.out.println("Person deleted with id: " + id);
		int delete = database.delete(PeopleDatabaseHelper.TABLE_PEOPLE,
				PeopleDatabaseHelper.COLUMN_ID + " = " + id, null);
		return delete;
	}

	/**
	 * Gets the all people.
	 * 
	 * @return the all people
	 */
	public List<Person> getAllPeople() {
		List<Person> people = new ArrayList<Person>();
		Cursor cursor = database.query(PeopleDatabaseHelper.TABLE_PEOPLE,
				allColumns, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Person comment = cursorToPerson(cursor);
			people.add(comment);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return people;
	}

	/**
	 * Convert from a cursor to person.
	 * 
	 * @param cursor
	 *            the cursor
	 * @return the person
	 */
	private Person cursorToPerson(Cursor cursor) {
		Person person = new Person();
		person.setId(cursor.getLong(0));
		person.setName(cursor.getString(1));
		return person;
	}
}

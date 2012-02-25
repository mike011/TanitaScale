package ca.charland.tanita.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

/**
 * The Class PersonDataSource which holds the database information related to a person.
 * 
 * @author mcharland
 */
public class PersonDataSource extends AbstractDataSource {

	/**
	 * Instantiates a new person data source.
	 * 
	 * @param context
	 *            the context
	 */
	public PersonDataSource(Context context) {
		super(context, PeopleTable.TABLE);
	}

	/**
	 * Creates the person.
	 * 
	 * @param name
	 *            The name of the person.
	 * @return the long value
	 */
	public long create(String name) {
		ContentValues values = new ContentValues();
		values.put(PeopleTable.COLUMN_NAME, name);
		return insert(values);
	}

	/**
	 * Delete a person.
	 * 
	 * @param name
	 *            the name
	 * @return the return value
	 */
	public int delete(Person name) {
		long id = name.getId();
		System.out.println("Person deleted with id: " + id);
		int delete = database.delete(PeopleTable.TABLE, PeopleTable.COLUMN_ID + " = " + id, null);
		return delete;
	}

	/** {@inheritDoc} */
	protected Person cursorConverter(Cursor cursor) {
		Person person = new Person();
		person.setId(cursor.getLong(0));
		person.setName(cursor.getString(1));
		return person;
	}

	/** {@inheritDoc} */
	@Override
	protected List<String> getAllColumns() {
		List<String>  allColumns = new ArrayList<String>();
		allColumns.add(PeopleTable.COLUMN_ID);
		allColumns.add(PeopleTable.COLUMN_NAME);
		return allColumns;
	}
}

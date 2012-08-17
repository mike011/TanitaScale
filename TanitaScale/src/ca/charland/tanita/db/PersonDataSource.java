package ca.charland.tanita.db;

import java.util.ArrayList;
import java.util.List;

import ca.charland.tanita.db.PersonDataTable.Column;

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
		super(context, PersonDataTable.TABLE);
	}

	/**
	 * Creates the person.
	 * 
	 * @param name
	 *            The name of the person.
	 * @param email
	 *            Your email.
	 * @return the long value
	 */
	public long create(String name, String email) {
		ContentValues values = new ContentValues();
		values.put(PersonDataTable.Column.NAME.toString(), name);
		values.put(PersonDataTable.Column.EMAIL.toString(), email);
		return insert(values);
	}

	/**
	 * Delete a person.
	 * 
	 * @param name
	 *            the name
	 * @return the return value
	 */
	public int delete(PersonData name) {
		long id = name.getId();
		System.out.println("Person deleted with id: " + id);
		int delete = database.delete(PersonDataTable.TABLE, PersonDataTable.Column.ID + " = " + id, null);
		return delete;
	}

	/** {@inheritDoc} */
	protected PersonData convertToAbstractData(Cursor cursor) {
		PersonData person = new PersonData();
		person.setId(cursor.getInt(0));
		person.setName(cursor.getString(1));
		person.setEmail(cursor.getString(2));
		return person;
	}

	/** {@inheritDoc} */
	@Override
	protected List<String> getAllColumns() {
		List<String> allColumns = new ArrayList<String>();
		allColumns.add(PersonDataTable.Column.ID.toString());
		allColumns.add(PersonDataTable.Column.NAME.toString());
		allColumns.add(PersonDataTable.Column.EMAIL.toString());
		return allColumns;
	}
}

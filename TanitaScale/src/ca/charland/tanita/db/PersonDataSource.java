package ca.charland.tanita.db;

import java.util.List;

import android.content.Context;
import android.database.Cursor;
import ca.charland.db.BasicPersonData;
import ca.charland.db.BasicPersonDataSource;
import ca.charland.db.ContentValuesKeyValuePair;

/**
 * Holds the database information related to a person.
 * 
 * @author mcharland
 */
public class PersonDataSource extends BasicPersonDataSource {

	public PersonDataSource(Context context) {
		super(context, TanitaDataSource.DATABASE_NAME, PersonDataTable.TABLE_NAME, PersonDataTable.CREATE_PEOPLE_TABLE);
	}

	public long create(String name, String email, String sex) {
		populateContentValuesKeyValuePairs(new String[] { name, email, sex });
		return super.create();
	}

	@Override
	public void populateContentValuesKeyValuePairs(String... values) {
		super.populateContentValuesKeyValuePairs(values[0]);
		pairs.add(new ContentValuesKeyValuePair(PersonDataTable.Column.EMAIL.toString(), values[1]));
		pairs.add(new ContentValuesKeyValuePair(PersonDataTable.Column.SEX.toString(), values[2]));
	}

	protected PersonData convertToAbstractData(Cursor cursor) {
		BasicPersonData basic = super.convertToAbstractData(cursor);
		PersonData person = new PersonData();
		person.setId(basic.getId());
		person.setName(basic.getName());
		person.setEmail(cursor.getString(2));
		person.setSex(cursor.getString(3));
		return person;
	}

	@Override
	protected List<String> getAllColumns() {
		List<String> allColumns = super.getAllColumns();
		allColumns.add(PersonDataTable.Column.EMAIL.toString());
		allColumns.add(PersonDataTable.Column.SEX.toString());
		return allColumns;
	}
}

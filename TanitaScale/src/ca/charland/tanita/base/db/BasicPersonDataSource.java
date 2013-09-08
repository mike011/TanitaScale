package ca.charland.tanita.base.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;

public class BasicPersonDataSource extends AbstractPersonDataSource {

	public BasicPersonDataSource(Context context) {
		this(context, DatabaseConnection.DATABASE_NAME, BasicPersonDataTable.TABLE_NAME, BasicPersonDataTable.CREATE_PEOPLE_TABLE);
	}

	public BasicPersonDataSource(Context context, String database, String table, String createPeopleTableSQL) {
		super(context, database, table, createPeopleTableSQL);
	}
	
	public long add(String name) {
		populateContentValuesKeyValuePairs(new String[] { name});
		return super.add();
	}

	@Override
	public void populateContentValuesKeyValuePairs(String... values) {
		pairs.add(new ContentValuesKeyValuePair(BasicPersonDataTable.NAME_COLUMN_NAME, values[0]));
	}

	@Override
	protected BasicPersonData convertToAbstractData(Cursor cursor) {
		BasicPersonData person = new BasicPersonData();
		person.setId(cursor.getInt(0));
		person.setName(cursor.getString(1));
		return person;
	}

	@Override
	protected List<String> getAllColumns() {
		List<String> allColumns = new ArrayList<String>();
		allColumns.add(BasicPersonDataTable.ID_COLUMN_NAME);
		allColumns.add(BasicPersonDataTable.NAME_COLUMN_NAME);
		return allColumns;
	}
}

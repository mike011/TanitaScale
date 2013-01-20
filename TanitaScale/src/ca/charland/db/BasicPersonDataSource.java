package ca.charland.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import ca.charland.tanita.db.PersonDataTable;

public class BasicPersonDataSource extends AbstractPersonDataSource {

	public BasicPersonDataSource(Context context, String createPeopleTable, String table) {
		super(context, createPeopleTable, table);
	}
	
	@Override
	public void populateContentValuesKeyValuePairs(String... values) {
		pairs.add(new ContentValuesKeyValuePair(PersonDataTable.Column.NAME.toString(), values[0]));
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
		allColumns.add(PersonDataTable.Column.ID.toString());
		allColumns.add(PersonDataTable.Column.NAME.toString());
		return allColumns;
	}
}

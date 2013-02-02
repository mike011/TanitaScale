package ca.charland.db;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ca.charland.tanita.db.TanitaData;
import ca.charland.tanita.db.TanitaDataTable;

import android.database.Cursor;

public class DateListDataSource extends DataSource {

	public DateListDataSource(DatabaseConnection helper) {
		super(helper);
	}

	@Override
	protected Data convertToAbstractData(Cursor cursor) {
		TanitaData td = new TanitaData();
		td.setId(cursor.getInt(TanitaDataTable.Column.ID.ordinal()));
		td.setPerson(cursor.getInt(TanitaDataTable.Column.PERSON.ordinal()));

		long rawDate = cursor.getLong(TanitaDataTable.Column.DATE.ordinal());
		td.setDate(new Date(rawDate));
		return td;
	}

	@Override
	protected List<String> getAllColumns() {
		List<String> columns = new ArrayList<String>();
		columns.add(TanitaDataTable.Column.ID.toString());
		columns.add(TanitaDataTable.Column.PERSON.toString());
		columns.add(TanitaDataTable.Column.DATE.toString());
		return columns;
	}
}

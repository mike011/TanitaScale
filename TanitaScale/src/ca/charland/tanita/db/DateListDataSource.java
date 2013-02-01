package ca.charland.tanita.db;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import ca.charland.db.Data;
import ca.charland.db.DataSource;
import ca.charland.db.DatabaseConnection;

/**
 * Gets all the entries for a person.
 * 
 * @author mcharland
 */
public class DateListDataSource extends DataSource {

	public DateListDataSource(Context context) {
		super(new DatabaseConnection(context, TanitaDatabaseConnection.DATABASE_NAME, TanitaDataTable.TABLE_NAME, TanitaDataTable.CREATE_DATABASE_TABLE));
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
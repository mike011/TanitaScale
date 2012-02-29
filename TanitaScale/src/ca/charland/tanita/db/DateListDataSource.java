package ca.charland.tanita.db;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;

/**
 * The Class DateListDataSource which gets all the entries for a person.
 * 
 * @author mcharland
 */
public class DateListDataSource extends AbstractDataSource {

	/**
	 * Instantiates a new people list data source.
	 * 
	 * @param context
	 *            the context
	 */
	public DateListDataSource(Context context) {
		super(context, TanitaDataTable.NAME);
	}

	/** {@inheritDoc} */
	@Override
	protected AbstractData convertToAbstractData(Cursor cursor) {
		TanitaData td = new TanitaData();
		td.setId(cursor.getInt(TanitaDataTable.Column.ID.ordinal()));
		td.setPerson(cursor.getInt(TanitaDataTable.Column.PERSON.ordinal()));

		long rawDate = cursor.getLong(TanitaDataTable.Column.DATE.ordinal());
		td.setDate(new Date(rawDate));
		return td;
	}

	/** {@inheritDoc} */
	@Override
	protected List<String> getAllColumns() {
		List<String> columns = new ArrayList<String>();
		columns.add(TanitaDataTable.Column.ID.toString());
		columns.add(TanitaDataTable.Column.PERSON.toString());
		columns.add(TanitaDataTable.Column.DATE.toString());
		return columns;
	}
}
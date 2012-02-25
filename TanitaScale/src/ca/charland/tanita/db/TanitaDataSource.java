package ca.charland.tanita.db;

import java.sql.Date;

import android.content.Context;
import android.database.Cursor;

/**
 * The Class Tanita Data Source.
 * 
 * @author mcharland
 */
public class TanitaDataSource extends AbstractDataSource {

	/**
	 * Instantiates a new Tanita data source.
	 * 
	 * @param context
	 *            the context
	 */
	public TanitaDataSource(Context context) {
		super(context, TanitaDataTable.NAME);
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaData cursorConverter(Cursor cursor) {
		TanitaData td = new TanitaData();
		td.setId(cursor.getLong(TanitaDataTable.Column.ID.ordinal()));
		td.setPerson(cursor.getLong(TanitaDataTable.Column.PERSON.ordinal()));

		long rawDate = cursor.getLong(TanitaDataTable.Column.DATE.ordinal());
		td.setDate(new Date(rawDate));

		td.setWeight(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.WEIGHT.ordinal())));

		return td;
	}

	/** {@inheritDoc} */
	@Override
	protected String[] getAllColumns() {
		String[] allColumns = { TanitaDataTable.Column.ID.toString(), TanitaDataTable.Column.PERSON.toString(),
				TanitaDataTable.Column.DATE.toString(), TanitaDataTable.Column.WEIGHT.toString() };
		return allColumns;
	}

}

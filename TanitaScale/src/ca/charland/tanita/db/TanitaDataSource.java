package ca.charland.tanita.db;

import java.sql.Date;

import android.content.Context;
import android.database.Cursor;

/**
 * The Class TanitaDataSource.
 * 
 * @author mcharland
 */
public class TanitaDataSource extends AbstractDataSource {

	/**
	 * Instantiates a new Tanita dawta source.
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
		td.setId(cursor.getLong(0));
		td.setPerson(cursor.getLong(1));
		long rawDate = cursor.getLong(2);
		td.setDate(new Date(rawDate));
		return td;
	}

	/** {@inheritDoc} */
	@Override
	protected String[] getAllColumns() {
		String[] allColumns = { TanitaDataTable.COLUMN_ID, TanitaDataTable.COLUMN_PERSON, TanitaDataTable.COLUMN_DATE };
		return allColumns;
	}

}

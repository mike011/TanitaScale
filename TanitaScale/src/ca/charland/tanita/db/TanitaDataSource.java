package ca.charland.tanita.db;

import android.content.Context;
import android.database.Cursor;

/**
 * The Class TanitaDataSource.
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
	protected AbstractData cursorConverter(Cursor cursor) {
		return null;
	}

	/** {@inheritDoc} */
	@Override
	protected String[] getAllColumns() {
		String[] allColumns = { TanitaDataTable.COLUMN_ID, TanitaDataTable.COLUMN_DATE };
		return allColumns;
	}

}

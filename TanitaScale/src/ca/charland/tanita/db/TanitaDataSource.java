package ca.charland.tanita.db;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
	protected List<String> getAllColumns() {
		List<String> allColumns = new ArrayList<String>();
		allColumns.add(TanitaDataTable.Column.ID.toString());
		allColumns.add(TanitaDataTable.Column.PERSON.toString());
		allColumns.add(TanitaDataTable.Column.DATE.toString());
		allColumns.add(TanitaDataTable.Column.WEIGHT.toString());
		return allColumns;
	}

}

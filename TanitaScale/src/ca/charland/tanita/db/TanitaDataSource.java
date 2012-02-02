package ca.charland.tanita.db;

import android.content.Context;
import android.database.Cursor;

/**
 * The Class TanitaDataSource.
 * 
 * @author mcharland
 */
public class TanitaDataSource extends AbstractDataSource {

	public TanitaDataSource(Context context) {
		super(context, TanitaDataTable.NAME);
	}

	@Override
	protected AbstractData cursorConverter(Cursor cursor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getAllColumns() {
		// TODO Auto-generated method stub
		return null;
	}

}

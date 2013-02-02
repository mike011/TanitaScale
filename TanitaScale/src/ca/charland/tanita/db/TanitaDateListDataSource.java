package ca.charland.tanita.db;

import android.content.Context;
import ca.charland.db.DatabaseConnection;
import ca.charland.db.DateListDataSource;

/**
 * Gets all the entries for a person.
 * 
 * @author mcharland
 */
public class TanitaDateListDataSource extends DateListDataSource {

	public TanitaDateListDataSource(Context context) {
		super(new DatabaseConnection(context, TanitaDatabaseConnection.DATABASE_NAME, TanitaDataTable.TABLE_NAME, TanitaDataTable.CREATE_DATABASE_TABLE));
	}

	@Override
	protected TanitaData getData() {
		return new TanitaData();
	}
}
package ca.charland.tanita.db;

import android.content.Context;
import ca.charland.db.DatabaseConnection;

public class TanitaDatabaseConnection extends DatabaseConnection {

	public static final String DATABASE_NAME = "tanita.db";
	
	public TanitaDatabaseConnection(Context context) {
		super(context, DATABASE_NAME, TanitaDataTable.TABLE_NAME, TanitaDataTable.CREATE_DATABASE_TABLE);
	}

}

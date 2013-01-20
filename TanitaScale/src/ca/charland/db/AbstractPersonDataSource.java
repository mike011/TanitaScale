package ca.charland.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;

public abstract class AbstractPersonDataSource extends DataSource {
	
	protected final List<ContentValuesKeyValuePair> pairs;
	
	public AbstractPersonDataSource(Context context, String database, String table, String createTableSQL) {
		super(new DatabaseHelper(context, database, table, createTableSQL));
		pairs = new ArrayList<ContentValuesKeyValuePair>();
	}

	public final long create() {
		return insertTableRow(getContentValues());
	}

	protected ContentValues getContentValues() {
		ContentValues values = new ContentValues();		
		for(ContentValuesKeyValuePair pair : pairs) {
			values.put(pair.getKey(), pair.getValue());
		}
		return values;
	}
	
	public abstract void populateContentValuesKeyValuePairs(String... values);

}

package ca.charland.db;

import java.util.List;

import android.content.Context;
import android.database.Cursor;

public class BasicPersonDataSource extends DataSource {

	public BasicPersonDataSource(Context context, String createPeopleTable, String table) {
		super(context, createPeopleTable, table);
	}

	@Override
	protected Data convertToAbstractData(Cursor cursor) {
		return null;
	}

	@Override
	protected List<String> getAllColumns() {
		return null;
	}

}

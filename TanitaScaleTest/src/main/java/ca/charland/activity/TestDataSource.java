package ca.charland.activity;

import java.util.List;

import android.database.Cursor;
import ca.charland.db.Data;
import ca.charland.db.DataSource;

public class TestDataSource extends DataSource {

	public TestDataSource() {
		super(null);
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

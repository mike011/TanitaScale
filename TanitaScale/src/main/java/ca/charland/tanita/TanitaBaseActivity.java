package ca.charland.tanita;

import android.content.Context;
import ca.charland.activity.BaseActivity;
import ca.charland.activity.NextButtonOnClickListener;
import ca.charland.db.DataSource;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDatabaseConnection;

public abstract class TanitaBaseActivity extends BaseActivity {

	@Override
	protected DataSource getDataSource() {
		return getTanitaDataSource(this);
	}

	static DataSource getTanitaDataSource(Context context) {
		TanitaDataSource datasource = new TanitaDataSource(new TanitaDatabaseConnection(context));
		datasource.openDatabaseConnection();
		datasource.checkForTable();
		return datasource;
	}
	
	@Override
	protected NextButtonOnClickListener getNextButtonOnClickListener() {
		return new TanitaNextButtonOnClickListener(this, datasource);
	}
}

package ca.charland.tanita;

import android.content.Context;
import ca.charland.tanita.base.activity.BaseActivity;
import ca.charland.tanita.base.activity.NextButtonOnClickListener;
import ca.charland.tanita.base.db.DataSource;
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

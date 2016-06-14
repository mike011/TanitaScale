package ca.charland.tanita;

import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import ca.charland.tanita.base.activity.BaseActivity;
import ca.charland.tanita.base.activity.NextButtonOnKeyListener;
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
	protected OnClickListener getNextButtonOnClickListener() {
		return new TanitaNextButtonOnClickListener(this, datasource);
	}
	
	@Override
	protected OnKeyListener getNextButtonOnKeyListener() {
		return new NextButtonOnKeyListener(this, datasource);
	}
}

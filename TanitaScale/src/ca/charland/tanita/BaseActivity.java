package ca.charland.tanita;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.ContentValues;
import android.os.Bundle;
import android.widget.Button;
import ca.charland.R;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDatabaseConnection;

/**
 * @author mcharland
 */
public abstract class BaseActivity extends RoboActivity {

	@InjectView(R.id.next)
	private Button next;
	
	protected TanitaDataSource datasource;
	
	protected abstract int getResourceIDForLayout();
	protected abstract ContentValues getValues();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getResourceIDForLayout());
		datasource = getDataSource();
		next.setOnClickListener(new NextButtonOnClickListener(this, datasource));
	}

	protected TanitaDataSource getDataSource() {
		TanitaDataSource datasource = new TanitaDataSource(new TanitaDatabaseConnection(this));
		datasource.openDatabaseConnection();
		datasource.checkForTable();
		return datasource;
	}

	protected abstract Class<?> getNextClass();
	
	@Override
	protected void onResume() {
		datasource.openDatabaseConnection();
		super.onResume();
	}

	@Override
	protected void onPause() {
		datasource.closeDatabaseConnection();
		super.onPause();
	}
}

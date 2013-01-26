package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataSource;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.ContentValues;
import android.os.Bundle;
import android.widget.Button;

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
		createDataSource();
		next.setOnClickListener(new NextButtonOnClickListener(this, datasource));
	}

	protected void createDataSource() {
		datasource = new TanitaDataSource(this);
		datasource.openDatabaseConnection();
		datasource.checkForTable();
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

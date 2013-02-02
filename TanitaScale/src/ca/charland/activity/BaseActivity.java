package ca.charland.activity;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.ContentValues;
import android.os.Bundle;
import android.widget.Button;
import ca.charland.R;
import ca.charland.db.DataSource;

/**
 * @author mcharland
 */
public abstract class BaseActivity extends RoboActivity {

	@InjectView(R.id.next)
	private Button next;
	
	protected DataSource datasource;
	
	protected abstract int getResourceIDForLayout();
	protected abstract ContentValues getValues();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getResourceIDForLayout());
		datasource = getDataSource();
		next.setOnClickListener(getNextButtonOnClickListener());
	}
	
	protected abstract NextButtonOnClickListener getNextButtonOnClickListener();

	protected abstract DataSource getDataSource();

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

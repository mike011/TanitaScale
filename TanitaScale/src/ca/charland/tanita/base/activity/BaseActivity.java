package ca.charland.tanita.base.activity;

import roboguice.activity.RoboActivity;
import android.content.ContentValues;
import android.os.Bundle;
import android.widget.Button;
import ca.charland.tanita.R;
import ca.charland.tanita.base.db.DataSource;

/**
 * @author mcharland
 */
public abstract class BaseActivity extends RoboActivity {

	/*
	 * This cannot be injected because of a limitation in robo guice not allowing injection from an abstract class.
	 */
	private Button next;
	
	protected DataSource datasource;
	
	protected abstract int getResourceIDForLayout();
	protected abstract ContentValues getValues();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getResourceIDForLayout());
		next = (Button) findViewById(R.id.next);
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

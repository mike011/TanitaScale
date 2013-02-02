package ca.charland.activity.manage;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import ca.charland.R;
import ca.charland.db.BasicPersonDataSource;

/**
 * Allows you to add a new person with an email and there sex.
 * 
 * @author mcharland
 */
public abstract class AddANewPersonActivity extends RoboActivity {

	protected BasicPersonDataSource datasource;

	@InjectView(R.id.name)
	protected EditText name;

	@InjectView(R.id.save)
	protected Button save;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.add);
		datasource = getDataSource();
		datasource.openDatabaseConnection();

		save.setOnClickListener(new SaveOnClickListener());
	}

	protected abstract BasicPersonDataSource getDataSource();
	
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

	private final class SaveOnClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			handleSaveOnClick();
		}
	}
	
	protected abstract void handleSaveOnClick();
}
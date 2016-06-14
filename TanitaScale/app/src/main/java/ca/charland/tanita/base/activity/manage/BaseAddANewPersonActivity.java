package ca.charland.tanita.base.activity.manage;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import ca.charland.tanita.R;
import ca.charland.tanita.base.db.BasicPersonDataSource;

/**
 * Allows you to add a new person with an email and there sex.
 * 
 * @author mcharland
 */
public class BaseAddANewPersonActivity extends RoboActivity {

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

	protected BasicPersonDataSource getDataSource() {
		return new BasicPersonDataSource(this);
	}
	
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
	
	protected void handleSaveOnClick() {
		int messageResourceID = R.string.valid_name;
		if (isContentValid() ) {
			messageResourceID = R.string.generic_error_message;
		} else {
			saveContent();
			clearFields();
		}
		Toast.makeText(getBaseContext(), getMessageString(messageResourceID), Toast.LENGTH_SHORT).show();
	}

	protected void saveContent() {
		datasource.add(getNameString());
	}

	protected boolean isContentValid() {
		return getNameString().length() == 0;
	}
	
	protected String getNameString() {
		return name.getText().toString();
	}
	
	private String getMessageString(int message) {
		return getResources().getString(message);
	}
	
	protected void clearFields() {
		name.setText("");
	}
}
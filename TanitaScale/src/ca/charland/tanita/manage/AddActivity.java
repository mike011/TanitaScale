package ca.charland.tanita.manage;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import ca.charland.tanita.R;
import ca.charland.tanita.db.PersonDataSource;

/**
 * Allows you to add a new person with an email and there sex.
 * 
 * @author mcharland
 */
public class AddActivity extends RoboActivity {

	private final class SaveOnClickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			handleOnClick();
		}
	}

	private PersonDataSource datasource;

	@InjectView(R.id.name)
	private EditText name;
	
	@InjectView(R.id.email)
	private EditText email;
	
	@InjectView(R.id.sex)
	private RadioGroup sex;

	@InjectView(R.id.save)
	private Button save;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.add);
		datasource = new PersonDataSource(this);
		datasource.openDatabaseConnection();

		save.setOnClickListener(new SaveOnClickListener());
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
	
	private void handleOnClick() {
		String nameString = name.getText().toString();
		int messageResourceID = R.string.valid_name;
		if (nameString.length() == 0 || sex.getCheckedRadioButtonId() == -1) {
			messageResourceID = R.string.generic_error_message;
		} else {
			datasource.create(nameString, getEmail(), getSex());
			clearFields();
		}
		Toast.makeText(getBaseContext(), getMessageString(messageResourceID), Toast.LENGTH_SHORT).show();
	}

	private String getMessageString(int message) {
		return getResources().getString(message);
	}

	private String getEmail() {
		return email.getText().toString();
	}

	private String getSex() {
		// Returns an integer which represents the selected radio button's ID
		int selected = sex.getCheckedRadioButtonId();
		 
		// Gets a reference to our "selected" radio button
		RadioButton b = (RadioButton) findViewById(selected);
		 
		// Now you can get the text or whatever you want from the "selected" radio button
		return b.getText().toString();
	}
	
	private void clearFields() {
		name.setText("");
		email.setText("");
		sex.clearCheck();
	}
}
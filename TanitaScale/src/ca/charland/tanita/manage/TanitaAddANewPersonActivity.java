package ca.charland.tanita.manage;

import roboguice.inject.InjectView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import ca.charland.R;
import ca.charland.activity.manage.AddANewPersonActivity;
import ca.charland.db.BasicPersonDataSource;
import ca.charland.tanita.db.PersonDataSource;

public class TanitaAddANewPersonActivity extends AddANewPersonActivity {

	@InjectView(R.id.email)
	private EditText email;

	@InjectView(R.id.sex)
	private RadioGroup sex;

	
	@Override
	protected BasicPersonDataSource getDataSource() {
		return new PersonDataSource(this);
	}
	
	@Override
	protected void handleSaveOnClick() {
		String nameString = name.getText().toString();
		int messageResourceID = R.string.valid_name;
		if (nameString.length() == 0 || sex.getCheckedRadioButtonId() == -1) {
			messageResourceID = R.string.generic_error_message;
		} else {
			PersonDataSource pds = (PersonDataSource)datasource;
			pds.create(nameString, getEmail(), getSex());
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
package ca.charland.tanita.manage;

import roboguice.inject.InjectView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import ca.charland.tanita.R;
import ca.charland.tanita.base.activity.manage.BaseAddANewPersonActivity;
import ca.charland.tanita.base.db.BasicPersonDataSource;
import ca.charland.tanita.db.PersonDataSource;

public class AddANewPersonActivity extends BaseAddANewPersonActivity {

	@InjectView(R.id.email)
	private EditText email;

	@InjectView(R.id.sex)
	private RadioGroup sex;
	
	@Override
	protected BasicPersonDataSource getDataSource() {
		return new PersonDataSource(this);
	}
	
	protected void saveContent() {
		PersonDataSource pds = (PersonDataSource)datasource;
		pds.create(getNameString(), getEmail(), getSex());
		clearFields();
	}

	protected boolean isContentValid() {
		return super.isContentValid() ||  sex.getCheckedRadioButtonId() == -1;
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

	@Override
	protected void clearFields() {
		super.clearFields();
		email.setText("");
		sex.clearCheck();
	}
}
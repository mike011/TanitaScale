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
 * The Class AddActivity which allows you to add a new person with an email and there sex.
 * 
 * @author mcharland
 */
public class AddActivity extends RoboActivity {

	/** The database source. */
	private PersonDataSource datasource;

	/** The name text field. */
	@InjectView(R.id.name)
	private EditText name;
	
	/** The email text field. */
	@InjectView(R.id.email)
	private EditText email;
	
	@InjectView(R.id.sex)
	private RadioGroup sex;

	/** The save button. */
	@InjectView(R.id.save)
	private Button save;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.add);
		datasource = new PersonDataSource(this);
		datasource.open();

		save.setOnClickListener(new View.OnClickListener() {
			
			/** {@inheritDoc} */
			@Override
			public void onClick(View v) {

				String nameString = name.getText().toString();
				int message = R.string.valid_name;
				if (nameString.length() == 0 || sex.getCheckedRadioButtonId() == -1) {
					message = R.string.generic_error_message;
				} else {
					datasource.create(nameString, email.getText().toString(), getSex());
					name.setText("");
					email.setText("");
					sex.clearCheck();
				}
				Toast.makeText(getBaseContext(), getResources().getString(message), Toast.LENGTH_SHORT).show();
			}

			private String getSex() {
				// Returns an integer which represents the selected radio button's ID
				int selected = sex.getCheckedRadioButtonId();
				 
				// Gets a reference to our "selected" radio button
				RadioButton b = (RadioButton) findViewById(selected);
				 
				// Now you can get the text or whatever you want from the "selected" radio button
				return b.getText().toString();
			}
		});
	}

	/** {@inheritDoc} */
	@Override
	protected void onResume() {
		datasource.open();
		super.onResume();
	}

	/** {@inheritDoc} */
	@Override
	protected void onPause() {
		datasource.close();
		super.onPause();
	}
}
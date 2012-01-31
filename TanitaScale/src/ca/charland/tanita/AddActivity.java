package ca.charland.tanita;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import ca.charland.tanita.db.PersonDataSource;

/**
 * The Class AddActivity which allows you to add a new person.
 * 
 * @author mcharland
 */
@ContentView(R.layout.add)
public class AddActivity extends RoboActivity {

	/** The database source. */
	private PersonDataSource datasource;

	/** The text field. */
	@InjectView(R.id.name)
	private EditText name;

	/** The save button. */
	@InjectView(R.id.save)
	private Button save;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		datasource = new PersonDataSource(this);
		datasource.open();

		save.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				datasource.createPerson(name.getText().toString());
				name.setText("");
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
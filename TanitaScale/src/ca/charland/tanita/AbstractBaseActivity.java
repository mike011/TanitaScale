package ca.charland.tanita;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.manage.PeopleListActivity;

/**
 * The Class AbstractBaseActivity which holds the next button so all the classes don't have to repeat it and allows for entry of your number.
 * 
 * @author mcharland
 */
public abstract class AbstractBaseActivity extends RoboActivity {

	/** The Constant ID. */
	private static final String ID = "ROW_ID";
	
	/** The database source. */
	private TanitaDataSource datasource;

	/** The next button. */
	@InjectView(R.id.next)
	private Button next;

	/**
	 * Gets the layout res id.
	 *
	 * @return the layout res id
	 */
	abstract int getLayoutResID();
	
	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(getLayoutResID());
		datasource = new TanitaDataSource(this);
		datasource.open();

		next.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				ContentValues values = getValues();

				Bundle bundle = getIntent().getExtras();
				long person = bundle.getLong(PeopleListActivity.PERSON);
				values.put(TanitaDataTable.COLUMN_PERSON, person);
				long id = datasource.insert(values);
				
				Intent intent = new Intent(getBaseContext(), getNextClass());
				
				Bundle extras = getIntent().getExtras();
				intent.putExtra(PeopleListActivity.PERSON, extras.getLong(PeopleListActivity.PERSON));
				
				intent.putExtra(ID, id);
				
				startActivity(intent);
			}
		});
	}

	/**
	 * Gets the values to insert into the db.
	 * 
	 * @return The values to insert.
	 */
	protected abstract ContentValues getValues();

	/**
	 * Gets the next class.
	 * 
	 * @return the next class
	 */
	protected abstract Class<?> getNextClass();

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

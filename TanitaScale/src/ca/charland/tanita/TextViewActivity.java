package ca.charland.tanita;

import java.util.List;

import roboguice.inject.InjectView;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import ca.charland.tanita.db.Data;
import ca.charland.tanita.db.PersonData;
import ca.charland.tanita.db.PersonDataSource;
import ca.charland.tanita.db.PersonDataTable;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.manage.PeopleListActivity;

/**
 * Since most of the classes have a text view when entering data a specific class was created.
 * 
 * @author mcharland
 * 
 */
public abstract class TextViewActivity extends BaseActivity {

	/*
	 * This cannot be injected because of a limitation in robo guice not allowing injection from an abstract base class.
	 */
	private TextView text;

	@InjectView(R.id.enter_your)
	private TextView enter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		text = (TextView) findViewById(R.id.editTextEntry);

		String raw = getResources().getString(R.string.enterYour);
		enter.setText(String.format(raw, getResources().getString(getIDForString())));
	}

	@Override
	public void onStart() {
		super.onStart();
		showKeyboard();
	}
	
	private void showKeyboard() {
		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,InputMethodManager.HIDE_NOT_ALWAYS);
	}
	
	protected abstract int getIDForString();

	protected abstract TanitaDataTable.Column getColumnName();

	@Override
	protected final ContentValues getValues() {
		ContentValues values = new ContentValues();
		values.put(getColumnName().toString(), text.getText().toString());
		return values;
	}
	
	protected void setSex(int id, int female) {
		ImageView image = (ImageView) findViewById(id);
		
		String sex = getSex();
		if(sex.equalsIgnoreCase("female")) {
			Bitmap newImage = BitmapFactory.decodeResource(getResources(), female);
			image.setImageBitmap(newImage);
		}
	}
	
	private String getSex() {
		PersonDataSource datasource = new PersonDataSource(this);
		datasource.openDatabaseConnection();
		List<Data> data = datasource.query(getSelection());
		PersonData pd = (PersonData) data.get(0);
		String sex = pd.getSex();
		datasource.closeDatabaseConnection();
		return sex;
	}

	private String getSelection() {
		return PersonDataTable.Column.ID.toString() + " = " + getPersonID();
	}

	private int getPersonID() {
		int person = 0;
		Intent intent = getIntent();
		if (intent != null) {
			// Don't know how inject extras in testing.
			Bundle extras = intent.getExtras();
			person = extras.getInt(PeopleListActivity.PERSON_ID.toString());
		}
		return person;
	}
}

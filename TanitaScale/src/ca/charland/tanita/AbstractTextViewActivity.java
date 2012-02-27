package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;
import android.content.ContentValues;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Since most of the classes have a text view when entering data a specific class was created.
 * 
 * @author mcharland
 * 
 */
public abstract class AbstractTextViewActivity extends AbstractBaseActivity {

	/** The text. This cannot be injected because of a limitation in robo guice not allowing injection from an abstract base class. */
	private TextView text;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		text = (TextView) findViewById(R.id.editTextEntry);
	}

	/**
	 * Gets the column name for the table used by the class.
	 * 
	 * @return The column name for the table used by the class.
	 */
	protected abstract TanitaDataTable.Column getColumnName();

	/** {@inheritDoc} */
	@Override
	protected final ContentValues getValues() {
		ContentValues values = new ContentValues();
		values.put(getColumnName().toString(), text.getText().toString());
		return values;
	}
}

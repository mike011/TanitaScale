package ca.charland.tanita;

import roboguice.inject.InjectView;
import ca.charland.tanita.db.TanitaDataTable;
import android.content.ContentValues;
import android.widget.TextView;

/**
 * The Class DCIActivity.
 * 
 * @author mcharland
 */
public class DCIActivity extends AbstractBaseActivity {

	/** The weight. */
	@InjectView(R.id.editTextEntry)
	private TextView dci;
	
	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.dci;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MetabolicAgeActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		ContentValues values = new ContentValues();
		String string = dci.getText().toString();
		values.put(TanitaDataTable.Column.DAILY_CALORIC_INTAKE.toString(), string);
		return values;
	}
}

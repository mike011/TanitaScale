package ca.charland.tanita;

import roboguice.inject.InjectView;
import android.content.ContentValues;
import android.widget.TextView;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class WeightActivity.
 * 
 * @author mcharland
 */
public class WeightActivity extends AbstractBaseActivity {

	/** The weight. */
	@InjectView(R.id.editTextEntry)
	private TextView weight;

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.weight;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return DCIActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		ContentValues values = new ContentValues();
		String string = weight.getText().toString();
		values.put(TanitaDataTable.Column.WEIGHT.toString(), string);
		return values;
	}
}

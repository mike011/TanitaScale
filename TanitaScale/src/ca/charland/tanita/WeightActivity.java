package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class WeightActivity.
 * 
 * @author mcharland
 */
public class WeightActivity extends AbstractTextViewActivity {

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
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.WEIGHT;
	}
}

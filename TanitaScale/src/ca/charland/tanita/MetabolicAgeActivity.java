package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class MetabolicAgeActivity.
 * 
 * @author mcharland
 */
public class MetabolicAgeActivity extends AbstractTextViewActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.metabolic_age;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyWaterPercentageActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.METABOLIC_AGE;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.metabolic_age;
	}
}

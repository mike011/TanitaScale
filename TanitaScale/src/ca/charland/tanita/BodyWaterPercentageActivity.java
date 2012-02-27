package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class BodyWaterPercentageActivity.
 * 
 * @author mcharland
 */
public class BodyWaterPercentageActivity extends AbstractTextViewActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.body_water_percentage;
	}
	
	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return VisceralFatActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BODY_WATER_PERCENTAGE;
	}
}

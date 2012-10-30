package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class BodyFatTotalActivity.
 * 
 * @author mcharland
 */
public class BodyFatTotalActivity extends BodyFatBaseActivity {
	
	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.body_fat_total;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyFatLeftArmActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BODY_FAT_TOTAL;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.body_fat_total;
	}
}

package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class BodyFatTrunkActivity.
 * 
 * @author mcharland
 */
public class BodyFatTrunkActivity extends TextViewActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.body_fat_trunk;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MuscleMassTotalActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BODY_FAT_TRUNK;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.body_fat_trunk;
	}
}

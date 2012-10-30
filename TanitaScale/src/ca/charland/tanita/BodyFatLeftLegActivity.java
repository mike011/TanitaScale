package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class BodyFatLeftLegActivity.
 * 
 * @author mcharland
 */
public class BodyFatLeftLegActivity extends BodyFatBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.body_fat_left_leg;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyFatTrunkActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BODY_FAT_LEFT_LEG;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.body_fat_leg_left;
	}
}

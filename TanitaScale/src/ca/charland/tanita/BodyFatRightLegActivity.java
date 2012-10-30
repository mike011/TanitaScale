package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class BodyFatRightLegActivity.
 * 
 * @author mcharland
 */
public class BodyFatRightLegActivity extends BodyFatBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.body_fat_right_leg;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyFatLeftLegActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BODY_FAT_RIGHT_LEG;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.body_fat_leg_right;
	}
}

package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class BodyFatRightArmActivity.
 * 
 * @author mcharland
 */
public class BodyFatRightArmActivity extends BodyFatBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.body_fat_right_arm;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyFatRightLegActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BODY_FAT_RIGHT_ARM;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.body_fat_arm_right;
	}
}

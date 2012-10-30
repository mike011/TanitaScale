package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class BodyFatLeftArmActivity.
 * 
 * @author mcharland
 */
public class BodyFatLeftArmActivity extends BodyFatBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.body_fat_left_arm;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyFatRightArmActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BODY_FAT_LEFT_ARM;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.body_fat_arm_left;
	}
}

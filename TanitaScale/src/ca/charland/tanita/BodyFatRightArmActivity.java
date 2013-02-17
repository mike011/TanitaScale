package ca.charland.tanita;

import ca.charland.tanita.R;
import ca.charland.tanita.db.TanitaDataTable;
/**
 * @author mcharland
 */
public class BodyFatRightArmActivity extends BodyFatBaseActivity {

	@Override
	protected int getResourceIDForLayout() {
		return R.layout.body_fat_right_arm;
	}

	@Override
	public Class<?> getNextClass() {
		return BodyFatRightLegActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BODY_FAT_RIGHT_ARM;
	}

	@Override
	protected int getIDForString() {
		return R.string.body_fat_arm_right;
	}
}

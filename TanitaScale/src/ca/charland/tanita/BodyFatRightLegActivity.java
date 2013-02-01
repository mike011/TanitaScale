package ca.charland.tanita;

import ca.charland.R;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
public class BodyFatRightLegActivity extends BodyFatBaseActivity {

	@Override
	protected int getResourceIDForLayout() {
		return R.layout.body_fat_right_leg;
	}

	@Override
	public Class<?> getNextClass() {
		return BodyFatLeftLegActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BODY_FAT_RIGHT_LEG;
	}

	@Override
	protected int getIDForString() {
		return R.string.body_fat_leg_right;
	}
}

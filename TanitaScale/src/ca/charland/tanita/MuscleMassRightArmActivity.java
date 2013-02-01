package ca.charland.tanita;

import ca.charland.R;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
public class MuscleMassRightArmActivity extends TextViewActivity {

	@Override
	protected int getResourceIDForLayout() {
		return R.layout.muscle_mass_right_arm;
	}

	@Override
	public Class<?> getNextClass() {
		return MuscleMassRightLegActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.MUSCLE_MASS_RIGHT_ARM;
	}

	@Override
	protected int getIDForString() {
		return R.string.muscle_mass_arm_right;
	}
}

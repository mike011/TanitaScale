package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
public class MuscleMassLeftArmActivity extends TextViewActivity {

	@Override
	protected int getResourceIDForLayout() {
		return R.layout.muscle_mass_left_arm;
	}

	@Override
	public Class<?> getNextClass() {
		return MuscleMassRightArmActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.MUSCLE_MASS_LEFT_ARM;
	}

	@Override
	protected int getIDForString() {
		return R.string.muscle_mass_arm_left;
	}
}

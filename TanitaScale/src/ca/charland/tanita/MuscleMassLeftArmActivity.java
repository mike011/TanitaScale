package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class MuscleMassLeftArmActivity.
 * 
 * @author mcharland
 */
public class MuscleMassLeftArmActivity extends AbstractTextViewActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.muscle_mass_left_arm;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MuscleMassRightArmActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.MUSCLE_MASS_LEFT_ARM;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.muscle_mass_arm_left;
	}
}

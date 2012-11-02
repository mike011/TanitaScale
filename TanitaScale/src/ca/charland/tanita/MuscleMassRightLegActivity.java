package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class MuscleMassRightLegActivity.
 * 
 * @author mcharland
 */
public class MuscleMassRightLegActivity extends TextViewActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.muscle_mass_right_leg;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MuscleMassLeftLegActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.MUSCLE_MASS_RIGHT_LEG;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.muscle_mass_leg_right;
	}
}

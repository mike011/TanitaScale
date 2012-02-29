package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class MuscleMassLeftLegActivity.
 * 
 * @author mcharland
 */
public class MuscleMassLeftLegActivity extends AbstractTextViewActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.muscle_mass_left_leg;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return MuscleMassTrunkActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.MUSCLE_MASS_LEFT_LEG;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.muscle_mass_leg_left;
	}
}

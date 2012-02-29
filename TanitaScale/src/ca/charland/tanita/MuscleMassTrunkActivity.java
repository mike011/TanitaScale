package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class MuscleMassTrunkActivity.
 * 
 * @author mcharland
 */
public class MuscleMassTrunkActivity extends AbstractTextViewActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.muscle_mass_trunk;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return PhysicRatingActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.MUSCLE_MASS_TRUNK;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.muscle_mass_trunk;
	}
}

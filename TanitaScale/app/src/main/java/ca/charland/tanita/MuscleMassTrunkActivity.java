package ca.charland.tanita;

import ca.charland.tanita.R;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
public class MuscleMassTrunkActivity extends TextViewActivity {

	@Override
	protected int getResourceIDForLayout() {
		return R.layout.muscle_mass_trunk;
	}

	@Override
	public Class<?> getNextClass() {
		return PhysicRatingActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.MUSCLE_MASS_TRUNK;
	}

	@Override
	protected int getIDForString() {
		return R.string.muscle_mass_trunk;
	}
}

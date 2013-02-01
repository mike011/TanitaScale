package ca.charland.tanita;

import ca.charland.R;
import ca.charland.tanita.db.TanitaDataTable;
/**
 * @author mcharland
 */
public class MuscleMassLeftLegActivity extends TextViewActivity {

	@Override
	protected int getResourceIDForLayout() {
		return R.layout.muscle_mass_left_leg;
	}

	@Override
	public Class<?> getNextClass() {
		return MuscleMassTrunkActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.MUSCLE_MASS_LEFT_LEG;
	}

	@Override
	protected int getIDForString() {
		return R.string.muscle_mass_leg_left;
	}
}

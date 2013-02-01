package ca.charland.tanita;

import ca.charland.R;
import ca.charland.tanita.db.TanitaDataTable;
/**
 * @author mcharland
 */
public class MuscleMassRightLegActivity extends TextViewActivity {

	@Override
	protected int getResourceIDForLayout() {
		return R.layout.muscle_mass_right_leg;
	}

	@Override
	public Class<?> getNextClass() {
		return MuscleMassLeftLegActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.MUSCLE_MASS_RIGHT_LEG;
	}

	@Override
	protected int getIDForString() {
		return R.string.muscle_mass_leg_right;
	}
}

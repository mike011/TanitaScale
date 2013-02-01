package ca.charland.tanita;

import ca.charland.R;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
public class MuscleMassTotalActivity extends TextViewActivity {

	@Override
	protected int getResourceIDForLayout() {
		return R.layout.muscle_mass_total;
	}

	@Override
	public Class<?> getNextClass() {
		return MuscleMassLeftArmActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.MUSCLE_MASS_TOTAL;
	}

	@Override
	protected int getIDForString() {
		return R.string.muscle_mass_total;
	}
}

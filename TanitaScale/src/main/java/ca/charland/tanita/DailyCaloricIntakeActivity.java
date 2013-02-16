package ca.charland.tanita;

import ca.charland.tanita.R;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
public class DailyCaloricIntakeActivity extends TextViewActivity {

	@Override
	protected int getResourceIDForLayout() {
		return R.layout.dci;
	}

	@Override
	public Class<?> getNextClass() {
		return MetabolicAgeActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.DAILY_CALORIC_INTAKE;
	}

	@Override
	protected int getIDForString() {
		return R.string.dci;
	}
}

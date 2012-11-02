package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
public class MetabolicAgeActivity extends TextViewActivity {

	@Override
	protected int getResourceIDForLayout() {
		return R.layout.metabolic_age;
	}

	@Override
	public Class<?> getNextClass() {
		return BodyWaterPercentageActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.METABOLIC_AGE;
	}

	@Override
	protected int getIDForString() {
		return R.string.metabolic_age;
	}
}

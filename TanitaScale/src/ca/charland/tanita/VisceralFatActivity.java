package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
public class VisceralFatActivity extends TextViewActivity {

	@Override
	protected int getResourceIDForLayout() {
		return R.layout.visceral_fat;
	}

	@Override
	public Class<?> getNextClass() {
		return BoneMassActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.VISCERAL_FAT;
	}

	@Override
	protected int getIDForString() {
		return R.string.visceral_fat;
	}
}

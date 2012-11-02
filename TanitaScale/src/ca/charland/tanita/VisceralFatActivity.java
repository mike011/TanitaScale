package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class VisceralFatActivity.
 * 
 * @author mcharland
 */
public class VisceralFatActivity extends TextViewActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.visceral_fat;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BoneMassActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.VISCERAL_FAT;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.visceral_fat;
	}
}

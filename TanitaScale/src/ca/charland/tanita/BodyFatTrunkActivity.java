package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
public class BodyFatTrunkActivity extends TextViewActivity {

	@Override
	protected int getResourceIDForLayout() {
		return R.layout.body_fat_trunk;
	}

	@Override
	public Class<?> getNextClass() {
		return MuscleMassTotalActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BODY_FAT_TRUNK;
	}

	@Override
	protected int getIDForString() {
		return R.string.body_fat_trunk;
	}
}

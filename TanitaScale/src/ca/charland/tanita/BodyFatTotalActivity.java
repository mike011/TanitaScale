package ca.charland.tanita;

import ca.charland.R;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
public class BodyFatTotalActivity extends BodyFatBaseActivity {
	
	@Override
	protected int getResourceIDForLayout() {
		return R.layout.body_fat_total;
	}

	@Override
	public Class<?> getNextClass() {
		return BodyFatLeftArmActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BODY_FAT_TOTAL;
	}

	@Override
	protected int getIDForString() {
		return R.string.body_fat_total;
	}
}

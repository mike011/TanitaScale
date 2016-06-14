package ca.charland.tanita;

import android.os.Bundle;
import ca.charland.tanita.R;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
public class BodyFatTrunkActivity extends TextViewActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setSex(R.id.body_fat_image, R.drawable.body_fat_female_trunk);
	}
	
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

package ca.charland.tanita;

import android.os.Bundle;
import ca.charland.tanita.R;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
public class BodyFatLeftLegActivity extends TextViewActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setSex(R.id.body_fat_image, R.drawable.body_fat_female_left_leg);
	}
	
	@Override
	protected int getResourceIDForLayout() {
		return R.layout.body_fat_left_leg;
	}

	@Override
	public Class<?> getNextClass() {
		return BodyFatTrunkActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BODY_FAT_LEFT_LEG;
	}

	@Override
	protected int getIDForString() {
		return R.string.body_fat_leg_left;
	}
}

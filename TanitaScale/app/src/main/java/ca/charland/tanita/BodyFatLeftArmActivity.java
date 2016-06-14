package ca.charland.tanita;

import android.os.Bundle;
import ca.charland.tanita.R;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
public class BodyFatLeftArmActivity extends TextViewActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setSex(R.id.body_fat_image, R.drawable.body_fat_female_left_arm);
	}
	
	@Override
	protected int getResourceIDForLayout() {
		return R.layout.body_fat_left_arm;
	}

	@Override
	public Class<?> getNextClass() {
		return BodyFatRightArmActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BODY_FAT_LEFT_ARM;
	}

	@Override
	protected int getIDForString() {
		return R.string.body_fat_arm_left;
	}
}

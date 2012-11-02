package ca.charland.tanita;

import android.os.Bundle;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
public class BoneMassActivity extends TextViewActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setSex(R.id.bone_mass_image, R.drawable.bone_mass_female);
	}
	
	@Override
	protected int getResourceIDForLayout() {
		return R.layout.bone_mass;
	}

	@Override
	public Class<?> getNextClass() {
		return BodyFatTotalActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BONE_MASS;
	}

	@Override
	protected int getIDForString() {
		return R.string.bone_mass;
	}
}

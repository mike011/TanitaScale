package ca.charland.tanita;

import android.os.Bundle;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class BoneMassActivity.
 * 
 * @author mcharland
 */
public class BoneMassActivity extends TextViewActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setSex(R.id.bone_mass_image, R.drawable.bone_mass_female);
	}
	
	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.bone_mass;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return BodyFatTotalActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BONE_MASS;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.bone_mass;
	}
}

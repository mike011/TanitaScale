package ca.charland.tanita;

import android.os.Bundle;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class BodyWaterPercentageActivity.
 * 
 * @author mcharland
 */
public class BodyWaterPercentageActivity extends TextViewActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setSex(R.id.bodywater_image, R.drawable.body_water_female);
	}
	
	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.body_water_percentage;
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return VisceralFatActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BODY_WATER_PERCENTAGE;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.body_water_percentage;
	}
}

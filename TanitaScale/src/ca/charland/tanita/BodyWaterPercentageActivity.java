package ca.charland.tanita;

import android.os.Bundle;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * @author mcharland
 */
public class BodyWaterPercentageActivity extends TextViewActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setSex(R.id.bodywater_image, R.drawable.body_water_female);
	}
	
	@Override
	protected int getResourceIDForLayout() {
		return R.layout.body_water_percentage;
	}

	@Override
	public Class<?> getNextClass() {
		return VisceralFatActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.BODY_WATER_PERCENTAGE;
	}

	@Override
	protected int getIDForString() {
		return R.string.body_water_percentage;
	}
}

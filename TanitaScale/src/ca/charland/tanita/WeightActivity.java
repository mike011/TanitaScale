package ca.charland.tanita;

import android.os.Bundle;
import ca.charland.R;
import ca.charland.tanita.db.TanitaDataTable;
/**
 * @author mcharland
 */
public class WeightActivity extends TextViewActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	protected int getResourceIDForLayout() {
		return R.layout.weight;
	}

	@Override
	public Class<?> getNextClass() {
		return DailyCaloricIntakeActivity.class;
	}

	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.WEIGHT;
	}

	@Override
	protected int getIDForString() {
		return R.string.weight;
	}
}

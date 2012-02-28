package ca.charland.tanita;

import roboguice.inject.InjectView;
import android.os.Bundle;
import android.widget.TextView;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class WeightActivity.
 * 
 * @author mcharland
 */
public class WeightActivity extends AbstractTextViewActivity {

	/** The next button. */
	@InjectView(R.id.enter_your)
	private TextView enter;
	
	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.weight;
	}

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String raw = getResources().getString(R.string.enterYour);
		enter.setText(String.format(raw, getResources().getString(R.string.weight)));
	}

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return DCIActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.WEIGHT;
	}
}

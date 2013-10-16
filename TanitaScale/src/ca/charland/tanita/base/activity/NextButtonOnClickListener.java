package ca.charland.tanita.base.activity;

import android.view.View;
import ca.charland.tanita.base.db.DataSource;

/**
 * @author mcharland
 */
public class NextButtonOnClickListener extends NextButtonListener implements View.OnClickListener {

	public NextButtonOnClickListener(BaseActivity activity, DataSource datasource) {
		super(activity, datasource);
	}

	@Override
	public void onClick(View v) {
		super.click(v);
	}
}

package ca.charland.tanita.base.activity;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import ca.charland.tanita.base.db.DataSource;

public class NextButtonOnKeyListener extends NextButtonListener implements OnKeyListener {

	public NextButtonOnKeyListener(BaseActivity activity, DataSource datasource) {
		super(activity, datasource);
	}
	
	@Override
	public boolean onKey(View v, int arg1, KeyEvent arg2) {
		return super.click(v);
	}

}

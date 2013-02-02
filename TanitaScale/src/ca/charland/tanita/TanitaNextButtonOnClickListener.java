package ca.charland.tanita;

import android.app.Activity;
import ca.charland.activity.BaseActivity;
import ca.charland.activity.NextButtonOnClickListener;
import ca.charland.db.DataSource;

public class TanitaNextButtonOnClickListener extends NextButtonOnClickListener {

	TanitaNextButtonOnClickListener(BaseActivity activity, DataSource datasource) {
		super(activity, datasource);
	}
	
	@Override
	protected boolean isLastActivity(Activity activity) {
		String name = activity.getClass().getName();
		String physic = PhysicRatingActivity.class.toString();
		return physic.contains(name);
	}
}

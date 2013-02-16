package ca.charland.tanita;

import android.app.Activity;
import android.widget.TextView;
import android.widget.Toast;
import ca.charland.tanita.R;
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

	@Override
	protected boolean isContentValid() {
		TextView findViewById = (TextView) activity.findViewById(R.id.editTextEntry);
		if (findViewById != null) {
			CharSequence string = findViewById.getText();
			if (string.length() == 0) {
				getToast().show();
				return false;
			}
		}
		return true;
	}
	
	private Toast getToast() {
		return Toast.makeText(activity.getBaseContext(), getGenericErrorMessage(), Toast.LENGTH_SHORT);
	}
	
	private String getGenericErrorMessage() {
		return activity.getResources().getString(R.string.generic_error_message);
	}
}

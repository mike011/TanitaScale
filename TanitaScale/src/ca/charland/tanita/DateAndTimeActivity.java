package ca.charland.tanita;

import android.view.View.OnClickListener;
import ca.charland.tanita.base.activity.BaseDateAndTimeActivity;
import ca.charland.tanita.base.db.DataSource;

public class DateAndTimeActivity extends BaseDateAndTimeActivity {

	@Override
	protected OnClickListener getNextButtonOnClickListener() {
		return new TanitaNextButtonOnClickListener(this, datasource);
	}

	@Override
	protected DataSource getDataSource() {
		return TanitaBaseActivity.getTanitaDataSource(this);
	}
	
	@Override
	public Class<?> getNextClass() {
		return WeightActivity.class;
	}

}

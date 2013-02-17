package ca.charland.tanita;

import ca.charland.tanita.base.activity.BaseDateAndTimeActivity;
import ca.charland.tanita.base.activity.NextButtonOnClickListener;
import ca.charland.tanita.base.db.DataSource;

public class DateAndTimeActivity extends BaseDateAndTimeActivity {

	@Override
	protected NextButtonOnClickListener getNextButtonOnClickListener() {
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

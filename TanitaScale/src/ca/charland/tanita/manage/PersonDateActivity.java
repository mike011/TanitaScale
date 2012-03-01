package ca.charland.tanita.manage;

import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.widget.TextView;
import ca.charland.tanita.R;
import ca.charland.tanita.db.AbstractData;
import ca.charland.tanita.db.TanitaData;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;

/**
 * The Class PersonDateActivity which shows the data entered for a specific date.
 * 
 * @author mcharland.
 */
public class PersonDateActivity extends RoboActivity {

	@InjectView(R.id.weight)
	private TextView weight;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.person_date);

		TanitaDataSource datasource = new TanitaDataSource(this);
		datasource.open();
		Bundle extras = getIntent().getExtras();
		String selection = TanitaDataTable.Column.ID.toString() + " = " + extras.getInt(DateListActivity.ID);

		List<AbstractData> data = datasource.query(selection);
		TanitaData td = (TanitaData) data.get(0);

		weight.setText(String.valueOf(td.getWeight()));
		datasource.close();
	}
}

package ca.charland.tanita.manage;

import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import ca.charland.tanita.DateAndTimeActivity;
import ca.charland.tanita.R;
import ca.charland.tanita.db.AbstractData;
import ca.charland.tanita.db.TanitaData;
import ca.charland.tanita.db.TanitaDataSource;

/**
 * This is the first person specific screen which allows you to choose what you want to do.
 * 
 * @author mcharland
 */
public class PersonHomeActivity extends RoboActivity {

	/** The next button. */
	@InjectView(R.id.add)
	private Button add;

	/** The view button. */
	@InjectView(R.id.view)
	private Button view;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.person_home);
		add.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), DateAndTimeActivity.class);
				Bundle extras = getIntent().getExtras();
				intent.putExtra(PeopleListActivity.PERSON, extras.getInt(PeopleListActivity.PERSON));
				startActivity(intent);
			}
		});

		view.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(getBaseContext(), DateListActivity.class);
				Bundle extras = getIntent().getExtras();
				intent.putExtra(PeopleListActivity.PERSON, extras.getInt(PeopleListActivity.PERSON));
				startActivity(intent);

				TanitaDataSource tds = new TanitaDataSource(getBaseContext());
				tds.open();

				final List<AbstractData> data = tds.getAll();
				for (AbstractData ad : data) {
					TanitaData td = (TanitaData) ad;
					if (td == null) {
						System.out.println("null");
					} else {
						System.out.println(td);
					}
				}
				tds.close();
			}
		});
	}
}

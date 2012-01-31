package ca.charland.tanita;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * The Class AbstractNextActivity which holds the next button so all the classes
 * don't have to repeat it.
 * 
 * @author mcharland
 */
public abstract class AbstractNextActivity extends RoboActivity {

	/** The next button. */
	@InjectView(R.id.next)
	private Button next;

	/** {@inheritDoc} */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		next.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(getBaseContext(), getNextClass()));
			}
		});
	}

	/**
	 * Gets the next class.
	 *
	 * @return the next class
	 */
	public abstract Class<?> getNextClass();
}

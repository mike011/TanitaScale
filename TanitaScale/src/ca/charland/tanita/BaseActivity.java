package ca.charland.tanita;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.ContentValues;
import android.os.Bundle;
import android.widget.Button;

/**
 * @author mcharland
 */
public abstract class BaseActivity extends RoboActivity {

	@InjectView(R.id.next)
	private Button next;

	protected abstract int getResourceIDForLayout();

	protected abstract ContentValues getValues();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getResourceIDForLayout());
		next.setOnClickListener(new NextButtonOnClickListener(this));
	}

	protected abstract Class<?> getNextClass();
	
}

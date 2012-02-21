import roboguice.activity.RoboActivity;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.widget.TextView;
import ca.charland.tanita.R;

public class InjectedActivity extends RoboActivity {
	@InjectResource(R.string.next)
	String caption;
	
	@InjectView(R.id.weight)
	TextView injectedTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weight);
		injectedTextView.setText(caption);
		
	}
}
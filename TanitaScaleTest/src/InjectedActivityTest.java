import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import roboguice.inject.InjectView;
import android.content.res.Resources;
import android.widget.TextView;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.R;

@RunWith(TanitaMeRobolectricTestRunner.class)
public class InjectedActivityTest {

	InjectedActivity injectedActivity;
	String caption;

	@Before
	public void setUp() {
		injectedActivity = new InjectedActivity();
		Resources resources = injectedActivity.getResources();
		caption = resources.getString(R.string.next);
	}
	
	@InjectView(R.id.weight)
	TextView injectedTextView;
	
	@Test
	public void shouldAssignStringToTextView() throws Exception {
		injectedActivity.onCreate(null);
		TextView injectedTextView = (TextView) injectedActivity.findViewById(R.id.next);
		assertEquals(injectedTextView.getText(), caption);
	}
}

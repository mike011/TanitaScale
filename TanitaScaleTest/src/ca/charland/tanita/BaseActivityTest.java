package ca.charland.tanita;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.widget.TextView;
import ca.charland.R;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;


/**
 * @author mcharland
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class BaseActivityTest {

	private BaseActivity activity;

	@Before
	public void setUp() throws Exception {
		activity = new TestBaseActivity();
		activity.onCreate(null);
	}

	@Test
	public void testOnCreateBundle() {
		TextView next = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.next);
		assertNotNull("Button not created", next);
	}

}

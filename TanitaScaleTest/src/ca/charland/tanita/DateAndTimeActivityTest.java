package ca.charland.tanita;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;

import com.google.inject.Inject;

/**
 * @author michael
 *
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class DateAndTimeActivityTest {

	@Inject Context context;

    @Inject DateAndTimeActivity activity;
    
	/**
	 * Test method for {@link ca.charland.tanita.DateAndTimeActivity#getValues()}.
	 */
	@Test
	public final void testGetValues() {
		 activity.onCreate(null);
		 activity.getValues();
	}

	/**
	 * Test method for {@link ca.charland.tanita.DateAndTimeActivity#getNextClass()}.
	 */
	@Test
	public final void testGetNextClass() {
		 activity.getNextClass();
	}

}

package ca.charland.tanita.base.activity;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;
import android.content.Intent;
import ca.charland.robolectric.BaseRobolectricTestRunner;
import ca.charland.tanita.base.db.DataSource;
import ca.charland.tanita.base.db.DataTable;

import com.google.inject.Inject;

/**
 * @author mcharland
 */
@RunWith(BaseRobolectricTestRunner.class)
public class BaseDateAndTimeActivityTest {

	private static class ActivityUnderTest extends BaseDateAndTimeActivity {

		@Override 
		protected DataSource getDataSource() {
			return new TestDataSource();
		}

		@Override
		protected Class<?> getNextClass() {
			return null;
		}
	}
	
	@Inject
	private ActivityUnderTest activity;

	@Before
	public void setup() {
		activity.setIntent(new Intent());
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.activity.BaseDateAndTimeActivity#getValues()}.
	 */
	@Test
	public final void testGetValues() {
		
		ContentValues values = activity.getValues();
		assertTrue(values.containsKey(DataTable.Column.DATE.toString()));
		Long object = (Long) values.get(DataTable.Column.DATE.toString());
		assertThat(object.intValue(), is(lessThan(0)));
	}

	/**
	 * Test method for {@link ca.charland.activity.BaseDateAndTimeActivity#getNextClass()}.
	 */
	@Test
	public final void testGetNextClass() {
		assertThat(activity.getNextClass(), is(nullValue()));
	}
}
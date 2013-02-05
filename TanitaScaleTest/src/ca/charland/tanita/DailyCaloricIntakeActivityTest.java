package ca.charland.tanita;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.R;
import ca.charland.robolectric.TanitaRobolectricTestRunner;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.db.TestTanitaDataSource;

import com.google.inject.Inject;

/**
 * @author mcharland
 */
@RunWith(TanitaRobolectricTestRunner.class)
public class DailyCaloricIntakeActivityTest {

	private static class ActivityUnderTest extends DailyCaloricIntakeActivity {

		@Override
		protected void setSex(int id, int female) {
		}

		@Override
		protected TanitaDataSource getDataSource() {
			return new TestTanitaDataSource();
		}

		@Override
		protected void setData() {
		}
	}

	@Inject
	private ActivityUnderTest activity;

	@Before
	public void setup() {
		activity.onCreate(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.DailyCaloricIntakeActivity#getResourceIDForLayout()}.
	 */
	@Test
	public void testGetLayoutResID() {
		assertThat(activity.getResourceIDForLayout(), is(R.layout.dci));
	}

	/**
	 * Test method for {@link ca.charland.tanita.DailyCaloricIntakeActivity#getColumnName()}.
	 */
	@Test
	public void testGetColumnName() {
		assertThat(activity.getColumnName(), is(TanitaDataTable.Column.DAILY_CALORIC_INTAKE));
	}

	/**
	 * Test method for {@link ca.charland.tanita.DailyCaloricIntakeActivity#getNextClass()}.
	 */
	@Test
	public void testGetNextClass() {
		assertThat(activity.getNextClass().toString(), is(MetabolicAgeActivity.class.toString()));
	}

}

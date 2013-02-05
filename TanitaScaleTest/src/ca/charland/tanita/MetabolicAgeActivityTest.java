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
 * 
 */
@RunWith(TanitaRobolectricTestRunner.class)
public class MetabolicAgeActivityTest {

	private static class ActivityUnderTest extends MetabolicAgeActivity {

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

	@Test
	public void testGetLayoutResID() {
		assertThat(activity.getResourceIDForLayout(), is(R.layout.metabolic_age));
	}

	@Test
	public void testGetColumnName() {
		assertThat(activity.getColumnName(), is(TanitaDataTable.Column.METABOLIC_AGE));
	}

	@Test
	public void testGetNextClass() {
		assertThat(activity.getNextClass().toString(), is(BodyWaterPercentageActivity.class.toString()));
	}

}

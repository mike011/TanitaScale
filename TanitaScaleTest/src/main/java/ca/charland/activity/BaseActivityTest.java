package ca.charland.activity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import ca.charland.tanita.R;
import ca.charland.db.Data;
import ca.charland.db.DataSource;
import ca.charland.robolectric.BaseRobolectricTestRunner;

@RunWith(BaseRobolectricTestRunner.class)
public class BaseActivityTest {

	private TestBaseActivity activity;

	private static class TestDataSource extends DataSource {

		boolean open;
		boolean closed;

		public TestDataSource() {
			super(null);
		}

		@Override
		protected Data convertToAbstractData(Cursor cursor) {
			return null;
		}

		@Override
		protected List<String> getAllColumns() {
			return null;
		}

		@Override
		public void openDatabaseConnection() throws SQLException {
			open = true;
		}

		@Override
		public void closeDatabaseConnection() throws SQLException {
			closed = true;
		}

	}

	private class TestBaseActivity extends BaseActivity {

		static final int ID = R.layout.date_view;
		final TestDataSource datasource = new TestDataSource();
		final ContentValues contentValues = new ContentValues();

		@Override
		protected int getResourceIDForLayout() {
			return ID;
		}

		@Override
		protected ContentValues getValues() {
			return contentValues;
		}

		@Override
		protected NextButtonOnClickListener getNextButtonOnClickListener() {
			return new NextButtonOnClickListener(activity, datasource);
		}

		@Override
		protected DataSource getDataSource() {
			return datasource;
		}

		@Override
		protected Class<?> getNextClass() {
			return BaseRobolectricTestRunner.class;
		}
	}

	@Before
	public void setup() {
		activity = new TestBaseActivity();
		activity.onCreate(null);
	}

	@Test
	public void testConstructor() {
		assertThat(activity, is(notNullValue()));
	}

	@Test
	public void testOnResume() {
		activity.onResume();
		assertThat(activity.datasource.open, is(true));
		assertThat(activity.datasource.closed, is(false));
	}

	@Test
	public void testOnPause() {
		activity.onPause();
		assertThat(activity.datasource.open, is(false));
		assertThat(activity.datasource.closed, is(true));
	}

	@Test
	public void testGetResourceIDForLayout() {
		assertThat(activity.getResourceIDForLayout(), is(TestBaseActivity.ID));
	}

	@Test
	public void testGetValues() {
		assertThat(activity.getValues(), is(activity.contentValues));
	}

	@Test
	public void testGetNextButtonOnClickListener() {
		assertThat(activity.getNextButtonOnClickListener(), is(notNullValue()));
	}

	@Test
	public void testGetDataSource() {
		assertThat(activity.datasource, is(activity.getDataSource()));
	}

	@Test
	public void testGetNextClass() {
		assertThat(activity.getNextClass().toString(), is(BaseRobolectricTestRunner.class.toString()));
	}

}

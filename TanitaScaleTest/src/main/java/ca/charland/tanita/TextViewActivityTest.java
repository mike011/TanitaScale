package ca.charland.tanita;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.widget.TextView;
import ca.charland.robolectric.TanitaRobolectricTestRunner;
import ca.charland.tanita.base.activity.BaseActivity;
import ca.charland.tanita.base.db.Data;
import ca.charland.tanita.base.db.DataSource;
import ca.charland.tanita.base.db.DatabaseConnection;
import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.db.TestTanitaDataSource;

/**
 * @author mcharland
 */
@RunWith(TanitaRobolectricTestRunner.class)
public class TextViewActivityTest {

	private BaseActivity activity;

	@Before
	public void setUp() throws Exception {
		activity = new TestBaseActivity();
		activity.onCreate(null);

	}

	@Test
	public void testEnterText() {
		TextView enter = (TextView) TanitaRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.enter_your);

		assertThat("Enter not set", enter, is(notNullValue()));
		CharSequence text = enter.getText();
		assertThat("Enter text not set", text, is(notNullValue()));
		assertThat(text.toString(), is("Enter your Body Fat for your Left Arm"));
	}

	@Test
	public void testPreviousText() {
		TextView previous = (TextView) TanitaRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.previous);

		assertThat("Previous not set", previous, is(notNullValue()));
		CharSequence text = previous.getText();
		assertThat("Previous text not set", text, is(notNullValue()));
		assertThat(text.toString(), is("0.00"));
	}

	@Test
	public void testAverageText() {
		TextView average = (TextView) TanitaRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.average);

		assertThat("Average not set", average, is(notNullValue()));
		CharSequence text = average.getText();
		assertThat("Average text not set", text, is(notNullValue()));
		assertThat(text.toString(), is("0.00"));
	}

	private static class BodyFatLeftArmActivityUnderTest extends BodyFatLeftArmActivity {

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

	@Test
	public void testGetValues() {

		BodyFatLeftArmActivityUnderTest activity = new BodyFatLeftArmActivityUnderTest();
		activity.onCreate(null);

		assertThat(activity, is(notNullValue()));
		ContentValues values = activity.getValues();
		assertThat(values.size(), is(1));

		assertThat(values.containsKey(TanitaDataTable.Column.BODY_FAT_LEFT_ARM.toString()), is(true));
		assertThat(values.get(TanitaDataTable.Column.BODY_FAT_LEFT_ARM.toString()).toString(), is(""));
	}

	private static class EmptyDataSource extends DataSource {

		public EmptyDataSource() {
			super(new DatabaseConnection(null, null, null, null));
		}

		@Override
		protected Data convertToAbstractData(Cursor cursor) {
			return null;
		}

		@Override
		protected List<String> getAllColumns() {
			return new ArrayList<String>();
		}

	}

	private static class TextViewActivityWithNoDB extends BodyFatLeftArmActivity {

		@Override
		protected DataSource getDataSource() {
			return new EmptyDataSource();
		}
	}

	@Test(expected = ExtrasNotSetException.class)
	public void testExtrasNotSet() {
		TextViewActivity activity = new TextViewActivityWithNoDB();
		activity.setIntent(new Intent());
		activity.onCreate(null);
	}
}

package ca.charland.tanita.base.activity.manage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.BaseRobolectricTestRunner;

@RunWith(BaseRobolectricTestRunner.class)
public class BaseFirstActivityTest {

	private static class TestBaseFirstActivity extends BaseFirstActivity {

		@Override
		protected BasePersonHomeActivityDataHolder getSingleUserModeDataHolder() {
			return null;
		}

		@Override
		protected BaseFirstActivityDataHolder getMultipleUserModeDataHolder() {
			return null;
		}

	}

	private BaseFirstActivity activity;

	@Before
	public void setup() {
		activity = new TestBaseFirstActivity();
	}

	@Test
	public void constructor() {
		assertThat(activity, is(notNullValue()));
	}

	@Test
	public void testGetSingleUserModeDataHolder() {
		assertThat(activity.getSingleUserModeDataHolder(), is(nullValue()));
	}

	@Test
	public void testGetMultipleUserModeDataHolder() {
		assertThat(activity.getMultipleUserModeDataHolder(), is(nullValue()));
	}
}

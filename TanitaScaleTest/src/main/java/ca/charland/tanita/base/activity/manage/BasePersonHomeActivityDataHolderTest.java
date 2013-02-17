package ca.charland.tanita.base.activity.manage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ca.charland.tanita.R;

public class BasePersonHomeActivityDataHolderTest {

	private static class TestPersonHomeActivityDataHolder extends BasePersonHomeActivityDataHolder {

		@Override
		public Class<?> getNextAddClass() {
			return null;
		}

		@Override
		public Class<?> getNextViewClass() {
			return null;
		}

		@Override
		protected Class<?> getNextClass() {
			return null;
		}
	}

	private BasePersonHomeActivityDataHolder activity;

	@Before
	public void setup() {
		activity = new TestPersonHomeActivityDataHolder();
	}

	@Test
	public void constructor() {
		assertThat(activity, is(notNullValue()));
	}

	@Test
	public void testGetAdd() {
		assertThat(activity.getAdd(), is(R.string.add));
	}

	@Test
	public void testGetView() {
		assertThat(activity.getView(), is(R.string.view));
	}

	@Test
	public void testGetNextClass() {
		assertThat(activity.getNextClass(), is(nullValue()));
	}
}
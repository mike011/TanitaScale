package ca.charland.tanita.base.activity.manage;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import ca.charland.tanita.R;

public class BaseFirstActivityDataHolderTest {
	
	private static class EmptyBaseFirstActivityDataHolder extends BaseFirstActivityDataHolder {

		@Override
		public Class<?> getNextViewClass() {
			return null;
		}
	}

	private BaseFirstActivityDataHolder activity;

	@Before
	public void setup() {
		activity = new EmptyBaseFirstActivityDataHolder();
	}

	@Test
	public void constructor() {
		assertThat(activity, is(notNullValue()));
	}

	@Test
	public void testGetAdd() {
		assertThat(activity.getAdd(), is(R.string.add_new_person));
	}

	@Test
	public void testGetView() {
		assertThat(activity.getView(), is(R.string.view_person));
	}

	@Test
	public void testGetNextAddClass() {
		assertThat(activity.getNextAddClass().toString(), is(BaseAddANewPersonActivity.class.toString()));
	}

	@Test
	public void testGetNextViewClass() {
		assertThat(activity.getNextViewClass(), is(nullValue()));
	}
}

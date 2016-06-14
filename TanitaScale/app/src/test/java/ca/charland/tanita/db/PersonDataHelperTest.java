package ca.charland.tanita.db;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.database.SQLException;
import ca.charland.robolectric.TanitaRobolectricTestRunner;
import ca.charland.tanita.base.db.Data;

/**
 * @author mcharland
 */
@RunWith(TanitaRobolectricTestRunner.class)
public class PersonDataHelperTest {

	private static final String MALE = "Male";
	private static final String FEMALE = "Female";
	private static final int DONT_CARE_ABOUT = 3;

	private static class NoDbPersonDataSource extends PersonDataSource {

		private List<Data> result;

		public NoDbPersonDataSource() {
			super(null);
		}

		public void openDatabaseConnection() throws SQLException {
		}

		public void closeDatabaseConnection() throws SQLException {
		}

		public List<Data> query(String selection) {
			return result;
		}

		public void setQueryResult(List<Data> data) {
			result = data;
		}

	}

	@Test
	public void testGetSexNull() {
		NoDbPersonDataSource pds = new NoDbPersonDataSource();
		String result = PersonDataHelper.getSex(pds, DONT_CARE_ABOUT);
		assertThat(result, is(MALE));
	}

	@Test
	public void testGetSexEmpty() {
		NoDbPersonDataSource pds = new NoDbPersonDataSource();
		pds.setQueryResult(new ArrayList<Data>());
		String result = PersonDataHelper.getSex(pds, DONT_CARE_ABOUT);
		assertThat(result, is(MALE));
	}

	@Test
	public void testGetSexFemale() {
		NoDbPersonDataSource pds = new NoDbPersonDataSource();
		ArrayList<Data> data = new ArrayList<Data>();
		PersonData pd = new PersonData();
		pd.setSex(FEMALE);
		data.add(pd);
		pds.setQueryResult(data);
		String result = PersonDataHelper.getSex(pds, DONT_CARE_ABOUT);
		assertThat(result, is(FEMALE));
	}

	@Test
	public void testGetSexMale() {
		NoDbPersonDataSource pds = new NoDbPersonDataSource();
		ArrayList<Data> data = new ArrayList<Data>();
		PersonData pd = new PersonData();
		pd.setSex(MALE);
		data.add(pd);
		pds.setQueryResult(data);
		String result = PersonDataHelper.getSex(pds, DONT_CARE_ABOUT);
		assertThat(result, is(MALE));
	}
}

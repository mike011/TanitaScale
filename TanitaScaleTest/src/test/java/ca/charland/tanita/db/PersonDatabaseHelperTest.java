package ca.charland.tanita.db;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaRobolectricTestRunner;
import ca.charland.tanita.base.db.DatabaseConnection;

/**
 * @author mcharland
 */
@RunWith(TanitaRobolectricTestRunner.class)
public class PersonDatabaseHelperTest {

	@Test
	public void testPeopleDatabaseHelper() {
		assertThat(new DatabaseConnection(null, null, null, null), is(notNullValue()));
	}

}

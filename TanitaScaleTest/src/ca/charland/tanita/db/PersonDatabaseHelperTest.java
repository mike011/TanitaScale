package ca.charland.tanita.db;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.db.DatabaseConnection;
import ca.charland.robolectric.TanitaRobolectricTestRunner;

/**
 * @author mcharland
 */
@RunWith(TanitaRobolectricTestRunner.class)
public class PersonDatabaseHelperTest {

	/**
	 * Test method for {@link ca.charland.tanita.db.DatabaseConnection#PeopleDatabaseHelper(android.content.Context)}.
	 */
	@Test
	public void testPeopleDatabaseHelper() {
		assertNotNull(new DatabaseConnection(null, null, null, null));
	}

}

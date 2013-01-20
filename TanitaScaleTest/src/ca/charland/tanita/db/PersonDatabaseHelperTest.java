package ca.charland.tanita.db;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.db.DatabaseHelper;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;

/**
 * @author mcharland
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class PersonDatabaseHelperTest {

	/**
	 * Test method for {@link ca.charland.tanita.db.DatabaseHelper#PeopleDatabaseHelper(android.content.Context)}.
	 */
	@Test
	public void testPeopleDatabaseHelper() {
		assertNotNull(new DatabaseHelper(null, null, null, null));
	}

}

package ca.charland.tanita.db;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;

/**
 * Testing Person Data Source.
 * 
 * @author mcharland.
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class PeopleDatabaseHelperTest {

	/**
	 * Test method for {@link ca.charland.tanita.db.PeopleDatabaseHelper#PeopleDatabaseHelper(android.content.Context)}.
	 */
	@Test
	public void testPeopleDatabaseHelper() {
		assertNotNull(new PeopleDatabaseHelper(null));
	}

}

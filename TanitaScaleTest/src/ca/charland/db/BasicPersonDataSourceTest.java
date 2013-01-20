package ca.charland.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ContentValues;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.PersonDataTable;

@RunWith(TanitaMeRobolectricTestRunner.class)
public class BasicPersonDataSourceTest {

	private BasicPersonDataSource bpds;

	@Before
	public void setup() {
		bpds = new BasicPersonDataSource(null, null, null, null);
	}

	@After
	public void tearDown() {
		bpds.closeDatabaseConnection();
	}
	
	@Test
	public void testBasicPersonDataSource() {
		assertNotNull(bpds);
	}
	
	@Test
	public void testGetAllColumns() {
		List<String> allColumns = bpds.getAllColumns();
		assertEquals(2, allColumns.size());
		assertEquals("_id", allColumns.get(0));
		assertEquals("name", allColumns.get(1));
	}

	@Test
	public void testPopulateContentValuesKeyValuePairs() {
		String value = "frank";
		bpds.populateContentValuesKeyValuePairs(value);
		ContentValues contentValues = bpds.getContentValues();
		assertEquals(1, contentValues.size());
		assertEquals(value, contentValues.get(PersonDataTable.Column.NAME.toString()));
	}

	@Test
	public void testConvertToAbstractDataCursor() {
		int id = 5;
		String name = "bob";

		CustomCursor cursor = new CustomCursor();
		cursor.setInt(0, id);
		cursor.setString(1, name);

		BasicPersonData person = bpds.convertToAbstractData(cursor);
		
		assertEquals(id, person.getId());
		assertEquals(name, person.getName());

	}

}

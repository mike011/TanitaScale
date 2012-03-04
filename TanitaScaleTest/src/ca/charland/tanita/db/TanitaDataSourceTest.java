package ca.charland.tanita.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaMeRobolectricTestRunner;

/**
 * Tests for Tanita Data Source.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class TanitaDataSourceTest {

	/**
	 * Class under test.
	 */
	private TanitaDataSource tds;

	/** Sets things up. */
	@Before
	public void setup() {
		tds = new TanitaDataSource(null);
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#TanitaDataSource(android.content.Context)}.
	 */
	@Test
	public void testTanitaDataSource() {
		assertNotNull(tds);
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#convertToAbstractData(android.database.Cursor)}.
	 */
	@Test
	public void testCursorConverter() {

		// Setup
		int id = 1;
		long person = 2;
		Date date = new Date(3);
		double weight = 4.0;
		int dci = 5;
		int age = 6;
		double body_fat_total = 7;
		double body_fat_left_arm = 8;
		double body_fat_right_arm = 9;
		double body_fat_right_leg = 10;
		double body_fat_left_leg = 11;
		double body_fat_trunk = 12;
		double muscle_mass_total = 13;
		double muscle_mass_left_arm = 14;
		double muscle_mass_right_arm = 15;
		double muscle_mass_right_leg = 16;
		double muscle_mass_left_leg = 17;
		double muscle_mass_trunk = 18;
		int physic_rating = 19;
		double body_water_percentage = 20;
		double bone_mass = 21;
		int visceral_fat = 22;

		MyCursor cursor = new MyCursor();
		cursor.setInt(TanitaDataTable.Column.ID.ordinal(), id);
		cursor.setLong(TanitaDataTable.Column.PERSON.ordinal(), person);
		cursor.setLong(TanitaDataTable.Column.DATE.ordinal(), date.getTime());
		cursor.setDouble(TanitaDataTable.Column.WEIGHT.ordinal(), weight);
		cursor.setInt(TanitaDataTable.Column.DAILY_CALORIC_INTAKE.ordinal(), dci);
		cursor.setInt(TanitaDataTable.Column.VISCERAL_FAT.ordinal(), visceral_fat);

		cursor.setInt(TanitaDataTable.Column.METABOLIC_AGE.ordinal(), age);
		cursor.setDouble(TanitaDataTable.Column.BODY_FAT_TOTAL.ordinal(), body_fat_total);
		cursor.setDouble(TanitaDataTable.Column.BODY_FAT_LEFT_ARM.ordinal(), body_fat_left_arm);
		cursor.setDouble(TanitaDataTable.Column.BODY_FAT_RIGHT_ARM.ordinal(), body_fat_right_arm);
		cursor.setDouble(TanitaDataTable.Column.BODY_FAT_RIGHT_LEG.ordinal(), body_fat_right_leg);
		cursor.setDouble(TanitaDataTable.Column.BODY_FAT_LEFT_LEG.ordinal(), body_fat_left_leg);
		cursor.setDouble(TanitaDataTable.Column.BODY_FAT_TRUNK.ordinal(), body_fat_trunk);
		cursor.setDouble(TanitaDataTable.Column.MUSCLE_MASS_TOTAL.ordinal(), muscle_mass_total);
		cursor.setDouble(TanitaDataTable.Column.MUSCLE_MASS_LEFT_ARM.ordinal(), muscle_mass_left_arm);
		cursor.setDouble(TanitaDataTable.Column.MUSCLE_MASS_RIGHT_ARM.ordinal(), muscle_mass_right_arm);
		cursor.setDouble(TanitaDataTable.Column.MUSCLE_MASS_RIGHT_LEG.ordinal(), muscle_mass_right_leg);
		cursor.setDouble(TanitaDataTable.Column.MUSCLE_MASS_LEFT_LEG.ordinal(), muscle_mass_left_leg);
		cursor.setDouble(TanitaDataTable.Column.MUSCLE_MASS_TRUNK.ordinal(), muscle_mass_trunk);
		cursor.setInt(TanitaDataTable.Column.PHYSIC_RATING.ordinal(), physic_rating);
		cursor.setDouble(TanitaDataTable.Column.BODY_WATER_PERCENTAGE.ordinal(), body_water_percentage);
		cursor.setDouble(TanitaDataTable.Column.BONE_MASS.ordinal(), bone_mass);

		// Exercise
		TanitaData td = tds.convertToAbstractData(cursor);

		// Verify
		assertNotNull(td);
		assertEquals(id, td.getId());
		assertEquals(person, td.getPerson(), 0.1);
		assertEquals(date, td.getDate());
		assertEquals(weight, td.getWeight(), 0.1);
		assertEquals(dci, td.getDailyCaloricIntake());
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#getAllColumns()}.
	 */
	@Test
	public void testGetAllColumnsLength() {
		List<String> allColumns = tds.getAllColumns();
		assertNotNull(allColumns);
		assertEquals(22, allColumns.size());
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#getAllColumns()}.
	 */
	@Test
	public void testGetAllColumnsID() {
		List<String> allColumns = tds.getAllColumns();
		assertEquals("_id", allColumns.get(0));
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#getAllColumns()}.
	 */
	@Test
	public void testGetAllColumnsPerson() {
		List<String> allColumns = tds.getAllColumns();
		assertEquals("person", allColumns.get(1));
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#getAllColumns()}.
	 */
	@Test
	public void testGetAllColumnsDate() {
		List<String> allColumns = tds.getAllColumns();
		assertEquals("date", allColumns.get(2));
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#getAllColumns()}.
	 */
	@Test
	public void testGetAllColumnsWeight() {
		List<String> allColumns = tds.getAllColumns();
		assertEquals("weight", allColumns.get(3));
	}

	/**
	 * Test method for {@link ca.charland.tanita.db.TanitaDataSource#getAllColumns()}.
	 */
	@Test
	public void testGetAllColumnsDCI() {
		List<String> allColumns = tds.getAllColumns();
		assertEquals("daily_caloric_intake", allColumns.get(4));
	}
}

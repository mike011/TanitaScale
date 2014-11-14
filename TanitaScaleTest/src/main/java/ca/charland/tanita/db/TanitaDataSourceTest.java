package ca.charland.tanita.db;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaRobolectricTestRunner;
import ca.charland.tanita.base.db.CustomCursor;
import ca.charland.tanita.base.db.DatabaseConnection;

/**
 * @author mcharland
 */
@RunWith(TanitaRobolectricTestRunner.class)
public class TanitaDataSourceTest {

	private TanitaDataSource tds;

	@Before
	public void setup() {
		tds = new TanitaDataSource(new TanitaDatabaseConnection(null));
	}

	@Test
	public void testTanitaDataSource() {
		assertThat(tds, is(notNullValue()));
		assertThat(tds.getDatabaseHelper(), is(notNullValue()));
	}

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
		int emails = 23;

		CustomCursor cursor = new CustomCursor();
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
		cursor.setInt(TanitaDataTable.Column.EMAILS_SENT.ordinal(), emails);

		// Exercise
		TanitaData td = tds.convertToAbstractData(cursor);

		// Verify
		assertThat(td, is(notNullValue()));
		assertThat(td.getId(), is(id));
		assertThat(td.getPerson(), is(person));
		assertThat(td.getDate().toString(), is(date.toString()));
		assertThat(td.getWeight(), is(weight));
		assertThat(td.getDailyCaloricIntake(), is(dci));
		assertThat(td.getEmailsSent(), is(emails));
	}

	@Test
	public void testGetAllColumnsLength() {
		List<String> allColumns = tds.getAllColumns();
		assertThat(allColumns, is(notNullValue()));
		assertThat(allColumns.size(), is(23));
	}

	@Test
	public void testGetAllColumnsID() {
		List<String> allColumns = tds.getAllColumns();
		assertThat(allColumns.get(0), is("_id"));
	}

	@Test
	public void testGetAllColumnsPerson() {
		List<String> allColumns = tds.getAllColumns();
		assertThat(allColumns.get(1), is("person"));
	}

	@Test
	public void testGetAllColumnsDate() {
		List<String> allColumns = tds.getAllColumns();
		assertThat(allColumns.get(2), is("date"));
	}

	@Test
	public void testGetAllColumnsWeight() {
		List<String> allColumns = tds.getAllColumns();
		assertThat(allColumns.get(3), is("weight"));
	}

	@Test
	public void testGetAllColumnsDCI() {
		List<String> allColumns = tds.getAllColumns();
		assertThat(allColumns.get(4), is("daily_caloric_intake"));
	}

	@Test
	public void testGetDatabase() {
		DatabaseConnection databaseHelper = tds.getDatabaseHelper();
		assertThat(databaseHelper.getDatabaseName(), is("tanita.db"));
	}

	@Test
	public void testGetTableNames() {
		DatabaseConnection databaseHelper = tds.getDatabaseHelper();
		assertThat(databaseHelper.getTableName(), is("tanita_data"));
	}

	@Test
	public void testGetCreateTableSQL() {
		DatabaseConnection databaseHelper = tds.getDatabaseHelper();
		String create = "create table tanita_data( _id integer primary key autoincrement, person integer not null, date integer, body_fat_total integer, body_fat_left_arm integer, body_fat_right_arm integer, body_fat_right_leg integer, body_fat_left_leg integer, body_fat_trunk integer, muscle_mass_total integer, muscle_mass_left_arm integer, muscle_mass_right_arm integer, muscle_mass_right_leg integer, muscle_mass_left_leg integer, muscle_trunk integer, physic_rating integer, weight integer, daily_caloric_intake integer, metabolic_age integer, body_water_percentage integer, visceral_fat integer, bone_mass integer, emailed integer);";
		assertThat(databaseHelper.getCreateTableSQL(), is(create));
	}
}

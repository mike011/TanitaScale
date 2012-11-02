package ca.charland.tanita.db;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author mcharland
 */
public class TanitaDataTableTest {

	/**
	 * Test create.
	 */
	@Test
	public void testCREATE() {
		StringBuffer expected = new StringBuffer();
		expected.append("create table tanita_data( ");
		expected.append("_id integer primary key autoincrement, ");
		expected.append("person integer not null, ");
		expected.append("date integer, ");
		expected.append("body_fat_total integer, ");
		expected.append("body_fat_left_arm integer, ");
		expected.append("body_fat_right_arm integer, ");
		expected.append("body_fat_right_leg integer, ");
		expected.append("body_fat_left_leg integer, ");
		expected.append("body_fat_trunk integer, ");
		expected.append("muscle_mass_total integer, ");
		expected.append("muscle_mass_left_arm integer, ");
		expected.append("muscle_mass_right_arm integer, ");
		expected.append("muscle_mass_right_leg integer, ");
		expected.append("muscle_mass_left_leg integer, ");
		expected.append("muscle_trunk integer, ");
		expected.append("physic_rating integer, ");
		expected.append("weight integer, ");
		expected.append("daily_caloric_intake integer, ");
		expected.append("metabolic_age integer, ");
		expected.append("body_water_percentage integer, ");
		expected.append("visceral_fat integer, ");
		expected.append("bone_mass integer);");
		assertEquals(expected.toString(), TanitaDataTable.CREATE_DATABASE_TABLE);
	}
}

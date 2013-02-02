package ca.charland.tanita.db;

import ca.charland.db.DataTable;

/**
 * Tanita data related information.
 * 
 * @author mcharland
 */
public class TanitaDataTable implements DataTable {

	public static final String TABLE_NAME = "tanita_data";

	/**
	 * Contains the column names and there index based off of the ordering they are defined.
	 * 
	 * @author mcharland
	 */
	public static enum Column {

		/** The unique ID of the table. */
		ID(ID_COLUMN_NAME),

		PERSON(PERSON_COLUMN_NAME),

		DATE(DATE_COLUMN_NAME),

		WEIGHT("weight"),

		DAILY_CALORIC_INTAKE("daily_caloric_intake"),

		BODY_FAT_TOTAL("body_fat_total"),

		BODY_FAT_LEFT_ARM("body_fat_left_arm"),

		BODY_FAT_RIGHT_ARM("body_fat_right_arm"),

		BODY_FAT_RIGHT_LEG("body_fat_right_leg"),

		BODY_FAT_LEFT_LEG("body_fat_left_leg"),

		BODY_FAT_TRUNK("body_fat_trunk"),

		MUSCLE_MASS_TOTAL("muscle_mass_total"),

		MUSCLE_MASS_LEFT_ARM("muscle_mass_left_arm"),

		MUSCLE_MASS_RIGHT_ARM("muscle_mass_right_arm"),

		MUSCLE_MASS_RIGHT_LEG("muscle_mass_right_leg"),

		MUSCLE_MASS_LEFT_LEG("muscle_mass_left_leg"),

		MUSCLE_MASS_TRUNK("muscle_trunk"),

		PHYSIC_RATING("physic_rating"),

		METABOLIC_AGE("metabolic_age"),

		BODY_WATER_PERCENTAGE("body_water_percentage"),

		VISCERAL_FAT("visceral_fat"),

		BONE_MASS("bone_mass");
		
		private final String name;

		Column(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	public static final String CREATE_DATABASE_TABLE = getTanitaDataTable();

	private static String getTanitaDataTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("create table ").append(TABLE_NAME).append("( ");
		sql.append(Column.ID).append(" integer primary key autoincrement, ");
		sql.append(Column.PERSON).append(" integer not null, ");
		sql.append(Column.DATE).append(" integer, ");
		sql.append(Column.BODY_FAT_TOTAL).append(" integer, ");
		sql.append(Column.BODY_FAT_LEFT_ARM).append(" integer, ");
		sql.append(Column.BODY_FAT_RIGHT_ARM).append(" integer, ");
		sql.append(Column.BODY_FAT_RIGHT_LEG).append(" integer, ");
		sql.append(Column.BODY_FAT_LEFT_LEG).append(" integer, ");
		sql.append(Column.BODY_FAT_TRUNK).append(" integer, ");
		sql.append(Column.MUSCLE_MASS_TOTAL).append(" integer, ");
		sql.append(Column.MUSCLE_MASS_LEFT_ARM).append(" integer, ");
		sql.append(Column.MUSCLE_MASS_RIGHT_ARM).append(" integer, ");
		sql.append(Column.MUSCLE_MASS_RIGHT_LEG).append(" integer, ");
		sql.append(Column.MUSCLE_MASS_LEFT_LEG).append(" integer, ");
		sql.append(Column.MUSCLE_MASS_TRUNK).append(" integer, ");
		sql.append(Column.PHYSIC_RATING).append(" integer, ");
		sql.append(Column.WEIGHT).append(" integer, ");
		sql.append(Column.DAILY_CALORIC_INTAKE).append(" integer, ");
		sql.append(Column.METABOLIC_AGE).append(" integer, ");
		sql.append(Column.BODY_WATER_PERCENTAGE).append(" integer, ");
		sql.append(Column.VISCERAL_FAT).append(" integer, ");
		sql.append(Column.BONE_MASS).append(" integer");
		sql.append(");");
		String string = sql.toString();
		return string;
	}
}

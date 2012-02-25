package ca.charland.tanita.db;

/**
 * The Class TanitaDataTable which holds the Tanita data related information.
 * 
 * @author mcharland
 */
public class TanitaDataTable {

	/** The name of the table. */
	static final String NAME = "tanita_data";

	/**
	 * The Class Column. Info.
	 */
	public static enum Column {

		/** The unique ID of the table. */
		ID("_id"),

		/** The Constant NAME. */
		PERSON("person"),

		/** The Constant DATE. */
		DATE("date"),
		
		/** The Constant WEIGHT. */
		WEIGHT("weight"),

		/** The Constant BODY_FAT_TOTAL. */
		BODY_FAT_TOTAL("body_fat_total"),

		/** The Constant BODY_FAT_LEFT_ARM. */
		BODY_FAT_LEFT_ARM("body_fat_left_arm"),

		/** The Constant BODY_FAT_RIGHT_ARM. */
		BODY_FAT_RIGHT_ARM("body_fat_right_arm"),

		/** The Constant BODY_FAT_RIGHT_LEFT. */
		BODY_FAT_RIGHT_LEFT("body_fat_right_leg"),

		/** The Constant BODY_FAT_LEFT_LEG. */
		BODY_FAT_LEFT_LEG("body_fat_left_leg"),

		/** The Constant BODY_FAT_TRUNK. */
		BODY_FAT_TRUNK("body_fat_trunk"),

		/** The Constant MUSCLE_MASS_TOTAL. */
		MUSCLE_MASS_TOTAL("body_muscle_mass_total"),

		/** The Constant MUSCLE_MASS_LEFT_ARM. */
		MUSCLE_MASS_LEFT_ARM("body_muscle_mass_left_arm"),

		/** The Constant MUSCLE_MASS_RIGHT_ARM. */
		MUSCLE_MASS_RIGHT_ARM("body_muscle_mass_right_arm"),

		/** The Constant MUSCLE_MASS_RIGHT_LEG. */
		MUSCLE_MASS_RIGHT_LEG("body_muscle_mass_right_leg"),

		/** The Constant MUSCLE_MASS_LEFT_LEG. */
		MUSCLE_MASS_LEFT_LEG("body_muscle_mass_left_leg"),

		/** The Constant MUSCLE_MASS_TRUNK. */
		MUSCLE_MASS_TRUNK("body_muscle_trunk"),

		/** The Constant PHYSIC_RATING. */
		PHYSIC_RATING("physic_rating"),

		/** The Constant DAILY_CALORIC_INTAKE. */
		DAILY_CALORIC_INTAKE("daily_caloric_intake"),

		/** The Constant DAILY_METABOLIC_AGE. */
		DAILY_METABOLIC_AGE("metabolic_age"),

		/** The Constant BODY_WATER_PERCENTAGE. */
		BODY_WATER_PERCENTAGE("body_water_percentage"),

		/** The Constant VISCERAL_FAT. */
		VISCERAL_FAT("visceral_fat"),

		/** The Constant BONE_MASS. */
		BONE_MASS("bone_mass");
		
		/** The name. */
		private final String name;

		/**
		 * Instantiates a new Column. info.
		 * 
		 * @param name
		 *            the name
		 * @param Column.
		 *            the Column.
		 */
		Column(String name) {
			this.name = name;
		}

		/** {@inheritDoc} */
		@Override
		public String toString() {
			return name;
		}
	}

	/** Database creation SQL statement. */
	static final String CREATE = getTanitaDataTable();

	/**
	 * Gets the Tanita data table.
	 * 
	 * @return the Tanita data table
	 */
	private static String getTanitaDataTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("create table ").append(NAME).append("( ");
		sql.append(Column.ID).append(" integer primary key autoincrement, ");
		sql.append(Column.PERSON).append(" integer not null, ");
		sql.append(Column.DATE).append(" integer, ");
		sql.append(Column.BODY_FAT_TOTAL).append(" integer, ");
		sql.append(Column.BODY_FAT_LEFT_ARM).append(" integer, ");
		sql.append(Column.BODY_FAT_RIGHT_ARM).append(" integer, ");
		sql.append(Column.BODY_FAT_RIGHT_LEFT).append(" integer, ");
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
		sql.append(Column.DAILY_METABOLIC_AGE).append(" integer, ");
		sql.append(Column.BODY_WATER_PERCENTAGE).append(" integer, ");
		sql.append(Column.VISCERAL_FAT).append(" integer, ");
		sql.append(Column.BONE_MASS).append(" integer");
		sql.append(");");
		String string = sql.toString();
		return string;
	}
}

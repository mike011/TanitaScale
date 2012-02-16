package ca.charland.tanita.db;

/**
 * The Class TanitaDataTable which holds the Tanita data related information.
 * 
 * @author mcharland
 */
public class TanitaDataTable {

	/** The name of the table. */
	static final String NAME = "tanita_data";

	/** The Constant COLUMN_ID. */
	public static final String COLUMN_ID = "_id";

	/** The Constant COLUMN_NAME. */
	public static final String COLUMN_PERSON = "person";

	/** The Constant COLUMN_DATE. */
	public static final String COLUMN_DATE = "date";

	/** The Constant COLUMN_BODY_FAT_TOTAL. */
	static final String COLUMN_BODY_FAT_TOTAL = "body_fat_total";

	/** The Constant COLUMN_BODY_FAT_LEFT_ARM. */
	static final String COLUMN_BODY_FAT_LEFT_ARM = "body_fat_left_arm";

	/** The Constant COLUMN_BODY_FAT_RIGHT_ARM. */
	static final String COLUMN_BODY_FAT_RIGHT_ARM = "body_fat_right_arm";

	/** The Constant COLUMN_BODY_FAT_RIGHT_LEFT. */
	static final String COLUMN_BODY_FAT_RIGHT_LEFT = "body_fat_right_leg";

	/** The Constant COLUMN_BODY_FAT_LEFT_LEG. */
	static final String COLUMN_BODY_FAT_LEFT_LEG = "body_fat_left_leg";

	/** The Constant COLUMN_BODY_FAT_TRUNK. */
	static final String COLUMN_BODY_FAT_TRUNK = "body_fat_trunk";

	/** The Constant COLUMN_MUSCLE_MASS_TOTAL. */
	static final String COLUMN_MUSCLE_MASS_TOTAL = "body_muscle_mass_total";

	/** The Constant COLUMN_MUSCLE_MASS_LEFT_ARM. */
	static final String COLUMN_MUSCLE_MASS_LEFT_ARM = "body_muscle_mass_left_arm";

	/** The Constant COLUMN_MUSCLE_MASS_RIGHT_ARM. */
	static final String COLUMN_MUSCLE_MASS_RIGHT_ARM = "body_muscle_mass_right_arm";

	/** The Constant COLUMN_MUSCLE_MASS_RIGHT_LEG. */
	static final String COLUMN_MUSCLE_MASS_RIGHT_LEG = "body_muscle_mass_right_leg";

	/** The Constant COLUMN_MUSCLE_MASS_LEFT_LEG. */
	static final String COLUMN_MUSCLE_MASS_LEFT_LEG = "body_muscle_mass_left_leg";

	/** The Constant COLUMN_MUSCLE_MASS_TRUNK. */
	static final String COLUMN_MUSCLE_MASS_TRUNK = "body_muscle_trunk";

	/** The Constant COLUMN_PHYSIC_RATING. */
	static final String COLUMN_PHYSIC_RATING = "physic_rating";

	/** The Constant COLUMN_WEIGHT. */
	static final String COLUMN_WEIGHT = "weight";

	/** The Constant COLUMN_DAILY_CALORIC_INTAKE. */
	static final String COLUMN_DAILY_CALORIC_INTAKE = "daily_caloric_intake";

	/** The Constant COLUMN_DAILY_METABOLIC_AGE. */
	static final String COLUMN_DAILY_METABOLIC_AGE = "metabolic_age";

	/** The Constant COLUMN_BODY_WATER_PERCENTAGE. */
	static final String COLUMN_BODY_WATER_PERCENTAGE = "body_water_percentage";

	/** The Constant COLUMN_VISCERAL_FAT. */
	static final String COLUMN_VISCERAL_FAT = "visceral_fat";

	/** The Constant COLUMN_BONE_MASS. */
	static final String COLUMN_BONE_MASS = "bone_mass";

	/** Database creation SQL statement */
	static final String CREATE = getTanitaDataTable();

	/**
	 * Gets the Tanita data table.
	 * 
	 * @return the Tanita data table
	 */
	private static String getTanitaDataTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("create table ").append(NAME);
		sql.append("( ").append(COLUMN_ID).append(" integer primary key autoincrement, ");
		sql.append(COLUMN_PERSON).append(" integer not null, ");
		sql.append(COLUMN_DATE).append(" integer, ");
		sql.append(COLUMN_BODY_FAT_TOTAL).append(" integer, ");
		sql.append(COLUMN_BODY_FAT_LEFT_ARM).append(" integer, ");
		sql.append(COLUMN_BODY_FAT_RIGHT_ARM).append(" integer, ");
		sql.append(COLUMN_BODY_FAT_RIGHT_LEFT).append(" integer, ");
		sql.append(COLUMN_BODY_FAT_LEFT_LEG).append(" integer, ");
		sql.append(COLUMN_BODY_FAT_TRUNK).append(" integer, ");
		sql.append(COLUMN_MUSCLE_MASS_TOTAL).append(" integer, ");
		sql.append(COLUMN_MUSCLE_MASS_LEFT_ARM).append(" integer, ");
		sql.append(COLUMN_MUSCLE_MASS_RIGHT_ARM).append(" integer, ");
		sql.append(COLUMN_MUSCLE_MASS_RIGHT_LEG).append(" integer, ");
		sql.append(COLUMN_MUSCLE_MASS_LEFT_LEG).append(" integer, ");
		sql.append(COLUMN_MUSCLE_MASS_TRUNK).append(" integer, ");
		sql.append(COLUMN_PHYSIC_RATING).append(" integer, ");
		sql.append(COLUMN_WEIGHT).append(" integer, ");
		sql.append(COLUMN_DAILY_CALORIC_INTAKE).append(" integer, ");
		sql.append(COLUMN_DAILY_METABOLIC_AGE).append(" integer, ");
		sql.append(COLUMN_BODY_WATER_PERCENTAGE).append(" integer, ");
		sql.append(COLUMN_VISCERAL_FAT).append(" integer, ");
		sql.append(COLUMN_BONE_MASS).append(" integer");
		sql.append(");");
		String string = sql.toString();
		return string;
	}
}

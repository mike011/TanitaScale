package ca.charland.tanita.db;

/**
 * The Class PeopleTable which holds all the table related info.
 */
public class PeopleTable {

	/** The Constant TABLE_PEOPLE. */
	static final String TABLE = "person";

	/** The Constant COLUMN_ID. */
	static final String COLUMN_ID = "_id";

	/** The Constant COLUMN_NAME. */
	static final String COLUMN_NAME = "name";

	/** Database creation SQL statement for the people table. */
	static final String CREATE = getPeopleTable();

	/**
	 * Gets the people table.
	 * 
	 * @return the people table
	 */
	private static String getPeopleTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("create table ").append(TABLE);
		sql.append("( ").append(COLUMN_ID)
				.append(" integer primary key autoincrement, ");
		sql.append(COLUMN_NAME).append(" text not null);");
		String string = sql.toString();
		return string;
	}

}

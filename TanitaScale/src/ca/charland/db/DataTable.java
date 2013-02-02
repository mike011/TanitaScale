package ca.charland.db;

public abstract class DataTable {

	public static final String TABLE_NAME = "tanita_data";

	public static final String ID_COLUMN_NAME = "_id";
	public static final String DATE_COLUMN_NAME = "date";
	public static final String PERSON_COLUMN_NAME = "person";

	/**
	 * Contains the column names and there index based off of the ordering they are defined.
	 * 
	 * @author mcharland
	 */
	public static enum Column {

		/** The unique ID of the table. */
		ID(ID_COLUMN_NAME),

		PERSON(PERSON_COLUMN_NAME),

		DATE(DATE_COLUMN_NAME);

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
		sql.append(");");
		String string = sql.toString();
		return string;
	}
}

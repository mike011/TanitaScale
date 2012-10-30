package ca.charland.tanita.db;

/**
 * The Class PeopleTable which holds all the table related info.
 * 
 * @author mcharland
 * 
 */
public class PersonDataTable {

	/** The Constant TABLE_PEOPLE. */
	static final String TABLE = "person";
	
	/**
	 * The columns in the Person Data Tab.e
	 * 
	 * @author mcharland
	 *
	 */
	public static enum Column {
		
		/** The Constant ID. */
		ID("_id"),
		
		/** The Constant NAME. */
		NAME("name"),
		
		/** The Constant EMAIL. */
		EMAIL("email"), 
		
		SEX("sex");
		
		/** The name. */
		private final String name;

		/**
		 * Instantiates a new Column. info.
		 * 
		 * @param name
		 *            the name
		 * @param Column
		 *            . the Column.
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
		sql.append("( ").append(Column.ID).append(" integer primary key autoincrement, ");
		sql.append(Column.NAME).append(" text not null, ");
		sql.append(Column.EMAIL).append(" text not null, ");
		sql.append(Column.SEX).append(" text not null);");
		String string = sql.toString();
		return string;
	}

}

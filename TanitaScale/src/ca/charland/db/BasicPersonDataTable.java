package ca.charland.db;

/**
 * Holds all the table related info for the person.
 * 
 * @author mcharland
 * 
 */
public class BasicPersonDataTable {

	static final String TABLE_NAME = "person";
	
	public static enum Column {
		
		ID("_id"),
		
		NAME("name");

		private final String name;

		Column(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	static final String CREATE_PEOPLE_TABLE = getPeopleTable();

	private static String getPeopleTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("create table ").append(TABLE_NAME);
		sql.append("( ").append(Column.ID).append(" integer primary key autoincrement, ");
		sql.append(Column.NAME).append(" text not null);");
		String string = sql.toString();
		return string;
	}

}

package ca.charland.db;

/**
 * Holds all the table related info for the person.
 * 
 * @author mcharland
 * 
 */
public class BasicPersonDataTable {

	public static final String TABLE_NAME = "person";
	public static final String ID_COLUMN_NAME = DataTable.ID_COLUMN_NAME;
	public static final String NAME_COLUMN_NAME = "name";
	
	public static enum Column {
		
		ID(ID_COLUMN_NAME),
		
		NAME(NAME_COLUMN_NAME);

		private final String name;

		Column(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	public static final String CREATE_PEOPLE_TABLE = getPeopleTable();

	private static String getPeopleTable() {
		StringBuilder sql = new StringBuilder();
		sql.append("create table ").append(TABLE_NAME);
		sql.append("( ").append(Column.ID).append(" integer primary key autoincrement, ");
		sql.append(Column.NAME).append(" text not null);");
		String string = sql.toString();
		return string;
	}

}

package ca.charland.tanita.db;

import java.util.List;

import ca.charland.db.Data;

public class PersonDataHelper {

	public static String getSex(PersonDataSource datasource, int id) {
		datasource.openDatabaseConnection();
		String sex = getSexFromDataSource(datasource, id);
		datasource.closeDatabaseConnection();
		return sex;
	}

	private static String getSexFromDataSource(PersonDataSource datasource, int id) {
		List<Data> data = datasource.query(PersonDataHelper.getSelection(id));
		String sex = "male";
		if (data != null && !data.isEmpty()) {
			PersonData pd = (PersonData) data.get(0);
			sex = pd.getSex();
		}
		return sex;
	}

	private static String getSelection(int id) {
		return PersonDataTable.Column.ID.toString() + " = " + id;
	}
}

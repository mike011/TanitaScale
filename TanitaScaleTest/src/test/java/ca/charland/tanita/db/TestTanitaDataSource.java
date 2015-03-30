package ca.charland.tanita.db;


public class TestTanitaDataSource extends TanitaDataSource {

	public TestTanitaDataSource() {
		super(new TestDatabaseHelper(null, null, null, null));
	}

}

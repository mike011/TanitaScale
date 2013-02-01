package ca.charland.tanita.manage;

import ca.charland.activity.manage.SingleDateValuesEnteredActivity;
import ca.charland.tanita.db.TanitaData;

/**
 * Does not use the database.
 * 
 * @author mcharland
 * 
 */
public class PersonDateActivityNoDatabase extends SingleDateValuesEnteredActivity {

	private final TanitaData tanitaData;

	public PersonDateActivityNoDatabase() {
		tanitaData = new TanitaData();
	}

	@Override
	protected TanitaData getTanitaData() {
		return tanitaData;
	}
	
}

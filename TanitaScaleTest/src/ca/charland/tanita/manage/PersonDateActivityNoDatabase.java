package ca.charland.tanita.manage;

import ca.charland.tanita.db.TanitaData;

/**
 * This edition of PersonDateActivity does not use the database.
 * 
 * @author mcharland
 * 
 */
public class PersonDateActivityNoDatabase extends PersonDateActivity {

	/** The Tanita data. */
	private final TanitaData tanitaData;

	/**
	 * Instantiates a new my person date activity.
	 */
	public PersonDateActivityNoDatabase() {
		tanitaData = new TanitaData();
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaData getTanitaData() {
		return tanitaData;
	}
	
}

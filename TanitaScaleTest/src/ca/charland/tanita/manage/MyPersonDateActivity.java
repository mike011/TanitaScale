package ca.charland.tanita.manage;

import ca.charland.tanita.db.TanitaData;

/**
 * This edition of PersonDateActivity does not use the database.
 * 
 * @author mcharland
 * 
 */
public class MyPersonDateActivity extends PersonDateActivity {

	/** The tanita data. */
	private final TanitaData tanitaData;

	/**
	 * Instantiates a new my person date activity.
	 */
	public MyPersonDateActivity() {
		tanitaData = new TanitaData();
	}

	/** {@inheritDoc} */
	@Override
	protected TanitaData getTanitaData() {
		return tanitaData;
	}
	
}

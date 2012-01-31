package ca.charland.tanita.db;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Database that acts like a db.
 * 
 * @author mcharland
 */
public class Database {
	
	/**
	 * Gets the people.
	 *
	 * @return the people
	 */
	public static final List<String> getPeople() {
		List<String> peeps = new ArrayList<String>();
		peeps.add("Laura");
		peeps.add("Michael");
		return peeps;
	}

}

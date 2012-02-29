package ca.charland.tanita.db;

/**
 * Base class for table data representations.
 * 
 * @author mcharland
 * 
 */
public class AbstractData {

	/** The id. */
	private int id;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

}

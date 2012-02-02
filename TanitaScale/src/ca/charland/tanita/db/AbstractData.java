package ca.charland.tanita.db;

/**
 * Base class for table data representations.
 * 
 * @author mcharland
 * 
 */
public class AbstractData {

	/** The id. */
	private long id;
	
	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

}

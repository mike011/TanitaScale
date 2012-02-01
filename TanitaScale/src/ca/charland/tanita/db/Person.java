package ca.charland.tanita.db;

/**
 * The Class Names which is the table name.
 * 
 * @author mcharland
 */
public class Person {

	/** The id. */
	private long id;

	/** The name. */
	private String name;

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

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	// Will be used by the ArrayAdapter in the ListView
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return name;
	}
}

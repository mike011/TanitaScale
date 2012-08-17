package ca.charland.tanita.db;

/**
 * The Class Person which is the table name for an individual person.
 * 
 * @author mcharland
 */
public class PersonData extends AbstractData {

	/** The name. */
	private String name;

	/** This needs to be set somewhere!!!! in the GUI that is. */
	private String email;

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

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;

	}

	// Will be used by the ArrayAdapter in the ListView
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return name;
	}

}

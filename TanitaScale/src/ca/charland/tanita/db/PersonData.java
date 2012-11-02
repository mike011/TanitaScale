package ca.charland.tanita.db;

/**
 * Table name for an individual person.
 * 
 * @author mcharland
 */
public class PersonData extends Data {

	private String name;

	private String email;

	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
		
	}

	// Will be used by the ArrayAdapter in the ListView
	@Override
	public String toString() {
		return name;
	}

	public String getSex() {
		return sex;
	}

}

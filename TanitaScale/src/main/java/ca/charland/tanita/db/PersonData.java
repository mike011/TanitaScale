package ca.charland.tanita.db;

import ca.charland.db.BasicPersonData;

/**
 * Table name for an individual person.
 * 
 * @author mcharland
 */
public class PersonData extends BasicPersonData {

	private String email;

	private String sex;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return sex;
	}

}

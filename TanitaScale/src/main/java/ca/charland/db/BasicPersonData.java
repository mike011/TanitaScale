package ca.charland.db;

public class BasicPersonData extends Data {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// Will be used by the ArrayAdapter in the ListView
	@Override
	public String toString() {
		return name;
	}
}

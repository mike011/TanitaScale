package ca.charland.tanita.base.db;

public class ContentValuesKeyValuePair {

	private final String key;
	private final String value;

	public ContentValuesKeyValuePair(String key, String value) {
		this.key = key;
		this.value = value;
		
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
}

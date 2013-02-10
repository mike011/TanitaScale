package ca.charland.tanitascale;

public class ColumnNotFoundException extends RuntimeException {

	public ColumnNotFoundException(String value) {
		super(value);
	}

	private static final long serialVersionUID = 1283730985996321727L;

}

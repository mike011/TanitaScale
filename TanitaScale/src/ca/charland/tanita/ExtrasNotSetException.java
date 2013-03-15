package ca.charland.tanita;

public class ExtrasNotSetException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ExtrasNotSetException(String string) {
		super(string);
	}
}

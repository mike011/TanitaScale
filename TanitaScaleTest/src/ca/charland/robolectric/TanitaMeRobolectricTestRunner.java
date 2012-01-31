package ca.charland.robolectric;

import java.io.File;

import org.junit.runners.model.InitializationError;

import com.xtremelabs.robolectric.RobolectricTestRunner;

/**
 * Custom runner to redirect to the development folder. Specifically so the res and manifest can be found.
 * 
 * @author mcharland
 * 
 */
public class TanitaMeRobolectricTestRunner extends RobolectricTestRunner {

	/**
	 * Creates a new runner.
	 * 
	 * @param testClass
	 *            The class to test.
	 * @throws InitializationError
	 *             Represents one or more problems encountered while initialising a Runner.
	 */
	public TanitaMeRobolectricTestRunner(Class<?> testClass) throws InitializationError {
		super(testClass, new File("../TanitaScale"));
	}
}

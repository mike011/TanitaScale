package ca.charland.robolectric;

import java.io.File;

import org.junit.runners.model.InitializationError;

/**
 * Custom runner to redirect to the development folder. Specifically so the res and manifest can be found.
 * 
 * @author mcharland
 * 
 */
public class TanitaRobolectricTestRunner extends BaseRobolectricTestRunner {

	public TanitaRobolectricTestRunner(Class<?> testClass) throws InitializationError {
		super(testClass, ".." + File.separator + "TanitaScale");
	}
}

package ca.charland.robolectric;

import java.io.File;

import org.junit.runners.model.InitializationError;

import roboguice.inject.ContextScope;

import com.google.inject.Injector;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;

import roboguice.application.RoboApplication;
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

    @Override public void prepareTest(Object test) {
       RoboApplication application = (RoboApplication) Robolectric.application;

        //This project's application does not extend GuiceInjectableApplication therefore we need to enter the ContextScope manually.
        Injector injector = application.getInjector();
        ContextScope scope = injector.getInstance(ContextScope.class);
        scope.enter(application);

        injector.injectMembers(test);
    }
}

package ca.charland.robolectric;

import java.io.File;

import org.junit.runners.model.InitializationError;

import roboguice.application.RoboApplication;
import roboguice.inject.ContextScope;

import com.google.inject.Injector;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowResources;

/**
 * Custom runner to redirect to the development folder. Specifically so the res and manifest can be found.
 * 
 * @author mcharland
 * 
 */
public class TanitaMeRobolectricTestRunner extends RobolectricTestRunner {

	private static final String APPLICATION_LOCATION = "../TanitaScale";

	public TanitaMeRobolectricTestRunner(Class<?> testClass) throws InitializationError {
		super(testClass, new File(APPLICATION_LOCATION));
	}

	@Override
	public void prepareTest(Object test) {
		RoboApplication application = (RoboApplication) Robolectric.application;

		// This project's application does not extend GuiceInjectableApplication therefore we need to enter the ContextScope manually.
		Injector injector = application.getInjector();
		ContextScope scope = injector.getInstance(ContextScope.class);
		scope.enter(application);

		injector.injectMembers(test);
	}

	@Override
	protected void bindShadowClasses() {
		Robolectric.bindShadowClass(ShadowResources.class);
	}
}

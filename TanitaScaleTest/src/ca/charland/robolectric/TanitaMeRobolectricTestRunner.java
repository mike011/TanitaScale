package ca.charland.robolectric;

import java.io.File;

import org.junit.runners.model.InitializationError;

import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;
import android.content.Context;

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

	private Injector injector;

	public TanitaMeRobolectricTestRunner(Class<?> testClass) throws InitializationError {
		super(testClass, new File(APPLICATION_LOCATION));
	}

	@Override
	public void prepareTest(Object test) {
		Context context = new RoboActivity();
		this.injector = RoboGuice.getInjector(context);
		this.injector.injectMembers(test);
	}

	@Override
	protected void bindShadowClasses() {
		Robolectric.bindShadowClass(ShadowResources.class);
	}
}

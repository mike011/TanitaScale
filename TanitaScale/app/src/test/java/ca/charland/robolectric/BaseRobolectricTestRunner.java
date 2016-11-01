package ca.charland.robolectric;

import android.content.Context;

import com.google.inject.Injector;

import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;

import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;

/**
 * Custom runner to redirect to the development folder. Specifically so the res and manifest can be found.
 *
 * @author mcharland
 */
public class BaseRobolectricTestRunner extends RobolectricTestRunner
{

    private Injector injector;

    public BaseRobolectricTestRunner(Class<?> testClass) throws InitializationError
    {
        super(testClass);
        //this(testClass, ".." + File.separator + "TanitaScale");
    }

    //public BaseRobolectricTestRunner(Class<?> testClass, String configFile) throws InitializationError
    //{
    // super(testClass, new File(configFile));
    //}

    //@Override
    public void prepareTest(Object test)
    {
        Context context = new RoboActivity();
        this.injector = RoboGuice.getInjector(context);
        this.injector.injectMembers(test);
    }

    //@Override
    //protected void bindShadowClasses()
    //{
    // Robolectric.bindShadowClass(ShadowResources.class);
    // }
/*
    public static View getViewFromShadowActivity(Activity activity, int id)
    {
       // ShadowActivity shadowA = Robolectric.shadowOf(activity);
      //  View next = (View) shadowA.findViewById(id);
       // return next;
    }*/
}

package ca.charland.tanita;

import android.content.Intent;

import com.google.inject.Inject;
import com.google.inject.Stage;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.db.TestTanitaDataSource;
import roboguice.RoboGuice;
import roboguice.inject.InjectResource;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author mcharland
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class BodyFatLeftArmActivityTest
{

    private static class ActivityUnderTest extends BodyFatLeftArmActivity
    {

        @Override
        protected void setSex(int id, int female)
        {
        }

        @Override
        protected TanitaDataSource getDataSource()
        {
            return new TestTanitaDataSource();
        }

        @Override
        protected void setData()
        {
        }
    }

    private ActivityUnderTest activity;

    public static class ModuleA extends com.google.inject.AbstractModule
    {
        @Override
        protected void configure()
        {
            requestStaticInjection(A.class);
        }

        public static class A
        {
            @InjectResource(android.R.string.cancel)
            static String s;
            @Inject
            static String t;
        }
    }

    @Before
    public void setup()
    {
        RoboGuice.getOrCreateBaseApplicationInjector(RuntimeEnvironment.application, Stage.DEVELOPMENT, RoboGuice.newDefaultRoboModule(RuntimeEnvironment.application), new ModuleA());
        activity = Robolectric.buildActivity(ActivityUnderTest.class).withIntent(new Intent(RuntimeEnvironment.application, ActivityUnderTest.class).putExtra("foobar", "goober")).create().get();
    }

    @Test
    public void testGetLayoutResID()
    {
        ActivityUnderTest activity = Robolectric.setupActivity(ActivityUnderTest.class);
        assertThat(activity.getResourceIDForLayout(), is(R.layout.body_fat_left_arm));
    }

    @Test
    public void testGetColumnName()
    {
        assertThat(activity.getColumnName(), is(TanitaDataTable.Column.BODY_FAT_LEFT_ARM));
    }

    @Test
    public void testGetNextClass()
    {
        assertThat(activity.getNextClass().toString(), is(BodyFatRightArmActivity.class.toString()));
    }
}

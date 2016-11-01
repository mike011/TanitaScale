package ca.charland.tanita;

import android.app.Activity;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import ca.charland.tanita.base.activity.BaseActivity;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author mcharland
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class BaseActivityTest
{
    private TextView next;

    @Before
    public void setUp()
    {
        Activity activity = Robolectric.setupActivity(BaseActivity.class);
        next = (TextView) activity.findViewById(R.id.next);
    }

    @Ignore
    @Test
    public void testOnCreateBundle()
    {
        assertThat("Button not created", next, is(notNullValue()));
    }

}

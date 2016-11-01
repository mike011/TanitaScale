package ca.charland.tanita.manage;

import android.widget.TextView;

import com.google.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import ca.charland.robolectric.TanitaRobolectricTestRunner;
import ca.charland.tanita.R;
import ca.charland.tanita.db.TanitaData;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author mcharland
 */
@RunWith(TanitaRobolectricTestRunner.class)
public class PersonDateActivityTest
{

    @Inject
    private PersonDateActivityNoDatabase activity;

    @Test
    public void testOnCreateWeight()
    {

        TanitaData td = activity.getTanitaData();
        td.setWeight(1234);

        activity.onCreate(null);

        TextView weight = (TextView) activity.findViewById(R.id.weight);
        assertThat(weight.getText().toString(), is("1234.0"));
    }

    @Test
    public void testOnCreateDCI()
    {

        TanitaData td = activity.getTanitaData();
        td.setDailyCaloricIntake(4019);

        activity.onCreate(null);

        TextView dci = (TextView) activity.findViewById(R.id.dci);
        assertThat(dci.getText().toString(), is("4019"));
    }

    @Test
    public void testOnCreateMetabolicAge()
    {

        TanitaData td = activity.getTanitaData();
        td.setMetabolicAge(18);

        activity.onCreate(null);

        TextView metabolicAge = (TextView) activity.findViewById(R.id.metabolic_age);
        assertThat(metabolicAge.getText().toString(), is("18"));
    }

    @Test
    public void testOnCreateBodyWaterPercentage()
    {

        TanitaData td = activity.getTanitaData();
        td.setBodyWaterPercentage(54);

        activity.onCreate(null);

        TextView bodyWaterPercentage = (TextView) activity.findViewById(R.id.body_water_percentage);
        assertThat(bodyWaterPercentage.getText().toString(), is("54.0"));
    }

    @Test
    public void testOnCreateVisceralFat()
    {

        TanitaData td = activity.getTanitaData();
        td.setVisceralFat(5);

        activity.onCreate(null);

        TextView visceralFat = (TextView) activity.findViewById(R.id.visceral_fat);
        assertThat(visceralFat.getText().toString(), is("5"));
    }

    @Test
    public void testOnCreateBoneMass()
    {

        TanitaData td = activity.getTanitaData();
        td.setBoneMass(8.3);

        activity.onCreate(null);

        TextView boneMass = (TextView) activity.findViewById(R.id.bone_mass);
        assertThat(boneMass.getText().toString(), is("8.3"));
    }

    @Test
    public void testOnCreateBodyFatTotal()
    {

        TanitaData td = activity.getTanitaData();
        td.setBodyFatTotal(16.3);

        activity.onCreate(null);

        TextView bodyFatTotal = (TextView) activity.findViewById(R.id.body_fat_total);
        assertThat(bodyFatTotal.getText().toString(), is("16.3"));
    }

    @Test
    public void testOnCreateBodyFatLeftArm()
    {

        TanitaData td = activity.getTanitaData();
        td.setBodyFatLeftArm(16.1);

        activity.onCreate(null);

        TextView bodyfatArmLeft = (TextView) activity.findViewById(R.id.body_fat_arm_left);
        assertThat(bodyfatArmLeft.getText().toString(), is("16.1"));
    }

    @Test
    public void testOnCreateBodyFatRightArm()
    {

        TanitaData td = activity.getTanitaData();
        td.setBodyFatRightArm(4.3);

        activity.onCreate(null);

        TextView bodyFatArmRight = (TextView) activity.findViewById(R.id.body_fat_arm_right);
        assertThat(bodyFatArmRight.getText().toString(), is("4.3"));
    }

    @Test
    public void testOnCreateBodyFatLeftLeg()
    {

        TanitaData td = activity.getTanitaData();
        td.setBodyFatLeftLeg(3.9);

        activity.onCreate(null);

        TextView bodyFatLegLeft = (TextView) activity.findViewById(R.id.body_fat_leg_left);
        assertThat(bodyFatLegLeft.getText().toString(), is("3.9"));
    }

    @Test
    public void testOnCreateBodyFatRightLeg()
    {

        TanitaData td = activity.getTanitaData();
        td.setBodyFatRightLeg(9.2);

        activity.onCreate(null);

        TextView bodyFatLegRight = (TextView) activity.findViewById(R.id.body_fat_leg_right);
        assertThat(bodyFatLegRight.getText().toString(), is("9.2"));
    }

    @Test
    public void testOnCreateBodyFatTrunk()
    {

        TanitaData td = activity.getTanitaData();
        td.setBodyFatTrunk(19.2);

        activity.onCreate(null);

        TextView bodyFatTrunk = (TextView) activity.findViewById(R.id.body_fat_trunk);
        assertThat(bodyFatTrunk.getText().toString(), is("19.2"));
    }

    @Test
    public void testOnCreateMuscleMassTotal()
    {

        TanitaData td = activity.getTanitaData();
        td.setMuscleMassTotal(123.3);

        activity.onCreate(null);

        TextView muscleMassTotal = (TextView) activity.findViewById(R.id.muscle_mass_total);
        assertThat(muscleMassTotal.getText().toString(), is("123.3"));
    }

    @Test
    public void testOnCreateMuscleMassLeftArm()
    {

        TanitaData td = activity.getTanitaData();
        td.setMuscleMassLeftArm(8.2);

        activity.onCreate(null);

        TextView muscleMassArmLeft = (TextView) activity.findViewById(R.id.muscle_mass_arm_left);
        assertThat(muscleMassArmLeft.getText().toString(), is("8.2"));
    }

    @Test
    public void testOnCreateMuscleMassRightArm()
    {

        TanitaData td = activity.getTanitaData();
        td.setMuscleMassRightArm(8.1);

        activity.onCreate(null);

        TextView muscleMassArmRight = (TextView) activity.findViewById(R.id.muscle_mass_arm_right);
        assertThat(muscleMassArmRight.getText().toString(), is("8.1"));
    }

    @Test
    public void testOnCreateMuscleMassLeftLeg()
    {

        TanitaData td = activity.getTanitaData();
        td.setMuscleMassLeftLeg(15.3);

        activity.onCreate(null);

        TextView muscleMassLegLeft = (TextView) activity.findViewById(R.id.muscle_mass_leg_left);
        assertThat(muscleMassLegLeft.getText().toString(), is("15.3"));
    }

    @Test
    public void testOnCreateMuscleMassRightLeg()
    {

        TanitaData td = activity.getTanitaData();
        td.setMuscleMassRightLeg(26.7);

        activity.onCreate(null);

        TextView muscleMassLegRight = (TextView) activity.findViewById(R.id.muscle_mass_leg_right);
        assertThat(muscleMassLegRight.getText().toString(), is("26.7"));
    }

    @Test
    public void testOnCreateMuscleMassTrunk()
    {

        TanitaData td = activity.getTanitaData();
        td.setMuscleMassTrunk(89.9);

        activity.onCreate(null);

        TextView muscleMassTrunk = (TextView) activity.findViewById(R.id.muscle_mass_trunk);
        assertThat(muscleMassTrunk.getText().toString(), is("89.9"));
    }

    @Test
    public void testOnCreatePhysicRating()
    {

        TanitaData td = activity.getTanitaData();
        td.setPhysicRating(3);

        activity.onCreate(null);

        TextView physicRating = (TextView) activity.findViewById(R.id.physic_rating);
        assertThat(physicRating.getText().toString(), is("3"));
    }
}

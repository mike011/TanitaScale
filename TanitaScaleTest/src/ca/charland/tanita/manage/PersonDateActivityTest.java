package ca.charland.tanita.manage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.widget.TextView;
import ca.charland.R;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.db.TanitaData;

import com.google.inject.Inject;

/**
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class PersonDateActivityTest {

	@Inject
	private PersonDateActivityNoDatabase activity;
	
	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateWeight() {

		TanitaData td = activity.getTanitaData();
		td.setWeight(1234);

		activity.onCreate(null);
		
		TextView weight = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.weight);
		assertEquals("1234.0", weight.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateDCI() {

		TanitaData td = activity.getTanitaData();
		td.setDailyCaloricIntake(4019);

		activity.onCreate(null);

		TextView dci = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.dci);
		assertEquals("4019", dci.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateMetabolicAge() {

		TanitaData td = activity.getTanitaData();
		td.setMetabolicAge(18);

		activity.onCreate(null);

		TextView metabolicAge = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.metabolic_age);
		assertEquals("18", metabolicAge.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBodyWaterPercentage() {
		
		TanitaData td = activity.getTanitaData();
		td.setBodyWaterPercentage(54);

		activity.onCreate(null);
		
		TextView bodyWaterPercentage = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.body_water_percentage);
		assertEquals("54.0", bodyWaterPercentage.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateVisceralFat() {

		TanitaData td = activity.getTanitaData();
		td.setVisceralFat(5);

		activity.onCreate(null);

		TextView visceralFat = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.visceral_fat);
		assertEquals("5", visceralFat.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBoneMass() {

		TanitaData td = activity.getTanitaData();
		td.setBoneMass(8.3);

		activity.onCreate(null);

		TextView boneMass = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.bone_mass);
		assertEquals("8.3", boneMass.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBodyFatTotal() {

		TanitaData td = activity.getTanitaData();
		td.setBodyFatTotal(16.3);

		activity.onCreate(null);

		TextView bodyFatTotal = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.body_fat_total);
		assertEquals("16.3", bodyFatTotal.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBodyFatLeftArm() {

		TanitaData td = activity.getTanitaData();
		td.setBodyFatLeftArm(16.1);

		activity.onCreate(null);

		TextView bodyfatArmLeft = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.body_fat_arm_left);
		assertEquals("16.1", bodyfatArmLeft.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBodyFatRightArm() {

		TanitaData td = activity.getTanitaData();
		td.setBodyFatRightArm(4.3);

		activity.onCreate(null);

		TextView bodyFatArmRight = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.body_fat_arm_right);
		assertEquals("4.3", bodyFatArmRight.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBodyFatLeftLeg() {

		TanitaData td = activity.getTanitaData();
		td.setBodyFatLeftLeg(3.9);

		activity.onCreate(null);

		TextView bodyFatLegLeft = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.body_fat_leg_left);
		assertEquals("3.9", bodyFatLegLeft.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBodyFatRightLeg() {

		TanitaData td = activity.getTanitaData();
		td.setBodyFatRightLeg(9.2);

		activity.onCreate(null);

		TextView bodyFatLegRight = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.body_fat_leg_right);
		assertEquals("9.2", bodyFatLegRight.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBodyFatTrunk() {

		TanitaData td = activity.getTanitaData();
		td.setBodyFatTrunk(19.2);

		activity.onCreate(null);

		TextView bodyFatTrunk = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.body_fat_trunk);
		assertEquals("19.2", bodyFatTrunk.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateMuscleMassTotal() {

		TanitaData td = activity.getTanitaData();
		td.setMuscleMassTotal(123.3);

		activity.onCreate(null);

		TextView muscleMassTotal = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.muscle_mass_total);
		assertEquals("123.3", muscleMassTotal.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateMuscleMassLeftArm() {

		TanitaData td = activity.getTanitaData();
		td.setMuscleMassLeftArm(8.2);

		activity.onCreate(null);

		TextView muscleMassArmLeft = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.muscle_mass_arm_left);
		assertEquals("8.2", muscleMassArmLeft.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateMuscleMassRightArm() {

		TanitaData td = activity.getTanitaData();
		td.setMuscleMassRightArm(8.1);

		activity.onCreate(null);

		TextView muscleMassArmRight = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.muscle_mass_arm_right);
		assertEquals("8.1", muscleMassArmRight.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateMuscleMassLeftLeg() {

		TanitaData td = activity.getTanitaData();
		td.setMuscleMassLeftLeg(15.3);

		activity.onCreate(null);

		TextView muscleMassLegLeft = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.muscle_mass_leg_left);
		assertEquals("15.3", muscleMassLegLeft.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateMuscleMassRightLeg() {

		TanitaData td = activity.getTanitaData();
		td.setMuscleMassRightLeg(26.7);

		activity.onCreate(null);

		TextView muscleMassLegRight = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.muscle_mass_leg_right);
		assertEquals("26.7", muscleMassLegRight.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateMuscleMassTrunk() {

		TanitaData td = activity.getTanitaData();
		td.setMuscleMassTrunk(89.9);

		activity.onCreate(null);

		TextView muscleMassTrunk = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.muscle_mass_trunk);
		assertEquals("89.9", muscleMassTrunk.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.SingleDateValuesEnteredActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreatePhysicRating() {

		TanitaData td = activity.getTanitaData();
		td.setPhysicRating(3);

		activity.onCreate(null);

		TextView physicRating = (TextView)TanitaMeRobolectricTestRunner.getViewFromShadowActivity(activity, R.id.physic_rating);
		assertEquals("3", physicRating.getText().toString());
	}
}

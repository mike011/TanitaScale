package ca.charland.tanita.manage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import roboguice.inject.InjectView;
import android.widget.TextView;
import ca.charland.robolectric.TanitaMeRobolectricTestRunner;
import ca.charland.tanita.R;
import ca.charland.tanita.db.TanitaData;

import com.google.inject.Inject;

/**
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class PersonDateActivityTest {

	@InjectView(R.id.weight)
	private TextView weight;

	@InjectView(R.id.dci)
	private TextView dci;

	@InjectView(R.id.metabolic_age)
	private TextView metabolicAge;

	@InjectView(R.id.body_water_percentage)
	private TextView bodyWaterPercentage;

	@InjectView(R.id.visceral_fat)
	private TextView visceralFat;

	@InjectView(R.id.bone_mass)
	private TextView boneMass;

	@InjectView(R.id.body_fat_total)
	private TextView bodyFatTotal;

	@InjectView(R.id.body_fat_arm_left)
	private TextView bodyfatArmLeft;

	@InjectView(R.id.body_fat_arm_right)
	private TextView bodyFatArmRight;

	@InjectView(R.id.body_fat_leg_left)
	private TextView bodyFatLegLeft;

	@InjectView(R.id.body_fat_leg_right)
	private TextView bodyFatLegRight;

	@InjectView(R.id.body_fat_trunk)
	private TextView bodyFatTrunk;

	@InjectView(R.id.muscle_mass_total)
	private TextView muscleMassTotal;

	@InjectView(R.id.muscle_mass_arm_left)
	private TextView muscleMassArmLeft;

	@InjectView(R.id.muscle_mass_arm_right)
	private TextView muscleMassArmRight;

	@InjectView(R.id.muscle_mass_leg_right)
	private TextView muscleMassLegRight;

	@InjectView(R.id.muscle_mass_leg_left)
	private TextView muscleMassLegLeft;

	@InjectView(R.id.muscle_mass_trunk)
	private TextView muscleMassTrunk;

	@InjectView(R.id.physic_rating)
	private TextView physicRating;

	@Inject
	private PersonDateActivityNoDatabase activity;

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateWeight() {

		TanitaData td = activity.getTanitaData();
		td.setWeight(1234);

		activity.onCreate(null);

		assertEquals("1234.0", weight.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateDCI() {

		TanitaData td = activity.getTanitaData();
		td.setDailyCaloricIntake(4019);

		activity.onCreate(null);

		assertEquals("4019", dci.getText().toString());
	}
	
	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateMetabolicAge() {

		TanitaData td = activity.getTanitaData();
		td.setMetabolicAge(18);

		activity.onCreate(null);

		assertEquals("18", metabolicAge.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBodyWaterPercentage() {

		TanitaData td = activity.getTanitaData();
		td.setBodyWaterPercentage(54);

		activity.onCreate(null);

		assertEquals("54.0", bodyWaterPercentage.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateVisceralFat() {

		TanitaData td = activity.getTanitaData();
		td.setVisceralFat(5);

		activity.onCreate(null);

		assertEquals("5", visceralFat.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBoneMass() {

		TanitaData td = activity.getTanitaData();
		td.setBoneMass(8.3);

		activity.onCreate(null);

		assertEquals("8.3", boneMass.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBodyFatTotal() {

		TanitaData td = activity.getTanitaData();
		td.setBodyFatTotal(16.3);

		activity.onCreate(null);

		assertEquals("16.3", bodyFatTotal.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBodyFatLeftArm() {

		TanitaData td = activity.getTanitaData();
		td.setBodyFatLeftArm(16.1);

		activity.onCreate(null);

		assertEquals("16.1", bodyfatArmLeft.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBodyFatRightArm() {

		TanitaData td = activity.getTanitaData();
		td.setBodyFatRightArm(4.3);

		activity.onCreate(null);

		assertEquals("4.3", bodyFatArmRight.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBodyFatLeftLeg() {

		TanitaData td = activity.getTanitaData();
		td.setBodyFatLeftLeg(3.9);

		activity.onCreate(null);

		assertEquals("3.9", bodyFatLegLeft.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBodyFatRightLeg() {

		TanitaData td = activity.getTanitaData();
		td.setBodyFatRightLeg(9.2);

		activity.onCreate(null);

		assertEquals("9.2", bodyFatLegRight.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateBodyFatTrunk() {

		TanitaData td = activity.getTanitaData();
		td.setBodyFatTrunk(19.2);

		activity.onCreate(null);

		assertEquals("19.2", bodyFatTrunk.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateMuscleMassTotal() {

		TanitaData td = activity.getTanitaData();
		td.setMuscleMassTotal(123.3);

		activity.onCreate(null);

		assertEquals("123.3", muscleMassTotal.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateMuscleMassLeftArm() {

		TanitaData td = activity.getTanitaData();
		td.setMuscleMassLeftArm(8.2);

		activity.onCreate(null);

		assertEquals("8.2", muscleMassArmLeft.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateMuscleMassRightArm() {

		TanitaData td = activity.getTanitaData();
		td.setMuscleMassRightArm(8.1);

		activity.onCreate(null);

		assertEquals("8.1", muscleMassArmRight.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateMuscleMassLeftLeg() {

		TanitaData td = activity.getTanitaData();
		td.setMuscleMassLeftLeg(15.3);

		activity.onCreate(null);

		assertEquals("15.3", muscleMassLegLeft.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateMuscleMassRightLeg() {

		TanitaData td = activity.getTanitaData();
		td.setMuscleMassRightLeg(26.7);

		activity.onCreate(null);

		assertEquals("26.7", muscleMassLegRight.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreateMuscleMassTrunk() {

		TanitaData td = activity.getTanitaData();
		td.setMuscleMassTrunk(89.9);

		activity.onCreate(null);

		assertEquals("89.9", muscleMassTrunk.getText().toString());
	}

	/**
	 * Test method for {@link ca.charland.tanita.manage.PersonDateActivity#onCreate(android.os.Bundle)}.
	 */
	@Test
	public void testOnCreatePhysicRating() {

		TanitaData td = activity.getTanitaData();
		td.setPhysicRating(3);

		activity.onCreate(null);

		assertEquals("3", physicRating.getText().toString());
	}
}

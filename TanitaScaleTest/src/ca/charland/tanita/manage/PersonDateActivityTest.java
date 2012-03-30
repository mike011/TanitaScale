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
 * Testing PersonDateActivity.
 * 
 * @author mcharland
 * 
 */
@RunWith(TanitaMeRobolectricTestRunner.class)
public class PersonDateActivityTest {

	/** The weight. */
	@InjectView(R.id.weight)
	private TextView weight;

	/** The dci. */
	@InjectView(R.id.dci)
	private TextView dci;

	/** The metabolic age. */
	@InjectView(R.id.metabolic_age)
	private TextView metabolicAge;

	/** The body water percentage. */
	@InjectView(R.id.body_water_percentage)
	private TextView bodyWaterPercentage;

	/** The visceral fat. */
	@InjectView(R.id.visceral_fat)
	private TextView visceralFat;

	/** The bone mass. */
	@InjectView(R.id.bone_mass)
	private TextView boneMass;

	/** The body fat total. */
	@InjectView(R.id.body_fat_total)
	private TextView bodyFatTotal;

	/** The body fat arm left. */
	@InjectView(R.id.body_fat_arm_left)
	private TextView bodyfatArmLeft;

	/** The body fat arm right. */
	@InjectView(R.id.body_fat_arm_right)
	private TextView bodyFatArmRight;

	/** The body fat leg left. */
	@InjectView(R.id.body_fat_leg_left)
	private TextView bodyFatLegLeft;

	/** The body fat leg right. */
	@InjectView(R.id.body_fat_leg_right)
	private TextView bodyFatLegRight;

	/** The body fat trunk. */
	@InjectView(R.id.body_fat_trunk)
	private TextView bodyFatTrunk;

	/** The muscle mass total. */
	@InjectView(R.id.muscle_mass_total)
	private TextView muscleMassTotal;

	/** The muscle mass arm left. */
	@InjectView(R.id.muscle_mass_arm_left)
	private TextView muscleMassArmLeft;

	/** The muscle mass arm right. */
	@InjectView(R.id.muscle_mass_arm_right)
	private TextView muscleMassArmRight;

	/** The muscle mass leg right. */
	@InjectView(R.id.muscle_mass_leg_right)
	private TextView muscleMassLegRight;

	/** The muscle mass leg left. */
	@InjectView(R.id.muscle_mass_leg_left)
	private TextView muscleMassLegLeft;

	/** The muscle mass trunk. */
	@InjectView(R.id.muscle_mass_trunk)
	private TextView muscleMassTrunk;

	/** The physic rating. */
	@InjectView(R.id.physic_rating)
	private TextView physicRating;

	/** The class under test. */
	@Inject
	private MyPersonDateActivity activity;

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

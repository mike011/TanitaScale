package ca.charland.tanita.db;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class TanitaDataTest which holds the Tanita specific information for the
 * database.
 * 
 * @author mcharland
 */
public class TanitaDataTest {

	/** The data. */
	private TanitaData data;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		data = new TanitaData();
	}

	/**
	 * Test get and set id.
	 */
	@Test
	public void testId() {
		long id = 12345L;
		data.setId(id);
		assertEquals(id, data.getId());
	}

	/**
	 * Test get and set person.
	 */
	@Test
	public void testPerson() {
		long id = 12345L;
		data.setPerson(id);
		assertEquals(id, data.getPerson());
	}

	/**
	 * Test get date.
	 */
	@Test
	public void testGetDate() {
		Date d = new Date(11);
		data.setDate(d);
		assertEquals(d, data.getDate());
	}

	/**
	 * Test get and set body fat total.
	 */
	@Test
	public void testBodyFatTotal() {
		long bodyFat = 12345L;
		data.setBodyFatTotal(bodyFat);
		assertEquals(bodyFat, data.getBodyFatTotal());
	}

	/**
	 * Test get and set body fat left arm.
	 */
	@Test
	public void testBodyFatLeftArm() {
		long bodyFat = 12345L;
		data.setBodyFatLeftArm(bodyFat);
		assertEquals(bodyFat, data.getBodyFatLeftArm());
	}

	/**
	 * Test get and set body fat right arm.
	 */
	@Test
	public void testBodyFatRightArm() {
		long bodyFat = 12345L;
		data.setBodyFatRightArm(bodyFat);
		assertEquals(bodyFat, data.getBodyFatRightArm());
	}

	/**
	 * Test get and set body fat right leg.
	 */
	@Test
	public void testBodyFatRightLeg() {
		long bodyFat = 12345L;
		data.setBodyFatRightArm(bodyFat);
		assertEquals(bodyFat, data.getBodyFatRightArm());
	}

	/**
	 * Test get and set body fat left leg.
	 */
	@Test
	public void testBodyFatLeftLeg() {
		long bodyFat = 12345L;
		data.setBodyFatLeftLeg(bodyFat);
		assertEquals(bodyFat, data.getBodyFatLeftLeg());
	}

	/**
	 * Test get and set and set body fat trunk.
	 */
	@Test
	public void testBodyFatTrunk() {
		long bodyFat = 12345L;
		data.setBodyFatTrunk(bodyFat);
		assertEquals(bodyFat, data.getBodyFatTrunk());
	}

	/**
	 * Test get muscle mass total.
	 */
	@Test
	public void testMuscleMassTotal() {
		long muscle = 12345L;
		data.setMuscleMassTotal(muscle);
		assertEquals(muscle, data.getMuscleMassTotal());
	}

	/**
	 * Test get and set muscle mass left arm.
	 */
	@Test
	public void testMuscleMassLeftArm() {
		long muscle = 12345L;
		data.setMuscleMassLeftArm(muscle);
		assertEquals(muscle, data.getMuscleMassLeftArm());
	}

	/**
	 * Test get and set muscle mass right arm.
	 */
	@Test
	public void testMuscleMassRightArm() {
		long muscle = 12345L;
		data.setMuscleMassRightArm(muscle);
		assertEquals(muscle, data.getMuscleMassRightArm());
	}
	
	/**
	 * Test get and set muscle mass right leg.
	 */
	@Test
	public void testMuscleMassRightLeg() {
		long muscle = 12345L;
		data.setMuscleMassRightLeg(muscle);
		assertEquals(muscle, data.getMuscleMassRightLeg());
	}
	
	/**
	 * Test get and set muscle mass right leg.
	 */
	@Test
	public void testMuscleMassLeftLeg() {
		long muscle = 12345L;
		data.setMuscleMassLeftLeg(muscle);
		assertEquals(muscle, data.getMuscleMassLeftLeg());
	}
	
	/**
	 * Test get and set muscle mass trunk.
	 */
	@Test
	public void testMuscleMassTrunk() {
		long muscle = 12345L;
		data.setMuscleMassTrunk(muscle);
		assertEquals(muscle, data.getMuscleMassTrunk());
	}
	
	/**
	 * Test get and set physic rating.
	 */
	@Test
	public void testPhysicRating() {
		long muscle = 12345L;
		data.setPhysicRating(muscle);
		assertEquals(muscle, data.getPhysicRating());
	}
	
	/**
	 * Test get and set weight.
	 */
	@Test
	public void testWeight() {
		double weight = 12345L;
		data.setWeight(weight);
		assertEquals(weight, data.getWeight(), 5L);
	}
	
	/**
	 * Test get and set Daily Caloric Intake.
	 */
	@Test
	public void testDCI() {
		int muscle = 12345;
		data.setDailyCaloricIntake(muscle);
		assertEquals(muscle, data.getDailyCaloricIntake());
	}
	
	/**
	 * Test get and set Metabolic Age.
	 */
	@Test
	public void testMetabolicAge() {
		int muscle = 12345;
		data.setMetabolicAge(muscle);
		assertEquals(muscle, data.getMetabolicAge());
	}
	
	/**
	 * Test get and set body water percentage.
	 */
	@Test
	public void testBodyWaterPercentage() {
		long muscle = 12345L;
		data.setBodyWaterPercentage(muscle);
		assertEquals(muscle, data.getBodyWaterPercentage());
	}
	
	/**
	 * Test get and set Visceral Fat.
	 */
	@Test
	public void testVisceralFat() {
		int muscle = 12345;
		data.setVisceralFat(muscle);
		assertEquals(muscle, data.getVisceralFat());
	}
	
	/**
	 * Test get and set bone mass.
	 */
	@Test
	public void testBoneMass() {
		long muscle = 12345L;
		data.setBoneMass(muscle);
		assertEquals(muscle, data.getBoneMass());
	}
}

package ca.charland.tanita.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import ca.charland.tanita.db.TanitaDataTable.Column;

/**
 * @author mcharland
 */
public class TanitaDataTest {

	private TanitaData data;

	@Before
	public void setup() {
		data = new TanitaData();
	}

	@Test
	public void testId() {
		int id = 12345;
		data.setId(id);
		assertEquals(id, data.getId());
	}

	@Test
	public void testgetId() {
		data.setId(12345);
		assertEquals(-1, data.get(Column.ID), 0.0);
	}

	@Test
	public void testPerson() {
		long id = 123L;
		data.setPerson(id);
		assertEquals(id, data.getPerson(), 100L);
	}

	@Test
	public void testgetPerson() {
		data.setPerson(1245);
		assertEquals(-1, data.get(Column.PERSON), 0.0);
	}

	@Test
	public void testGetDate() {
		Date d = new Date(11);
		data.setDate(d);
		assertEquals(d, data.getDate());
	}

	@Test
	public void testgetDate() {
		data.setDate(new Date(0));
		assertEquals(-1, data.get(Column.DATE), 0.0);
	}

	@Test
	public void testBodyFatTotal() {
		long bodyFat = 12345L;
		data.setBodyFatTotal(bodyFat);
		assertEquals(bodyFat, data.getBodyFatTotal(), 100L);
	}

	@Test
	public void testgetBodyFatTotal() {
		int value = 234;
		data.setBodyFatTotal(value);
		assertEquals(value, data.get(Column.BODY_FAT_TOTAL), 0.0);
	}

	@Test
	public void testBodyFatLeftArm() {
		long bodyFat = 1234335L;
		data.setBodyFatLeftArm(bodyFat);
		assertEquals(bodyFat, data.getBodyFatLeftArm(), 100L);
	}

	@Test
	public void testgetBodyFatLeftArm() {
		int value = 24;
		data.setBodyFatLeftArm(value);
		assertEquals(value, data.get(Column.BODY_FAT_LEFT_ARM), 0.0);
	}

	@Test
	public void testBodyFatRightArm() {
		long bodyFat = 12345L;
		data.setBodyFatRightArm(bodyFat);
		assertEquals(bodyFat, data.getBodyFatRightArm(), 100L);
	}

	@Test
	public void testGetBodyFatRightArm() {
		int value = 214;
		data.setBodyFatRightArm(value);
		assertEquals(value, data.get(Column.BODY_FAT_RIGHT_ARM), 0.0);
	}
	
	@Test
	public void testBodyFatRightLeg() {
		long bodyFat = 12345L;
		data.setBodyFatRightArm(bodyFat);
		assertEquals(bodyFat, data.getBodyFatRightArm(), 100L);
	}
	
	@Test
	public void testGetBodyFatRightLeg() {
		int value = 21114;
		data.setBodyFatRightLeg(value);
		assertEquals(value, data.get(Column.BODY_FAT_RIGHT_LEG), 0.0);
	}

	@Test
	public void testBodyFatLeftLeg() {
		long bodyFat = 12345L;
		data.setBodyFatLeftLeg(bodyFat);
		assertEquals(bodyFat, data.getBodyFatLeftLeg(), 100L);
	}

	@Test
	public void testGetBodyFatLeftLeg() {
		int value = 11214;
		data.setBodyFatLeftLeg(value);
		assertEquals(value, data.get(Column.BODY_FAT_LEFT_LEG), 0.0);
	}

	@Test
	public void testBodyFatTrunk() {
		long bodyFat = 12345L;
		data.setBodyFatTrunk(bodyFat);
		assertEquals(bodyFat, data.getBodyFatTrunk(), 100L);
	}
	
	@Test
	public void testGetBodyFatTrunk() {
		int value = 112;
		data.setBodyFatTrunk(value);
		assertEquals(value, data.get(Column.BODY_FAT_TRUNK), 0.0);
	}

	@Test
	public void testMuscleMassTotal() {
		long muscle = 12345L;
		data.setMuscleMassTotal(muscle);
		assertEquals(muscle, data.getMuscleMassTotal(), 100L);
	}

	@Test
	public void testGetMuscleMassTotal() {
		int value = 1123;
		data.setMuscleMassTotal(value);
		assertEquals(value, data.get(Column.MUSCLE_MASS_TOTAL), 0.0);
	}

	@Test
	public void testMuscleMassLeftArm() {
		long muscle = 12345L;
		data.setMuscleMassLeftArm(muscle);
		assertEquals(muscle, data.getMuscleMassLeftArm(), 100L);
	}

	@Test
	public void testGetMuscleMassLeftArm() {
		int value = 1992;
		data.setMuscleMassLeftArm(value);
		assertEquals(value, data.get(Column.MUSCLE_MASS_LEFT_ARM), 0.0);
	}
	
	@Test
	public void testMuscleMassRightArm() {
		long muscle = 12345L;
		data.setMuscleMassRightArm(muscle);
		assertEquals(muscle, data.getMuscleMassRightArm(), 100L);
	}
	
	@Test
	public void testGetMuscleMassRightArm() {
		int value = 199213;
		data.setMuscleMassRightArm(value);
		assertEquals(value, data.get(Column.MUSCLE_MASS_RIGHT_ARM), 0.0);
	}

	@Test
	public void testMuscleMassRightLeg() {
		long muscle = 12345L;
		data.setMuscleMassRightLeg(muscle);
		assertEquals(muscle, data.getMuscleMassRightLeg(), 100L);
	}
	
	@Test
	public void testGetMuscleMassRightLeg() {
		int value = 197713;
		data.setMuscleMassRightLeg(value);
		assertEquals(value, data.get(Column.MUSCLE_MASS_RIGHT_LEG), 0.0);
	}

	@Test
	public void testMuscleMassLeftLeg() {
		long muscle = 12345L;
		data.setMuscleMassLeftLeg(muscle);
		assertEquals(muscle, data.getMuscleMassLeftLeg(), 100L);
	}

	@Test
	public void testGetMuscleMassLeftLeg() {
		int value = 19771553;
		data.setMuscleMassLeftLeg(value);
		assertEquals(value, data.get(Column.MUSCLE_MASS_LEFT_LEG), 0.0);
	}

	@Test
	public void testMuscleMassTrunk() {
		long muscle = 125L;
		data.setMuscleMassTrunk(muscle);
		assertEquals(muscle, data.getMuscleMassTrunk(), 100L);
	}

	@Test
	public void testGetMuscleMassTrunk() {
		int value = 191553;
		data.setMuscleMassTrunk(value);
		assertEquals(value, data.get(Column.MUSCLE_MASS_TRUNK), 0.0);
	}

	@Test
	public void testPhysicRating() {
		int muscle = 12345332;
		data.setPhysicRating(muscle);
		assertEquals(muscle, data.getPhysicRating(), 100L);
	}

	@Test
	public void testgetPhysicRating() {
		int value = 19153;
		data.setPhysicRating(value);
		assertEquals(value, data.get(Column.PHYSIC_RATING), 0.0);
	}

	@Test
	public void testWeight() {
		double weight = 145L;
		data.setWeight(weight);
		assertEquals(weight, data.getWeight(), 5L);
	}

	@Test
	public void testGetWeight() {
		int value = 19723;
		data.setWeight(value);
		assertEquals(value, data.get(Column.WEIGHT), 0.0);
	}

	@Test
	public void testDCI() {
		int muscle = 1234115;
		data.setDailyCaloricIntake(muscle);
		assertEquals(muscle, data.getDailyCaloricIntake());
	}

	@Test
	public void testgetDCI() {
		int value = 19771553;
		data.setDailyCaloricIntake(value);
		assertEquals(value, data.get(Column.DAILY_CALORIC_INTAKE), 0.0);
	}

	@Test
	public void testMetabolicAge() {
		int muscle = 1322345;
		data.setMetabolicAge(muscle);
		assertEquals(muscle, data.getMetabolicAge());
	}

	@Test
	public void testGetMetabolicAge() {
		int value = 12;
		data.setMetabolicAge(value);
		assertEquals(value, data.get(Column.METABOLIC_AGE), 0.0);
	}

	@Test
	public void testBodyWaterPercentage() {
		long muscle = 1234115L;
		data.setBodyWaterPercentage(muscle);
		assertEquals(muscle, data.getBodyWaterPercentage(), 100L);
	}

	@Test
	public void setBodyWaterPercentage() {
		int value = 19771553;
		data.setBodyWaterPercentage(value);
		assertEquals(value, data.get(Column.BODY_WATER_PERCENTAGE), 0.0);
	}

	@Test
	public void testVisceralFat() {
		int muscle = 123245;
		data.setVisceralFat(muscle);
		assertEquals(muscle, data.getVisceralFat());
	}

	@Test
	public void testGetVisceralFat() {
		int value = 19773;
		data.setVisceralFat(value);
		assertEquals(value, data.get(Column.VISCERAL_FAT), 0.0);
	}

	@Test
	public void testBoneMass() {
		long muscle = 12345L;
		data.setBoneMass(muscle);
		assertEquals(muscle, data.getBoneMass(), 100L);
	}

	@Test
	public void testGetBoneMass() {
		int value = 321;
		data.setBoneMass(value);
		assertEquals(value, data.get(Column.BONE_MASS), 0.0);
	}
	
	@Test
	public void testGetPerson() {
		assertEquals(-1, data.get(Column.PERSON), 0.0);
	}
	
	@Test
	public void testToString() {
		Date d = new Date(0);
		data.setDate(d);
		assertEquals("Dec 31, 1969 7:00PM", data.toString());
	}
}

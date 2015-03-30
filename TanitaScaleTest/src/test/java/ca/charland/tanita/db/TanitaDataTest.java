package ca.charland.tanita.db;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

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
		assertThat(data.getId(), is(id));
	}

	@Test
	public void testgetId() {
		data.setId(12345);
		assertThat(data.get(Column.ID), is((double) -1));
	}

	@Test
	public void testPerson() {
		long id = 123L;
		data.setPerson(id);
		assertThat(data.getPerson(), is(id));
	}

	@Test
	public void testgetPerson() {
		data.setPerson(1245);
		assertThat(data.get(Column.PERSON), is((double) -1));
	}

	@Test
	public void testGetDate() {
		Date d = new Date(11);
		data.setDate(d);
		assertThat(data.getDate().toString(), is(d.toString()));
	}

	@Test
	public void testgetDate() {
		data.setDate(new Date(0));
		assertThat(data.get(Column.DATE), is((double) -1));
	}

	@Test
	public void testBodyFatTotal() {
		long bodyFat = 12345L;
		data.setBodyFatTotal(bodyFat);
		assertThat(data.getBodyFatTotal(), is((double) bodyFat));
	}

	@Test
	public void testgetBodyFatTotal() {
		int value = 234;
		data.setBodyFatTotal(value);
		assertThat(data.get(Column.BODY_FAT_TOTAL), is((double) value));
	}

	@Test
	public void testBodyFatLeftArm() {
		long bodyFat = 1234335L;
		data.setBodyFatLeftArm(bodyFat);
		assertThat(data.getBodyFatLeftArm(), is((double) bodyFat));
	}

	@Test
	public void testgetBodyFatLeftArm() {
		int value = 24;
		data.setBodyFatLeftArm(value);
		assertThat(data.get(Column.BODY_FAT_LEFT_ARM), is((double) value));
	}

	@Test
	public void testBodyFatRightArm() {
		long bodyFat = 12345L;
		data.setBodyFatRightArm(bodyFat);
		assertThat(data.getBodyFatRightArm(), is((double) bodyFat));
	}

	@Test
	public void testGetBodyFatRightArm() {
		int value = 214;
		data.setBodyFatRightArm(value);
		assertThat(data.get(Column.BODY_FAT_RIGHT_ARM), is((double) value));
	}

	@Test
	public void testBodyFatRightLeg() {
		long bodyFat = 12345L;
		data.setBodyFatRightArm(bodyFat);
		assertThat(data.getBodyFatRightArm(), is((double) bodyFat));
	}

	@Test
	public void testGetBodyFatRightLeg() {
		int value = 21114;
		data.setBodyFatRightLeg(value);
		assertThat(data.get(Column.BODY_FAT_RIGHT_LEG), is((double) value));
	}

	@Test
	public void testBodyFatLeftLeg() {
		long bodyFat = 12345L;
		data.setBodyFatLeftLeg(bodyFat);
		assertThat(data.getBodyFatLeftLeg(), is((double) bodyFat));
	}

	@Test
	public void testGetBodyFatLeftLeg() {
		int value = 11214;
		data.setBodyFatLeftLeg(value);
		assertThat(data.get(Column.BODY_FAT_LEFT_LEG), is((double) value));
	}

	@Test
	public void testBodyFatTrunk() {
		long bodyFat = 12345L;
		data.setBodyFatTrunk(bodyFat);
		assertThat(data.getBodyFatTrunk(), is((double) bodyFat));
	}

	@Test
	public void testGetBodyFatTrunk() {
		int value = 112;
		data.setBodyFatTrunk(value);
		assertThat(data.get(Column.BODY_FAT_TRUNK), is((double) value));
	}

	@Test
	public void testMuscleMassTotal() {
		long muscle = 12345L;
		data.setMuscleMassTotal(muscle);
		assertThat(data.getMuscleMassTotal(), is((double) muscle));
	}

	@Test
	public void testGetMuscleMassTotal() {
		int value = 1123;
		data.setMuscleMassTotal(value);
		assertThat(data.get(Column.MUSCLE_MASS_TOTAL), is((double) value));
	}

	@Test
	public void testMuscleMassLeftArm() {
		long muscle = 12345L;
		data.setMuscleMassLeftArm(muscle);
		assertThat(data.getMuscleMassLeftArm(), is((double) muscle));
	}

	@Test
	public void testGetMuscleMassLeftArm() {
		int value = 1992;
		data.setMuscleMassLeftArm(value);
		assertThat(data.get(Column.MUSCLE_MASS_LEFT_ARM), is((double) value));
	}

	@Test
	public void testMuscleMassRightArm() {
		long muscle = 12345L;
		data.setMuscleMassRightArm(muscle);
		assertThat(data.getMuscleMassRightArm(), is((double) muscle));
	}

	@Test
	public void testGetMuscleMassRightArm() {
		int value = 199213;
		data.setMuscleMassRightArm(value);
		assertThat(data.get(Column.MUSCLE_MASS_RIGHT_ARM), is((double) value));
	}

	@Test
	public void testMuscleMassRightLeg() {
		long muscle = 12345L;
		data.setMuscleMassRightLeg(muscle);
		assertThat(data.getMuscleMassRightLeg(), is((double) muscle));
	}

	@Test
	public void testGetMuscleMassRightLeg() {
		int value = 197713;
		data.setMuscleMassRightLeg(value);
		assertThat(data.get(Column.MUSCLE_MASS_RIGHT_LEG), is((double) value));
	}

	@Test
	public void testMuscleMassLeftLeg() {
		long muscle = 12345L;
		data.setMuscleMassLeftLeg(muscle);
		assertThat(data.getMuscleMassLeftLeg(), is((double) muscle));
	}

	@Test
	public void testGetMuscleMassLeftLeg() {
		int value = 19771553;
		data.setMuscleMassLeftLeg(value);
		assertThat(data.get(Column.MUSCLE_MASS_LEFT_LEG), is((double) value));
	}

	@Test
	public void testMuscleMassTrunk() {
		long muscle = 125L;
		data.setMuscleMassTrunk(muscle);
		assertThat(data.getMuscleMassTrunk(), is((double) muscle));
	}

	@Test
	public void testGetMuscleMassTrunk() {
		int value = 191553;
		data.setMuscleMassTrunk(value);
		assertThat(data.get(Column.MUSCLE_MASS_TRUNK), is((double) value));
	}

	@Test
	public void testPhysicRating() {
		int physic = 12345332;
		data.setPhysicRating(physic);
		assertThat(data.getPhysicRating(), is(physic));
	}

	@Test
	public void testgetPhysicRating() {
		int value = 19153;
		data.setPhysicRating(value);
		assertThat(data.get(Column.PHYSIC_RATING), is((double) value));
	}

	@Test
	public void testWeight() {
		double weight = 145L;
		data.setWeight(weight);
		assertThat(data.getWeight(), is(weight));
	}

	@Test
	public void testGetWeight() {
		int value = 19723;
		data.setWeight(value);
		assertThat(data.get(Column.WEIGHT), is((double) value));
	}

	@Test
	public void testDCI() {
		int muscle = 1234115;
		data.setDailyCaloricIntake(muscle);
		assertThat(data.getDailyCaloricIntake(), is(muscle));
	}

	@Test
	public void testgetDCI() {
		int value = 19771553;
		data.setDailyCaloricIntake(value);
		assertThat(data.get(Column.DAILY_CALORIC_INTAKE), is((double) value));
	}

	@Test
	public void testMetabolicAge() {
		int muscle = 1322345;
		data.setMetabolicAge(muscle);
		assertThat(data.getMetabolicAge(), is(muscle));
	}

	@Test
	public void testGetMetabolicAge() {
		int value = 12;
		data.setMetabolicAge(value);
		assertThat(data.get(Column.METABOLIC_AGE), is((double) value));
	}

	@Test
	public void testBodyWaterPercentage() {
		long muscle = 1234115L;
		data.setBodyWaterPercentage(muscle);
		assertThat(data.getBodyWaterPercentage(), is((double) muscle));
	}

	@Test
	public void setBodyWaterPercentage() {
		int value = 19771553;
		data.setBodyWaterPercentage(value);
		assertThat(data.get(Column.BODY_WATER_PERCENTAGE), is((double) value));
	}

	@Test
	public void testVisceralFat() {
		int muscle = 123245;
		data.setVisceralFat(muscle);
		assertThat(data.getVisceralFat(), is(muscle));
	}

	@Test
	public void testGetVisceralFat() {
		int value = 19773;
		data.setVisceralFat(value);
		assertThat(data.get(Column.VISCERAL_FAT), is((double) value));
	}

	@Test
	public void testBoneMass() {
		long muscle = 12345L;
		data.setBoneMass(muscle);
		assertThat(data.getBoneMass(), is((double) muscle));
	}

	@Test
	public void testGetBoneMass() {
		int value = 321;
		data.setBoneMass(value);
		assertThat(data.get(Column.BONE_MASS), is((double) value));
	}

	@Test
	public void testGetPerson() {
		assertThat(data.get(Column.PERSON), is(-1d));
	}
	
	@Test
	public void testEmail() {
		assertThat(data.get(Column.EMAILS_SENT), is(0d));
	}

	@Test
	public void testToString() {
		Date d = new Date(0);
		data.setDate(d);
		assertThat(data.toString(), is("Dec 31, 1969 7:00PM"));
	}
}

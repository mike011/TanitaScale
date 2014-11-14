package ca.charland.tanita.db;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import ca.charland.tanita.base.db.BaseData;

/**
 * Holds the row info of data.
 * 
 * @author mcharland
 */
public class TanitaData extends BaseData {

	private double bodyFatTotal;
	private double bodyFatLeftArm;
	private double bodyFatRightArm;
	private double bodyFatRightLeg;
	private double bodyFatLeftLeg;
	private double bodyFatTrunk;
	private double muscleMassTotal;
	private double muscleMassLeftArm;
	private double muscleMassRightArm;
	private double muscleMassRightLeg;
	private double muscleMassLeftLeg;
	private double muscleMassTrunk;
	private int physicRating;
	private double weight;
	private int dailyCaloricIntake;
	private int metabolicAge;
	private double bodyWaterPercentage;
	private int visceralFat;
	private double boneMass;
	private int emailsSent;

	public double getBodyFatTotal() {
		return bodyFatTotal;
	}

	public void setBodyFatTotal(double bodyFatTotal) {
		this.bodyFatTotal = bodyFatTotal;
	}

	public double getBodyFatLeftArm() {
		return bodyFatLeftArm;
	}

	public void setBodyFatLeftArm(double bodyFatLeftArm) {
		this.bodyFatLeftArm = bodyFatLeftArm;
	}

	public double getBodyFatRightArm() {
		return bodyFatRightArm;
	}

	public void setBodyFatRightArm(double bodyFatRightArm) {
		this.bodyFatRightArm = bodyFatRightArm;
	}

	public double getBodyFatRightLeg() {
		return bodyFatRightLeg;
	}

	public void setBodyFatRightLeg(double bodyFatRightLeg) {
		this.bodyFatRightLeg = bodyFatRightLeg;
	}

	public double getBodyFatLeftLeg() {
		return bodyFatLeftLeg;
	}

	public void setBodyFatLeftLeg(double bodyFatLeftLeg) {
		this.bodyFatLeftLeg = bodyFatLeftLeg;
	}

	public double getBodyFatTrunk() {
		return bodyFatTrunk;
	}

	public void setBodyFatTrunk(double bodyFatTrunk) {
		this.bodyFatTrunk = bodyFatTrunk;
	}

	public double getMuscleMassTotal() {
		return muscleMassTotal;
	}

	public void setMuscleMassTotal(double muscleMassTotal) {
		this.muscleMassTotal = muscleMassTotal;
	}

	public double getMuscleMassLeftArm() {
		return muscleMassLeftArm;
	}

	public void setMuscleMassLeftArm(double muscleMassLeftArm) {
		this.muscleMassLeftArm = muscleMassLeftArm;
	}

	public double getMuscleMassRightArm() {
		return muscleMassRightArm;
	}

	public void setMuscleMassRightArm(double muscleMassRightArm) {
		this.muscleMassRightArm = muscleMassRightArm;
	}

	public double getMuscleMassRightLeg() {
		return muscleMassRightLeg;
	}

	public void setMuscleMassRightLeg(double muscleMassRightLeg) {
		this.muscleMassRightLeg = muscleMassRightLeg;
	}

	public double getMuscleMassLeftLeg() {
		return muscleMassLeftLeg;
	}

	public void setMuscleMassLeftLeg(double muscleMassLeftLeg) {
		this.muscleMassLeftLeg = muscleMassLeftLeg;
	}

	public double getMuscleMassTrunk() {
		return muscleMassTrunk;
	}

	public void setMuscleMassTrunk(double muscleMassTrunk) {
		this.muscleMassTrunk = muscleMassTrunk;
	}

	public int getPhysicRating() {
		return physicRating;
	}

	public void setPhysicRating(int physicRating) {
		this.physicRating = physicRating;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getDailyCaloricIntake() {
		return dailyCaloricIntake;
	}

	public void setDailyCaloricIntake(int dailyCaloricIntake) {
		this.dailyCaloricIntake = dailyCaloricIntake;
	}

	public int getMetabolicAge() {
		return metabolicAge;
	}

	public void setMetabolicAge(int metabolicAge) {
		this.metabolicAge = metabolicAge;
	}

	public double getBodyWaterPercentage() {
		return bodyWaterPercentage;
	}

	public void setBodyWaterPercentage(double bodyWaterPercentage) {
		this.bodyWaterPercentage = bodyWaterPercentage;
	}

	public int getVisceralFat() {
		return visceralFat;
	}

	public void setVisceralFat(int visceralFat) {
		this.visceralFat = visceralFat;
	}

	public double getBoneMass() {
		return boneMass;
	}

	public void setBoneMass(double boneMass) {
		this.boneMass = boneMass;
	}
	
	public int getEmailsSent() {
		return emailsSent;
	}
	
	public void setEmailsSent(double emails) {
		this.emailsSent = (int) emails;
	}
	
	public void incrementEmailsSent() {
		emailsSent++;
	}

	public double get(TanitaDataTable.Column column) {
		switch (column) {
		case DAILY_CALORIC_INTAKE:
			return getDailyCaloricIntake();
		case BODY_FAT_TOTAL:
			return getBodyFatTotal();

		case BODY_FAT_LEFT_ARM:
			return getBodyFatLeftArm();

		case BODY_FAT_RIGHT_ARM:
			return getBodyFatRightArm();

		case BODY_FAT_RIGHT_LEG:
			return getBodyFatRightLeg();

		case BODY_FAT_LEFT_LEG:
			return getBodyFatLeftLeg();

		case BODY_FAT_TRUNK:
			return getBodyFatTrunk();

		case MUSCLE_MASS_TOTAL:
			return getMuscleMassTotal();

		case MUSCLE_MASS_LEFT_ARM:
			return getMuscleMassLeftArm();

		case MUSCLE_MASS_RIGHT_ARM:
			return getMuscleMassRightArm();

		case MUSCLE_MASS_RIGHT_LEG:
			return getMuscleMassRightLeg();

		case MUSCLE_MASS_LEFT_LEG:
			return getMuscleMassLeftLeg();

		case MUSCLE_MASS_TRUNK:
			return getMuscleMassTrunk();

		case PHYSIC_RATING:
			return getPhysicRating();

		case METABOLIC_AGE:
			return getMetabolicAge();

		case BODY_WATER_PERCENTAGE:
			return getBodyWaterPercentage();

		case VISCERAL_FAT:
			return getVisceralFat();

		case BONE_MASS:
			return getBoneMass();

		case WEIGHT:
			return getWeight();
			
		case EMAILS_SENT:
			return getEmailsSent();
			
		default:
			break;
		}

		return -1;
	}

	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("MMM dd, yyyy h:mmaa");
		return df.format(getDate());
	}
}

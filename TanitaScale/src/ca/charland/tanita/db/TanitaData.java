package ca.charland.tanita.db;

import java.util.Date;

/**
 * The Class TanitaData which holds the row info of data.
 * 
 * @author mcharland
 */
public class TanitaData extends AbstractData {

	/** The person. */
	private long person;

	/** The date. */
	private Date date;

	/** The body fat total. */
	private double bodyFatTotal;

	/** The body fat left arm. */
	private double bodyFatLeftArm;

	/** The body fat right arm. */
	private double bodyFatRightArm;

	/** The body fat right leg. */
	private double bodyFatRightLeg;

	/** The body fat left leg. */
	private double bodyFatLeftLeg;

	/** The body fat trunk. */
	private double bodyFatTrunk;

	/** The muscle mass total. */
	private double muscleMassTotal;

	/** The muscle mass left arm. */
	private double muscleMassLeftArm;

	/** The muscle mass right arm. */
	private double muscleMassRightArm;

	/** The muscle mass right leg. */
	private double muscleMassRightLeg;

	/** The muscle mass left leg. */
	private double muscleMassLeftLeg;

	/** The muscle mass trunk. */
	private double muscleMassTrunk;

	/** The physic rating. */
	private double physicRating;

	/** The weight. */
	private double weight;

	/** The daily caloric intake. */
	private int dailyCaloricIntake;

	/** The metabolic age. */
	private int metabolicAge;

	/** The body water percentage. */
	private double bodyWaterPercentage;

	/** The visceral fat. */
	private int visceralFat;

	/** The Bone mass. */
	private double boneMass;

	/**
	 * Gets the person.
	 * 
	 * @return the person
	 */
	public long getPerson() {
		return person;
	}

	/**
	 * Sets the person.
	 * 
	 * @param person
	 *            the new person
	 */
	public void setPerson(long person) {
		this.person = person;
	}

	/**
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 * 
	 * @param date
	 *            the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the body fat total.
	 * 
	 * @return the body fat total
	 */
	public double getBodyFatTotal() {
		return bodyFatTotal;
	}

	/**
	 * Sets the body fat total.
	 * 
	 * @param bodyFatTotal
	 *            the new body fat total
	 */
	public void setBodyFatTotal(double bodyFatTotal) {
		this.bodyFatTotal = bodyFatTotal;
	}

	/**
	 * Gets the body fat left arm.
	 * 
	 * @return the body fat left arm
	 */
	public double getBodyFatLeftArm() {
		return bodyFatLeftArm;
	}

	/**
	 * Sets the body fat left arm.
	 * 
	 * @param bodyFatLeftArm
	 *            the new body fat left arm
	 */
	public void setBodyFatLeftArm(double bodyFatLeftArm) {
		this.bodyFatLeftArm = bodyFatLeftArm;
	}

	/**
	 * Gets the body fat right arm.
	 * 
	 * @return the body fat right arm
	 */
	public double getBodyFatRightArm() {
		return bodyFatRightArm;
	}

	/**
	 * Sets the body fat right arm.
	 * 
	 * @param bodyFatRightArm
	 *            the new body fat right arm
	 */
	public void setBodyFatRightArm(double bodyFatRightArm) {
		this.bodyFatRightArm = bodyFatRightArm;
	}

	/**
	 * Gets the body fat right leg.
	 * 
	 * @return the body fat right leg
	 */
	public double getBodyFatRightLeg() {
		return bodyFatRightLeg;
	}

	/**
	 * Sets the body fat right leg.
	 * 
	 * @param bodyFatRightLeg
	 *            the new body fat right leg
	 */
	public void setBodyFatRightLeg(double bodyFatRightLeg) {
		this.bodyFatRightLeg = bodyFatRightLeg;
	}

	/**
	 * Gets the body fat left leg.
	 * 
	 * @return the body fat left leg
	 */
	public double getBodyFatLeftLeg() {
		return bodyFatLeftLeg;
	}

	/**
	 * Sets the body fat left leg.
	 * 
	 * @param bodyFatLeftLeg
	 *            the new body fat left leg
	 */
	public void setBodyFatLeftLeg(double bodyFatLeftLeg) {
		this.bodyFatLeftLeg = bodyFatLeftLeg;
	}

	/**
	 * Gets the body fat trunk.
	 * 
	 * @return the body fat trunk
	 */
	public double getBodyFatTrunk() {
		return bodyFatTrunk;
	}

	/**
	 * Sets the body fat trunk.
	 * 
	 * @param bodyFatTrunk
	 *            the new body fat trunk
	 */
	public void setBodyFatTrunk(double bodyFatTrunk) {
		this.bodyFatTrunk = bodyFatTrunk;
	}

	/**
	 * Gets the muscle mass total.
	 * 
	 * @return the muscle mass total
	 */
	public double getMuscleMassTotal() {
		return muscleMassTotal;
	}

	/**
	 * Sets the muscle mass total.
	 * 
	 * @param muscleMassTotal
	 *            the new muscle mass total
	 */
	public void setMuscleMassTotal(double muscleMassTotal) {
		this.muscleMassTotal = muscleMassTotal;
	}

	/**
	 * Gets the muscle mass left arm.
	 * 
	 * @return the muscle mass left arm
	 */
	public double getMuscleMassLeftArm() {
		return muscleMassLeftArm;
	}

	/**
	 * Sets the muscle mass left arm.
	 * 
	 * @param muscleMassLeftArm
	 *            the new muscle mass left arm
	 */
	public void setMuscleMassLeftArm(double muscleMassLeftArm) {
		this.muscleMassLeftArm = muscleMassLeftArm;
	}

	/**
	 * Gets the muscle mass right arm.
	 * 
	 * @return the muscle mass right arm
	 */
	public double getMuscleMassRightArm() {
		return muscleMassRightArm;
	}

	/**
	 * Sets the muscle mass right arm.
	 * 
	 * @param muscleMassRightArm
	 *            the new muscle mass right arm
	 */
	public void setMuscleMassRightArm(double muscleMassRightArm) {
		this.muscleMassRightArm = muscleMassRightArm;
	}

	/**
	 * Gets the muscle mass right leg.
	 * 
	 * @return the muscle mass right leg
	 */
	public double getMuscleMassRightLeg() {
		return muscleMassRightLeg;
	}

	/**
	 * Sets the muscle mass right leg.
	 * 
	 * @param muscleMassRightLeg
	 *            the new muscle mass right leg
	 */
	public void setMuscleMassRightLeg(double muscleMassRightLeg) {
		this.muscleMassRightLeg = muscleMassRightLeg;
	}

	/**
	 * Gets the muscle mass left leg.
	 * 
	 * @return the muscle mass left leg
	 */
	public double getMuscleMassLeftLeg() {
		return muscleMassLeftLeg;
	}

	/**
	 * Sets the muscle mass left leg.
	 * 
	 * @param muscleMassLeftLeg
	 *            the new muscle mass left leg
	 */
	public void setMuscleMassLeftLeg(double muscleMassLeftLeg) {
		this.muscleMassLeftLeg = muscleMassLeftLeg;
	}

	/**
	 * Gets the muscle mass trunk.
	 * 
	 * @return the muscle mass trunk
	 */
	public double getMuscleMassTrunk() {
		return muscleMassTrunk;
	}

	/**
	 * Sets the muscle mass trunk.
	 * 
	 * @param muscleMassTrunk
	 *            the new muscle mass trunk
	 */
	public void setMuscleMassTrunk(double muscleMassTrunk) {
		this.muscleMassTrunk = muscleMassTrunk;
	}

	/**
	 * Gets the physic rating.
	 * 
	 * @return the physic rating
	 */
	public double getPhysicRating() {
		return physicRating;
	}

	/**
	 * Sets the physic rating.
	 * 
	 * @param physicRating
	 *            the new physic rating
	 */
	public void setPhysicRating(double physicRating) {
		this.physicRating = physicRating;
	}

	/**
	 * Gets the weight.
	 * 
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 * 
	 * @param weight
	 *            the new weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * Gets the daily caloric intake.
	 * 
	 * @return the daily caloric intake
	 */
	public int getDailyCaloricIntake() {
		return dailyCaloricIntake;
	}

	/**
	 * Sets the daily caloric intake.
	 * 
	 * @param dailyCaloricIntake
	 *            the new daily caloric intake
	 */
	public void setDailyCaloricIntake(int dailyCaloricIntake) {
		this.dailyCaloricIntake = dailyCaloricIntake;
	}

	/**
	 * Gets the metabolic age.
	 * 
	 * @return the metabolic age
	 */
	public int getMetabolicAge() {
		return metabolicAge;
	}

	/**
	 * Sets the metabolic age.
	 * 
	 * @param metabolicAge
	 *            the new metabolic age
	 */
	public void setMetabolicAge(int metabolicAge) {
		this.metabolicAge = metabolicAge;
	}

	/**
	 * Gets the body water percentage.
	 * 
	 * @return the body water percentage
	 */
	public double getBodyWaterPercentage() {
		return bodyWaterPercentage;
	}

	/**
	 * Sets the body water percentage.
	 * 
	 * @param bodyWaterPercentage
	 *            the new body water percentage
	 */
	public void setBodyWaterPercentage(double bodyWaterPercentage) {
		this.bodyWaterPercentage = bodyWaterPercentage;
	}

	/**
	 * Gets the visceral fat.
	 * 
	 * @return the visceral fat
	 */
	public int getVisceralFat() {
		return visceralFat;
	}

	/**
	 * Sets the visceral fat.
	 * 
	 * @param visceralFat
	 *            the new visceral fat
	 */
	public void setVisceralFat(int visceralFat) {
		this.visceralFat = visceralFat;
	}

	/**
	 * Gets the bone mass.
	 * 
	 * @return the bone mass
	 */
	public double getBoneMass() {
		return boneMass;
	}

	/**
	 * Sets the bone mass.
	 * 
	 * @param boneMass
	 *            the new bone mass
	 */
	public void setBoneMass(double boneMass) {
		this.boneMass = boneMass;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return getDate().toGMTString();
	}

}

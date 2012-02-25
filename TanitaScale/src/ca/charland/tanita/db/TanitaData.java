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
	private long bodyFatTotal;

	/** The body fat left arm. */
	private long bodyFatLeftArm;

	/** The body fat right arm. */
	private long bodyFatRightArm;

	/** The body fat right leg. */
	private long bodyFatRightLeg;

	/** The body fat left leg. */
	private long bodyFatLeftLeg;

	/** The body fat trunk. */
	private long bodyFatTrunk;

	/** The muscle mass total. */
	private long muscleMassTotal;

	/** The muscle mass left arm. */
	private long muscleMassLeftArm;

	/** The muscle mass right arm. */
	private long muscleMassRightArm;

	/** The muscle mass right leg. */
	private long muscleMassRightLeg;

	/** The muscle mass left leg. */
	private long muscleMassLeftLeg;

	/** The muscle mass trunk. */
	private long muscleMassTrunk;

	/** The physic rating. */
	private long physicRating;

	/** The weight. */
	private long weight;

	/** The daily caloric intake. */
	private int dailyCaloricIntake;

	/** The metabolic age. */
	private int metabolicAge;

	/** The body water percentage. */
	private long bodyWaterPercentage;

	/** The visceral fat. */
	private int visceralFat;

	/** The Bone mass. */
	private long boneMass;

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
	public long getBodyFatTotal() {
		return bodyFatTotal;
	}

	/**
	 * Sets the body fat total.
	 * 
	 * @param bodyFatTotal
	 *            the new body fat total
	 */
	public void setBodyFatTotal(long bodyFatTotal) {
		this.bodyFatTotal = bodyFatTotal;
	}

	/**
	 * Gets the body fat left arm.
	 * 
	 * @return the body fat left arm
	 */
	public long getBodyFatLeftArm() {
		return bodyFatLeftArm;
	}

	/**
	 * Sets the body fat left arm.
	 * 
	 * @param bodyFatLeftArm
	 *            the new body fat left arm
	 */
	public void setBodyFatLeftArm(long bodyFatLeftArm) {
		this.bodyFatLeftArm = bodyFatLeftArm;
	}

	/**
	 * Gets the body fat right arm.
	 * 
	 * @return the body fat right arm
	 */
	public long getBodyFatRightArm() {
		return bodyFatRightArm;
	}

	/**
	 * Sets the body fat right arm.
	 * 
	 * @param bodyFatRightArm
	 *            the new body fat right arm
	 */
	public void setBodyFatRightArm(long bodyFatRightArm) {
		this.bodyFatRightArm = bodyFatRightArm;
	}

	/**
	 * Gets the body fat right leg.
	 * 
	 * @return the body fat right leg
	 */
	public long getBodyFatRightLeg() {
		return bodyFatRightLeg;
	}

	/**
	 * Sets the body fat right leg.
	 * 
	 * @param bodyFatRightLeg
	 *            the new body fat right leg
	 */
	public void setBodyFatRightLeg(long bodyFatRightLeg) {
		this.bodyFatRightLeg = bodyFatRightLeg;
	}

	/**
	 * Gets the body fat left leg.
	 * 
	 * @return the body fat left leg
	 */
	public long getBodyFatLeftLeg() {
		return bodyFatLeftLeg;
	}

	/**
	 * Sets the body fat left leg.
	 * 
	 * @param bodyFatLeftLeg
	 *            the new body fat left leg
	 */
	public void setBodyFatLeftLeg(long bodyFatLeftLeg) {
		this.bodyFatLeftLeg = bodyFatLeftLeg;
	}

	/**
	 * Gets the body fat trunk.
	 * 
	 * @return the body fat trunk
	 */
	public long getBodyFatTrunk() {
		return bodyFatTrunk;
	}

	/**
	 * Sets the body fat trunk.
	 * 
	 * @param bodyFatTrunk
	 *            the new body fat trunk
	 */
	public void setBodyFatTrunk(long bodyFatTrunk) {
		this.bodyFatTrunk = bodyFatTrunk;
	}

	/**
	 * Gets the muscle mass total.
	 * 
	 * @return the muscle mass total
	 */
	public long getMuscleMassTotal() {
		return muscleMassTotal;
	}

	/**
	 * Sets the muscle mass total.
	 * 
	 * @param muscleMassTotal
	 *            the new muscle mass total
	 */
	public void setMuscleMassTotal(long muscleMassTotal) {
		this.muscleMassTotal = muscleMassTotal;
	}

	/**
	 * Gets the muscle mass left arm.
	 * 
	 * @return the muscle mass left arm
	 */
	public long getMuscleMassLeftArm() {
		return muscleMassLeftArm;
	}

	/**
	 * Sets the muscle mass left arm.
	 * 
	 * @param muscleMassLeftArm
	 *            the new muscle mass left arm
	 */
	public void setMuscleMassLeftArm(long muscleMassLeftArm) {
		this.muscleMassLeftArm = muscleMassLeftArm;
	}

	/**
	 * Gets the muscle mass right arm.
	 * 
	 * @return the muscle mass right arm
	 */
	public long getMuscleMassRightArm() {
		return muscleMassRightArm;
	}

	/**
	 * Sets the muscle mass right arm.
	 * 
	 * @param muscleMassRightArm
	 *            the new muscle mass right arm
	 */
	public void setMuscleMassRightArm(long muscleMassRightArm) {
		this.muscleMassRightArm = muscleMassRightArm;
	}

	/**
	 * Gets the muscle mass right leg.
	 * 
	 * @return the muscle mass right leg
	 */
	public long getMuscleMassRightLeg() {
		return muscleMassRightLeg;
	}

	/**
	 * Sets the muscle mass right leg.
	 * 
	 * @param muscleMassRightLeg
	 *            the new muscle mass right leg
	 */
	public void setMuscleMassRightLeg(long muscleMassRightLeg) {
		this.muscleMassRightLeg = muscleMassRightLeg;
	}

	/**
	 * Gets the muscle mass left leg.
	 * 
	 * @return the muscle mass left leg
	 */
	public long getMuscleMassLeftLeg() {
		return muscleMassLeftLeg;
	}

	/**
	 * Sets the muscle mass left leg.
	 * 
	 * @param muscleMassLeftLeg
	 *            the new muscle mass left leg
	 */
	public void setMuscleMassLeftLeg(long muscleMassLeftLeg) {
		this.muscleMassLeftLeg = muscleMassLeftLeg;
	}

	/**
	 * Gets the muscle mass trunk.
	 * 
	 * @return the muscle mass trunk
	 */
	public long getMuscleMassTrunk() {
		return muscleMassTrunk;
	}

	/**
	 * Sets the muscle mass trunk.
	 * 
	 * @param muscleMassTrunk
	 *            the new muscle mass trunk
	 */
	public void setMuscleMassTrunk(long muscleMassTrunk) {
		this.muscleMassTrunk = muscleMassTrunk;
	}

	/**
	 * Gets the physic rating.
	 * 
	 * @return the physic rating
	 */
	public long getPhysicRating() {
		return physicRating;
	}

	/**
	 * Sets the physic rating.
	 * 
	 * @param physicRating
	 *            the new physic rating
	 */
	public void setPhysicRating(long physicRating) {
		this.physicRating = physicRating;
	}

	/**
	 * Gets the weight.
	 * 
	 * @return the weight
	 */
	public long getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 * 
	 * @param weight
	 *            the new weight
	 */
	public void setWeight(long weight) {
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
	public long getBodyWaterPercentage() {
		return bodyWaterPercentage;
	}

	/**
	 * Sets the body water percentage.
	 * 
	 * @param bodyWaterPercentage
	 *            the new body water percentage
	 */
	public void setBodyWaterPercentage(long bodyWaterPercentage) {
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
	public long getBoneMass() {
		return boneMass;
	}

	/**
	 * Sets the bone mass.
	 * 
	 * @param boneMass
	 *            the new bone mass
	 */
	public void setBoneMass(long boneMass) {
		this.boneMass = boneMass;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		// Only used for debugging.
		StringBuilder result = new StringBuilder();
		result.append("ID:").append(getId());
		result.append(" Person:").append(getPerson());
		result.append(" Date:").append(getDate().toGMTString());
		return result.toString();
	}

}

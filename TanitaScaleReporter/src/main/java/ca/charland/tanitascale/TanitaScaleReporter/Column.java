package ca.charland.tanitascale.TanitaScaleReporter;

public enum Column {

	DATE("date"),

	WEIGHT("weight"),

	DAILY_CALORIC_INTAKE("daily_caloric_intake"),

	BODY_FAT_TOTAL("body_fat_total"),

	BODY_FAT_LEFT_ARM("body_fat_left_arm"),

	BODY_FAT_RIGHT_ARM("body_fat_right_arm"),

	BODY_FAT_RIGHT_LEG("body_fat_right_leg"),

	BODY_FAT_LEFT_LEG("body_fat_left_leg"),

	BODY_FAT_TRUNK("body_fat_trunk"),

	MUSCLE_MASS_TOTAL("muscle_mass_total"),

	MUSCLE_MASS_LEFT_ARM("muscle_mass_left_arm"),

	MUSCLE_MASS_RIGHT_ARM("muscle_mass_right_arm"),

	MUSCLE_MASS_RIGHT_LEG("muscle_mass_right_leg"),

	MUSCLE_MASS_LEFT_LEG("muscle_mass_left_leg"),

	MUSCLE_MASS_TRUNK("muscle_trunk"),

	PHYSIC_RATING("physic_rating"),

	METABOLIC_AGE("metabolic_age"),

	BODY_WATER_PERCENTAGE("body_water_percentage"),

	VISCERAL_FAT("visceral_fat"),

	BONE_MASS("bone_mass");

	private final String name;

	Column(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
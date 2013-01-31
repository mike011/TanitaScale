package ca.charland.tanitascale.TanitaScaleReporter;

public enum Column {

	DATE("Date"),

	WEIGHT("Weight"),

	DAILY_CALORIC_INTAKE("Daily Caloric Intake"),
	
	METABOLIC_AGE("Metabolic Age"),
	
	BODY_WATER_PERCENTAGE("Body Water Percentage"),

	VISCERAL_FAT("Visceral Fat"),

	BONE_MASS("Bone Mass"),

	BODY_FAT_TOTAL("Total Body Fat"),

	BODY_FAT_LEFT_ARM("Body Fat for your Left Arm"),

	BODY_FAT_RIGHT_ARM("Body Fat for your Right Arm"),

	BODY_FAT_LEFT_LEG("Body Fat for your Left Leg"),

	BODY_FAT_RIGHT_LEG("Body Fat for your Right Leg"),

	BODY_FAT_TRUNK("Body Fat for your Trunk"),

	MUSCLE_MASS_TOTAL("Total Muscle Mass"),

	MUSCLE_MASS_LEFT_ARM("Muscle for your Left Arm"),

	MUSCLE_MASS_RIGHT_ARM("Muscle for your Right Arm"),

	MUSCLE_MASS_RIGHT_LEG("Muscle for your Right Leg"),

	MUSCLE_MASS_LEFT_LEG("Muscle for your Left Leg"),

	MUSCLE_MASS_TRUNK("Muscle for your Trunk"),

	PHYSIC_RATING("Physic Rating");

	private final String name;

	Column(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
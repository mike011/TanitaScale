package ca.charland.tanita.db;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import ca.charland.db.DataSource;
import ca.charland.db.DatabaseHelper;

import android.content.Context;
import android.database.Cursor;

/**
 * @author mcharland
 */
public class TanitaDataSource extends DataSource {

	public static final String DATABASE_NAME = "tanita.db";

	public TanitaDataSource(Context context) {
		super(new DatabaseHelper(context, DATABASE_NAME, TanitaDataTable.TABLE_NAME, TanitaDataTable.CREATE_DATABASE_TABLE));
	}

	@Override
	protected TanitaData convertToAbstractData(Cursor cursor) {
		TanitaData td = new TanitaData();
		td.setId(cursor.getInt(TanitaDataTable.Column.ID.ordinal()));
		td.setPerson(cursor.getLong(TanitaDataTable.Column.PERSON.ordinal()));

		long rawDate = cursor.getLong(TanitaDataTable.Column.DATE.ordinal());
		td.setDate(new Date(rawDate));

		td.setVisceralFat(cursor.getInt(TanitaDataTable.Column.VISCERAL_FAT.ordinal()));
		td.setDailyCaloricIntake(cursor.getInt(TanitaDataTable.Column.DAILY_CALORIC_INTAKE.ordinal()));
		td.setMetabolicAge(cursor.getInt(TanitaDataTable.Column.METABOLIC_AGE.ordinal()));

		td.setWeight(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.WEIGHT.ordinal())));
		td.setBodyFatTotal(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.BODY_FAT_TOTAL.ordinal())));
		td.setBodyFatLeftArm(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.BODY_FAT_LEFT_ARM.ordinal())));
		td.setBodyFatRightArm(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.BODY_FAT_RIGHT_ARM.ordinal())));
		td.setBodyFatRightLeg(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.BODY_FAT_RIGHT_LEG.ordinal())));
		td.setBodyFatLeftLeg(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.BODY_FAT_LEFT_LEG.ordinal())));
		td.setBodyFatTrunk(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.BODY_FAT_TRUNK.ordinal())));
		td.setMuscleMassTotal(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.MUSCLE_MASS_TOTAL.ordinal())));
		td.setMuscleMassLeftArm(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.MUSCLE_MASS_LEFT_ARM.ordinal())));
		td.setMuscleMassRightArm(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.MUSCLE_MASS_RIGHT_ARM.ordinal())));
		td.setMuscleMassRightLeg(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.MUSCLE_MASS_RIGHT_LEG.ordinal())));
		td.setMuscleMassLeftLeg(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.MUSCLE_MASS_LEFT_LEG.ordinal())));
		td.setMuscleMassTrunk(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.MUSCLE_MASS_TRUNK.ordinal())));
		td.setPhysicRating(cursor.getInt(TanitaDataTable.Column.PHYSIC_RATING.ordinal()));
		td.setBodyWaterPercentage(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.BODY_WATER_PERCENTAGE.ordinal())));
		td.setBoneMass(Double.valueOf(cursor.getDouble(TanitaDataTable.Column.BONE_MASS.ordinal())));

		return td;
	}

	@Override
	protected List<String> getAllColumns() {
		List<String> allColumns = new ArrayList<String>();
		allColumns.add(TanitaDataTable.Column.ID.toString());
		allColumns.add(TanitaDataTable.Column.PERSON.toString());
		allColumns.add(TanitaDataTable.Column.DATE.toString());
		allColumns.add(TanitaDataTable.Column.WEIGHT.toString());
		allColumns.add(TanitaDataTable.Column.DAILY_CALORIC_INTAKE.toString());
		allColumns.add(TanitaDataTable.Column.BODY_FAT_TOTAL.toString());
		allColumns.add(TanitaDataTable.Column.BODY_FAT_LEFT_ARM.toString());
		allColumns.add(TanitaDataTable.Column.BODY_FAT_RIGHT_ARM.toString());
		allColumns.add(TanitaDataTable.Column.BODY_FAT_RIGHT_LEG.toString());
		allColumns.add(TanitaDataTable.Column.BODY_FAT_LEFT_LEG.toString());
		allColumns.add(TanitaDataTable.Column.BODY_FAT_TRUNK.toString());
		allColumns.add(TanitaDataTable.Column.MUSCLE_MASS_TOTAL.toString());
		allColumns.add(TanitaDataTable.Column.MUSCLE_MASS_LEFT_ARM.toString());
		allColumns.add(TanitaDataTable.Column.MUSCLE_MASS_RIGHT_ARM.toString());
		allColumns.add(TanitaDataTable.Column.MUSCLE_MASS_RIGHT_LEG.toString());
		allColumns.add(TanitaDataTable.Column.MUSCLE_MASS_LEFT_LEG.toString());
		allColumns.add(TanitaDataTable.Column.MUSCLE_MASS_TRUNK.toString());
		allColumns.add(TanitaDataTable.Column.PHYSIC_RATING.toString());
		allColumns.add(TanitaDataTable.Column.METABOLIC_AGE.toString());
		allColumns.add(TanitaDataTable.Column.BODY_WATER_PERCENTAGE.toString());
		allColumns.add(TanitaDataTable.Column.VISCERAL_FAT.toString());
		allColumns.add(TanitaDataTable.Column.BONE_MASS.toString());
		return allColumns;
	}
}

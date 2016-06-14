package ca.charland.tanita.db;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ca.charland.tanita.base.db.Data;
import ca.charland.tanita.db.TanitaDataTable.Column;

public class TanitaDataHelperTest {

	@Test
	public void testGetPreviousEmpty() {
		Column column = Column.BODY_FAT_LEFT_ARM;
		List<Data> tanitaData = new ArrayList<Data>();
		double previous = TanitaDataHelper.getPrevious(tanitaData, column);
		assertThat(previous, is(0d));
	}

	@Test
	public void testGetPrevious() {
		Column column = Column.BODY_FAT_LEFT_ARM;
		List<Data> tanitaData = new ArrayList<Data>();
		TanitaData td = new TanitaData();
		td.setBodyFatLeftArm(5);
		tanitaData.add(td);

		TanitaData td2 = new TanitaData();
		td2.setBodyFatLeftArm(0);
		tanitaData.add(td2);
		double previous = TanitaDataHelper.getPrevious(tanitaData, column);
		assertThat(previous, is(5d));
	}

	@Test
	public void testGetAverageEmpty() {
		Column column = Column.BODY_FAT_TRUNK;
		List<Data> tanitaData = new ArrayList<Data>();
		double previous = TanitaDataHelper.getAverage(tanitaData, column);
		assertThat(previous, is(0d));
	}

	@Test
	public void testGetAverage() {
		Column column = Column.BODY_FAT_LEFT_ARM;
		List<Data> tanitaData = new ArrayList<Data>();
		TanitaData td = new TanitaData();
		td.setBodyFatLeftArm(5);
		tanitaData.add(td);

		TanitaData td2 = new TanitaData();
		td2.setBodyFatLeftArm(15);
		tanitaData.add(td2);

		double previous = TanitaDataHelper.getAverage(tanitaData, column);
		assertThat(previous, is(10d));
	}

}

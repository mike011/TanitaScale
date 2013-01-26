package ca.charland.tanita;

import ca.charland.tanita.db.TanitaData;

class TestBaseActivity extends BodyFatLeftArmActivity {

	private final TanitaData tanitaData;

	public TestBaseActivity() {
		tanitaData = new TanitaData();
	}

	@Override
	protected TanitaData getTanitaData() {
		return tanitaData;
	}

	@Override 
	protected void createDataSource() {
	}

	@Override
	protected void setData() {
	}
	
	@Override
	protected void setSex(int id, int female) {
	}

}
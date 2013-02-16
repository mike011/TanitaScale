package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataSource;
import ca.charland.tanita.db.TestTanitaDataSource;

class TestBaseActivity extends BodyFatLeftArmActivity {

	public TestBaseActivity() {
	}

	@Override 
	protected TanitaDataSource getDataSource() {
		return new TestTanitaDataSource();
	}

	@Override
	protected void setData() {
	}
	
	@Override
	protected void setSex(int id, int female) {
	}

}
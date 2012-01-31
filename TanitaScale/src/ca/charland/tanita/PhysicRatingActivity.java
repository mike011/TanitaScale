package ca.charland.tanita;

import roboguice.inject.ContentView;
import ca.charland.tanita.manage.PickActivity;

/**
 * The Class PhysicRatingActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.physic_rating)
public class PhysicRatingActivity extends AbstractNextActivity {

	/** {@inheritDoc} */
	@Override	
	public Class<?> getNextClass() {
		return PickActivity.class;
	}
}

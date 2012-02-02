package ca.charland.tanita;

import roboguice.inject.ContentView;
import android.content.ContentValues;
import ca.charland.tanita.manage.PersonHomeActivity;

/**
 * The Class PhysicRatingActivity.
 * 
 * @author mcharland
 */
@ContentView(R.layout.physic_rating)
public class PhysicRatingActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	public Class<?> getNextClass() {
		return PersonHomeActivity.class;
	}

	/** {@inheritDoc} */
	@Override
	protected ContentValues getValues() {
		// TODO Auto-generated method stub
		return null;
	}
}

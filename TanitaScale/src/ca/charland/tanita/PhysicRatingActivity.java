package ca.charland.tanita;

import android.content.ContentValues;
import ca.charland.tanita.manage.PersonHomeActivity;

/**
 * The Class PhysicRatingActivity.
 * 
 * @author mcharland
 */
public class PhysicRatingActivity extends AbstractBaseActivity {

	/** {@inheritDoc} */
	@Override
	int getLayoutResID() {
		return R.layout.physic_rating;
	}
	
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

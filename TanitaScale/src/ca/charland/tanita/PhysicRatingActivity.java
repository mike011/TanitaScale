package ca.charland.tanita;

import ca.charland.tanita.db.TanitaDataTable;
import ca.charland.tanita.manage.PersonHomeActivity;

/**
 * The Class PhysicRatingActivity.
 * 
 * @author mcharland
 */
public class PhysicRatingActivity extends AbstractTextViewActivity {

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
	protected TanitaDataTable.Column getColumnName() {
		return TanitaDataTable.Column.PHYSIC_RATING;
	}

	/** {@inheritDoc} */
	@Override
	protected int getStringID() {
		return R.string.physic_rating;
	}
}

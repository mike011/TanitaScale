package ca.charland.tanita;

import android.os.Bundle;
import ca.charland.R;

/**
 * @author mcharland
 */
public abstract class BodyFatBaseActivity extends TextViewActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setSex(R.id.body_fat_image, R.drawable.body_fat_female);
	}
}

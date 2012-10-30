package ca.charland.tanita;

import android.os.Bundle;

public abstract class BodyFatBaseActivity extends AbstractTextViewActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setSex(R.id.body_fat_image, R.drawable.body_fat_female);
	}
}

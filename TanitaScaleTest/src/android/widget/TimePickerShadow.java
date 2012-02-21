package android.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.xtremelabs.robolectric.internal.Implements;
import com.xtremelabs.robolectric.internal.RealObject;

@Implements(TimePicker.class)
public class TimePickerShadow {

	@RealObject private TimePicker realPoint;
	
    public void __constructor__(Context context, AttributeSet attrs, int defStyle) {
    	
    }
    
	public Integer getCurrentHour() {
		return 3;
	}
}

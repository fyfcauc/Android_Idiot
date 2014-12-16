package com.example.fyf;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class MyNightModeView extends View implements HasNightMode{

	public static final int[] STATE_NIGHT = {
        R.attr.night_mode
    };
	private boolean mNightMode;
	public MyNightModeView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MyNightModeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public MyNightModeView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setNightMode(boolean nightMode) {
		if (mNightMode == nightMode) {
			return;
		} else {
			mNightMode = nightMode;
			refreshDrawableState();
		}
	}
	
	@Override
    public int[] onCreateDrawableState(int extraSpace) {
		final int[] drawableState = super.onCreateDrawableState(extraSpace
                + STATE_NIGHT.length);
		if (mNightMode) {
            mergeDrawableStates(drawableState, STATE_NIGHT);
        }
        return drawableState;
    }
	
}

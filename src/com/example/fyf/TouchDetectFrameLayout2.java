package com.example.fyf;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class TouchDetectFrameLayout2 extends FrameLayout {

	private String TAG = "layer3";
	
	public TouchDetectFrameLayout2(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public TouchDetectFrameLayout2(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public TouchDetectFrameLayout2(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	public void setTAG(String tag) {
		TAG = "Touch_" + tag;
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		Log.e(TAG, "dispatchTouchEvent "
				+ SystemUtils.motionEventToString(ev));
		return super.dispatchTouchEvent(ev);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		Log.e(TAG, "onInterceptTouchEvent "
				+ SystemUtils.motionEventToString(ev));
		return super.onInterceptTouchEvent(ev);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.e(TAG, "onTouchEvent "
				+ SystemUtils.motionEventToString(event));
		return super.onTouchEvent(event);
//		return true;
	};
}

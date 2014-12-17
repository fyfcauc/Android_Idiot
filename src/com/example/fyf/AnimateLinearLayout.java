package com.example.fyf;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

public class AnimateLinearLayout extends LinearLayout {

	public AnimateLinearLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public AnimateLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public AnimateLinearLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Log.e("FYF", "AnimateLinearLayout onDraw");
	}
	
	@Override
	protected void dispatchDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.dispatchDraw(canvas);
		Log.e("FYF", "Begin draw the activity's view!");
	}
}

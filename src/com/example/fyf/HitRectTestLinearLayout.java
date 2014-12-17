package com.example.fyf;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class HitRectTestLinearLayout extends LinearLayout {

	public HitRectTestLinearLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public HitRectTestLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public HitRectTestLinearLayout(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	
		protected void dispatchDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			super.dispatchDraw(canvas);
			SystemUtils.printChildRect(this, "FYF");
		}
}

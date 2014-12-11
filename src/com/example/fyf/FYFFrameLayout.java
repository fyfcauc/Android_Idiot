package com.example.fyf;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class FYFFrameLayout extends LinearLayout {

	public FYFFrameLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public FYFFrameLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public FYFFrameLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	};

	public void addViewSlience(View child, int index, android.view.ViewGroup.LayoutParams params,
            boolean preventRequestLayout) {
		addViewInLayout(child, index, params, preventRequestLayout);
	}
	
}

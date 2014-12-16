package com.example.fyf;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TouchLinearLayout extends LinearLayout {

	public TouchLinearLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public TouchLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public TouchLinearLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	private ImageView mImageView;
	private View mTouchView;
	
	protected void onFinishInflate() {
		super.onFinishInflate();
		mImageView = (ImageView)findViewById(R.id.IMG1);
		mTouchView = findViewById(R.id.TouchView);
//		mTouchView.scrollTo(100, 100);
//		mImageView.scrollTo(100, 100);
	};
}

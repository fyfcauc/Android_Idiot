package com.example.fyf;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class SimpleView extends View {

	private static final String TAG = "SimpleView";
	private int mW = 500;
	private int mH = 500;
	public SimpleView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public SimpleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public SimpleView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		Log.e(TAG, "onAttachedToWindow");
		SystemUtils.printStack(TAG);
	}
	
	@Override
	protected void onDetachedFromWindow() {
		// TODO Auto-generated method stub
		super.onDetachedFromWindow();
		Log.e(TAG, "onDetachedToWindow");
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
//		SystemUtils.printStack(TAG);
	}
	
	@Override
	public void layout(int l, int t, int r, int b) {
		super.layout(l, t, r, b);
		Log.e(TAG, "layout");
	}
	
	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		// TODO Auto-generated method stub
		super.onLayout(changed, left, top, right, bottom);
		Log.e(TAG, "onLayout");
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		Log.e(TAG, "onMeasure " + MeasureSpec.getSize(widthMeasureSpec)
				+ " " + MeasureSpec.getSize(heightMeasureSpec));
//		SystemUtils.printStack(TAG);
		setMeasuredDimension(MeasureSpec.makeMeasureSpec(mW-=10, MeasureSpec.EXACTLY),
				MeasureSpec.makeMeasureSpec(mH-=10, MeasureSpec.EXACTLY));
	}

}

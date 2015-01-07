package com.example.fyf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.View;

public class TestAttachView extends View {

	private int square = 1000;
	public TestAttachView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public TestAttachView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public TestAttachView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		mScaleGestureDetector = new ScaleGestureDetector(getContext(),
				new OnScaleGestureListener() {
					
					@Override
					public void onScaleEnd(ScaleGestureDetector arg0) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public boolean onScaleBegin(ScaleGestureDetector arg0) {
						// TODO Auto-generated method stub
						return true;
					}
					
					@Override
					public boolean onScale(ScaleGestureDetector arg0) {
						// TODO Auto-generated method stub
						float scale = arg0.getScaleFactor();
						Log.e("FYF", "onScale " + scale);
						TestAttachView.this.setScaleX(scale * TestAttachView.this.getScaleX());
						TestAttachView.this.setScaleY(scale * TestAttachView.this.getScaleY());
						return false;
					}
				});
		Log.e("FYF", "onAttachedToWindow");
	};
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		Log.e("FYF", "TestAttachView onMeasure");
	}
	
	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		// TODO Auto-generated method stub
		super.onLayout(changed, left, top, right, bottom);
		Log.e("FYF", "TestAttachView onLayout");
	}
	
//	@Override
//	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//		// TODO Auto-generated method stub
////		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//		
//		setMeasuredDimension(square, square);
//		square -= 10;
//	}
	
	ScaleGestureDetector mScaleGestureDetector;
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
//		if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
//			Log.e("FYF", "ACTION_DOWN " + event.getX() + " " + event.getY());
//		} else if (event.getActionMasked() == MotionEvent.ACTION_POINTER_DOWN) {
//			Log.e("FYF", "ACTION_POINTER_DOWN " + event.getX(event.getPointerId(1))
//					+ " " + event.getY(event.getPointerId(1)));
//		}
		
		boolean res = mScaleGestureDetector.onTouchEvent(event);
		Log.e("FYF", "TestAttachView onTouchEvent " + res);
		return res;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		Log.e("FYF", "onDraw");
		super.onDraw(canvas);
		Paint p = new Paint();
		p.setColor(Color.RED);
		p.setTextSize(22); 
		canvas.drawCircle(0, 0, 100, p);
		canvas.drawText(String.valueOf(square), 100, 100, p);
		Log.e("FYF", "setScaleX called");
	}
	
	@Override
	protected void onDetachedFromWindow() {
		// TODO Auto-generated method stub
		super.onDetachedFromWindow();
		Log.e("FYF", "onDetachedFromWindow");
	}
	
}

package com.example.fyf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.ImageView;

public class TouchView extends ImageView {

	private final static String TAG = "TouchView";
	public TouchView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public TouchView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	private final OnGestureListener mOnGestureListener = 
			new GestureDetector.SimpleOnGestureListener() {
		@Override
		public boolean onDown(MotionEvent e) {
			Log.e(TAG, "onDown");
			return true;
		}
		
		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			Log.e(TAG, "onSingleTapUp");
			return true;
		}
		
		@Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
			if (e1 == null || e2 == null) {
				return false;
			}
			Log.e(TAG, "onScroll " + distanceX + " " + distanceY
					+ " " + getScrollX() + " " + getScrollY());
			scrollBy((int)distanceX, (int)distanceY);
			return true;
		}
		
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
			Log.e(TAG, "onFling " + velocityX + " " + velocityY);
			return true;
		};
	};
	private final GestureDetector mGesture = new GestureDetector(getContext(), mOnGestureListener);
	
	public boolean onTouchEvent(MotionEvent event) {
		Log.e(TAG, "onTouchEvent");
		return mGesture.onTouchEvent(event);
	};
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint p = new Paint();
		p.setColor(Color.rgb(255, 0, 0));
		canvas.drawCircle(100, 100, 100, p);
	}

	public TouchView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
//		setClickable(true);
//		setLongClickable(true);
		// TODO Auto-generated constructor stub
	}

}

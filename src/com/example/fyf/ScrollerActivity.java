package com.example.fyf;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class ScrollerActivity extends Activity {

	private Scroller mScroller; 
	private static final String TAG = "ScrollerActivity";
	public ScrollerActivity() {
		// TODO Auto-generated constructor stub
	}

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout l1 = new LinearLayout(this);
//		LinearLayout l2 = new LinearLayout(this);
		LinearLayout.LayoutParams p0 = new LinearLayout.LayoutParams    
		        (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		l1.setOrientation(LinearLayout.VERTICAL);
		l1.setLayoutParams(p0);
		mScroller = new Scroller(this);
		setContentView(l1);
		MyButton button = new MyButton(this);
		button.setText("I AM MOVING, HAAAAAAAAAAAAAAAA");
		button.setTextColor(Color.rgb(255, 0, 0));
		button.setTextSize(25);
		//		button.setBackgroundResource(R.drawable.home);
		button.setLayoutParams(p0);
		l1.addView(button);
		mScroller.startScroll(-500, -500, 500, 500, 10000);
		button.beginScroll();
		
	};
	
	private class MyButton extends Button {
		public MyButton(Context ctx) {
			// TODO Auto-generated constructor stub
			super(ctx);
		}
		
		public void beginScroll() {
			if (mScroller.computeScrollOffset()) {
				int curx = mScroller.getCurrX();
				int cury = mScroller.getCurrY();
				Log.e(TAG, "computeScroll " + curx + " " + cury);
				scrollTo(curx, cury);
				post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						beginScroll();
					}
				});
			}
		}
		
//		@Override
//		public void computeScroll() {
//			// TODO Auto-generated method stub
//			super.computeScroll();
//			if (mScroller.computeScrollOffset()) {
//				int curx = mScroller.getCurrX();
//				int cury = mScroller.getCurrY();
//				Log.e(TAG, "computeScroll " + curx + " " + cury);
//				scrollTo(curx, cury);
//				postInvalidate();
//			}
//		}
	}
}

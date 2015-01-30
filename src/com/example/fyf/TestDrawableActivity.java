package com.example.fyf;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class TestDrawableActivity extends Activity {

	public static class myLinearLayout extends LinearLayout {

		public myLinearLayout(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
		
		public myLinearLayout(Context context, AttributeSet attrs) {
			super(context, attrs);
			// TODO Auto-generated constructor stub
		}
		
		public myLinearLayout(Context context, AttributeSet attrs, int defStyle) {
			super(context, attrs, defStyle);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public boolean onInterceptTouchEvent(MotionEvent ev) {
			// TODO Auto-generated method stub
//			return super.onInterceptTouchEvent(ev);
			int action = MotionEventCompat.ACTION_MASK & ev.getAction();
			
			if (action == MotionEvent.ACTION_DOWN) {
				return false;
			} else {
				return true;
			}
		}
		
		@Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO Auto-generated method stub
			Log.e("FYF", "myLinearLayout " + SystemUtils.motionEventToString(event));
			return true;
		}
		
	}
	
	
	public static class myView extends View {

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO Auto-generated method stub
			int action = MotionEventCompat.ACTION_MASK & event.getAction();
			Log.e("FYF", "myView " + SystemUtils.motionEventToString(event));
			if (action == MotionEvent.ACTION_DOWN) {
				getParent().requestDisallowInterceptTouchEvent(true);
			}
			
			return true;
		}
		
		public myView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
		
		public myView(Context context, AttributeSet attrs) {
			super(context, attrs);
			// TODO Auto-generated constructor stub
		}
		
		public myView(Context context, AttributeSet attrs, int defStyleAttr) {
			super(context, attrs, defStyleAttr);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			Log.e("FYF", "begin onDraw canvas SaveCount " + canvas.getSaveCount());
			super.onDraw(canvas);
			canvas.save();
			Drawable d =  getResources().getDrawable(R.drawable.bender03pb);
			int savecount1 = canvas.save();
			canvas.translate(100, 100);
			canvas.scale(1.5f, 1.5f);
			int savecount2 = canvas.save();
			canvas.rotate(90);
			canvas.skew(0.5f, 0.5f);
			Log.e("FYF", savecount1 + " " + savecount2
					+ " canvas save count: " + canvas.getSaveCount());
			d.setBounds(0,0,200,200);
			d.draw(canvas);
			canvas.restoreToCount(savecount1);
			Log.e("FYF", "after restore savecount2, canvas save count: " + canvas.getSaveCount());
			d.draw(canvas);
			canvas.restoreToCount(savecount2);
			d.draw(canvas);
			Log.e("FYF", "after restore savecount1, canvas save count: " + canvas.getSaveCount());
			canvas.restore();
			Log.e("FYF", "end onDraw canvas SaveCount " + canvas.getSaveCount());
		}
	}
	
	public TestDrawableActivity() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_drawable);
		View v = findViewById(R.id.l1);
		Button v1 = (Button)v.findViewById(R.id.b1);
		v1.setTag("B1");
		Button v2 = (Button)v.findViewById(R.id.b2);
		v2.setTag(1);
		Button v3 = (Button)(v.findViewWithTag(1));
		View v4 = v.findViewWithTag("vvv1");
		Log.e("FYF", "find tag " + v3.getText() + " " + (v4 == null));
	}
}

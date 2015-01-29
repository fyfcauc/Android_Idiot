package com.example.fyf;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class TestDrawableActivity extends Activity {

	public static class myView extends View {

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
			super.onDraw(canvas);
			Drawable d =  getResources().getDrawable(R.drawable.bender03pb);
			canvas.save();
			canvas.translate(100, 100);
			d.setBounds(0,0,200,200);
			d.draw(canvas);
			canvas.restore();
			d.setBounds(0,0,100,100);
			d.draw(canvas);
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

package com.example.fyf;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class TestTranslationActivity extends Activity {

	public TestTranslationActivity() {
		// TODO Auto-generated constructor stub
	}

	ImageView im1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_translation);
		im1 = (ImageView)findViewById(R.id.imageView1);
		im1.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				Log.e("FYF", "im1: " + im1.getLeft() + " " + im1.getTop()
						+ " " + im1.getRight() + " " + im1.getBottom());
				Log.e("FYF", "img1  onTouch " + arg1.getX() + " " + arg1.getY());
				return false;
			}
		});;
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
}

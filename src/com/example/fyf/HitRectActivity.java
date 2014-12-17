package com.example.fyf;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

public class HitRectActivity extends Activity {
	
	public HitRectActivity() {
		// TODO Auto-generated constructor stub
	}

	private ViewGroup mRootView;
	private static final String TAG = "HitRect";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hit_rest);
		mRootView = (ViewGroup)findViewById(R.id.subRootView);
		// During onCreate(). you can not get correct hitRect!!!!!!!!!!!!!
//		printChildRect(mRootView);
	}
}

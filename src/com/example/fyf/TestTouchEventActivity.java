package com.example.fyf;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class TestTouchEventActivity extends Activity {

	public TestTouchEventActivity() {
		// TODO Auto-generated constructor stub
	}
	
	private FrameLayout mL1;
	private FrameLayout mL2;
	private FrameLayout mL3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_touch_event);
		mL1 = (FrameLayout)findViewById(R.id.layer1);
//		mL1.setClickable(true);
		mL2 = (FrameLayout)findViewById(R.id.layer2);
//		mL2.setClickable(true);
		mL3 = (FrameLayout)findViewById(R.id.layer3);
//		mL3.setClickable(true);
	}
}

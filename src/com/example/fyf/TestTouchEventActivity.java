package com.example.fyf;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

public class TestTouchEventActivity extends Activity {

	public TestTouchEventActivity() {
		// TODO Auto-generated constructor stub
	}
	
	private FrameLayout mL1;
	private FrameLayout mL2;
	private FrameLayout mL3;
	private Button mButton;
	
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
		mButton = (Button)findViewById(R.id.button1);
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.e("FYF", "onClick");
				ViewGroup.LayoutParams mL = mButton.getLayoutParams();
				mL.width += 50;
			}
		});
//		mButton.setEnabled(false);
	}
}

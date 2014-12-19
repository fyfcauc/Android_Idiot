package com.example.fyf;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestCoverActivity extends Activity {

	public TestCoverActivity() {
		// TODO Auto-generated constructor stub
	}

	private Button mButton1;
	private Button mButton2;
	
	private static final String TAG = "TestCoverActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_cover_frame_layout);
		mButton1 = (Button)findViewById(R.id.button1);
		mButton2 = (Button)findViewById(R.id.button2);
		mButton1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.e(TAG, "mButton1 clicked");
			}
		});
		
		mButton2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.e(TAG, "mButton2 clicked");
			}
		});
	}
}

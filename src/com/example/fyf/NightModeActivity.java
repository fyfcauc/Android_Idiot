package com.example.fyf;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NightModeActivity extends Activity {

	public NightModeActivity() {
		// TODO Auto-generated constructor stub
	}

	private Button mButton;
	private View mRootView;
	private boolean mCurrentNightMode;
	
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_night_mode);
		mRootView = findViewById(R.id.root_view);
		mButton = (Button)findViewById(R.id.nightModeButton);
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mCurrentNightMode = mCurrentNightMode ? false:true;
				NightModeUtils.setNightModeForViewAndChilds(mRootView, mCurrentNightMode);
			}
		});
	};
}

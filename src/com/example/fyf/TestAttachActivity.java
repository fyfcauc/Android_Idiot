package com.example.fyf;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestAttachActivity extends Activity {

	public TestAttachActivity() {
		// TODO Auto-generated constructor stub
	}
	
	private Button mButton;
	private View mView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_attach);
		mView = findViewById(R.id.view1);
		mButton = (Button)findViewById(R.id.button1);
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mView.setPivotX(0.0f);
				mView.setScaleX(0.5f);
//				mView.setScaleY(1.0f);
				if (mView.getVisibility() == View.GONE) {
					mView.setVisibility(View.VISIBLE);
				} else if (mView.getVisibility() == View.VISIBLE) {
					mView.setVisibility(View.INVISIBLE);
				} else {
					mView.setVisibility(View.GONE);
				}
			}
		});
	}

}

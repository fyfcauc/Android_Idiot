package com.example.fyf;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestServiceActivity extends Activity {

	public TestServiceActivity() {
		// TODO Auto-generated constructor stub
	}

	TestProxy mProxy;
	private Button mHelloButton;
	private Button mKillButton;
	private Button mUnbindButton;
	private Button mBindButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_test);
		mProxy = new TestProxy(this.getApplicationContext());
		mHelloButton = (Button)findViewById(R.id.hello_button);
		mKillButton = (Button)findViewById(R.id.kill_button);
		mHelloButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mProxy.sayHello();
			}
		});
		
		mKillButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mProxy.killService();
			}
		});
		mUnbindButton = (Button)findViewById(R.id.button3);
		mUnbindButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mProxy.unbind();
			}
		});
		
		mBindButton = (Button)findViewById(R.id.bind_button);
		mBindButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mProxy.init();
			}
		});
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mProxy.unbind();
	}
}

package com.example.fyf;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class TestDrawActivity extends Activity {

	public TestDrawActivity() {
		// TODO Auto-generated constructor stub
	}

	private Button mButton;
	private ViewGroup L1;
	private ViewGroup L2;
	private View L3;
	private View L4;
	private int offset = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.draw_call_test);
		mButton = (Button)findViewById(R.id.Button1);
		L1 = (ViewGroup)findViewById(R.id.L1);
		L2 = (ViewGroup)findViewById(R.id.L2);
		L3 = findViewById(R.id.Img1);
		L4 = findViewById(R.id.Img2);
		L1.setClickable(true);
		L2.setClickable(true);
		L3.setClickable(true);
		L4.setClickable(true);
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//					L3.invalidate();
//				L2.invalidate();
//					L1.invalidate();
				L3.setTop(--offset);
			}
		});
		
		OnClickListener clickListner = new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Log.e("FYF", arg0.getId() + " onClick");
				// TODO Auto-generated method stub
				switch (arg0.getId()) {
					case R.id.L1:
						L1.invalidate();
						break;
					case R.id.L2:
						L2.invalidate();
						break;
					case R.id.Img1:
						L3.invalidate();
						break;
					case R.id.Img2:
//						L4.invalidate();
//						L1.removeViewInLayout(L4);
						L2.removeViewInLayout(L4);
						break;
					default:
						break;
						
				}
			}
		};
		
		L1.setOnClickListener(clickListner);
		L2.setOnClickListener(clickListner);
		L3.setOnClickListener(clickListner);
		L4.setOnClickListener(clickListner);
//		getWindow().setBackgroundDrawable(new ColorDrawable(0x00000000));
	}
}

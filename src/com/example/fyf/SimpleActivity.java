package com.example.fyf;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class SimpleActivity extends Activity {

	private Button mButton;
	private View mView;
	private ViewGroup mRootView;
	private int mW = 500;
	private int mH = 500;
	public SimpleActivity() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fyf_simple);
		mButton = (Button)findViewById(R.id.inval);
		mView = findViewById(R.id.simple);
		mRootView = (ViewGroup)findViewById(R.id.root);
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				mView.measure(mW--, mH--);
//				mView.requestLayout();
				Log.e("SimpleView", "onClick " + mW + " " + mH + " " +
						mView.getWidth() + " " + mView.getHeight());
				
//				mView.layout(0, 0, mW-=10, mH-=10);
//				mView.forceLayout();
//				mView.invalidate();
				mView.measure(MeasureSpec.makeMeasureSpec(300, MeasureSpec.EXACTLY),
		                MeasureSpec.makeMeasureSpec(300, MeasureSpec.EXACTLY));
//				mView.forceLayout();
//				mView.requestLayout();
				mRootView.requestLayout();
//				ViewGroup.LayoutParams prams;
//		        prams = mView.getLayoutParams();
//		        prams.width = mW--;
//		        prams.height = mH--;
//		        mView.setLayoutParams(prams);
			}
		});
		mRootView.addView(new MyLinearLayout(getBaseContext()));
		mRootView.addView(new MyLinearLayout(getBaseContext()));
	}
}

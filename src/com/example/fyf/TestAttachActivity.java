package com.example.fyf;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class TestAttachActivity extends Activity {

	public TestAttachActivity() {
		// TODO Auto-generated constructor stub
	}
	
	private static class MyLinearLayout extends LinearLayout {

		private int S = 50;
		public MyLinearLayout(Context context, AttributeSet attrs, int defStyle) {
			super(context, attrs, defStyle);
			// TODO Auto-generated constructor stub
		}
		
		public MyLinearLayout(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
		
		public MyLinearLayout(Context context, AttributeSet attrs) {
			super(context, attrs);
			// TODO Auto-generated constructor stub
		}
		
		
		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
			// TODO Auto-generated method stub
			Log.e("FYF", "onLayout");
			super.onLayout(changed, l, t, r, b);
			int childNum = getChildCount();
			for (int i = 0; i < childNum; i++) {
				View child = getChildAt(i);
				child.layout(0, 0, S, S);
				S+=50;
			}
		}
		
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

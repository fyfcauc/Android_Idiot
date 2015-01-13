package com.example.fyf;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class TestInflateActivity extends Activity {

	private static class TestInflateLinearLayout extends LinearLayout {

		public TestInflateLinearLayout(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			init(context);
		}
		
		public TestInflateLinearLayout(Context context, AttributeSet attrs) {
			super(context, attrs);
			// TODO Auto-generated constructor stub
			init(context);
		}
		
		public TestInflateLinearLayout(Context context, AttributeSet attrs,
				int defStyle) {
			super(context, attrs, defStyle);
			// TODO Auto-generated constructor stub
			init(context);
		}
		
		private void init(Context context) {
			LayoutInflater inflater = LayoutInflater.from(context);
			inflater.inflate(R.layout.sub_layout, this, true);
		}
		
	}
	
	
	public TestInflateActivity() {
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
	}
}

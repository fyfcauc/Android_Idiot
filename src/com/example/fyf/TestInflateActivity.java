package com.example.fyf;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
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
	
	private static class myImageView extends ImageView {

		public myImageView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
		
		public myImageView(Context context, AttributeSet attrs) {
			super(context, attrs);
			// TODO Auto-generated constructor stub
		}
		
		public myImageView(Context context, AttributeSet attrs, int defStyle) {
			super(context, attrs, defStyle);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			super.onDraw(canvas);
			Log.e("FYF", "myImageView onDraw");
		}
		
	}
	
	public TestInflateActivity() {
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.e("FYF", "scrollX is " + img1.getScrollY());
	}
	
	View img1;
	Button b1;
	View L1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		img1 = findViewById(R.id.imageView1);
		b1 = (Button)findViewById(R.id.button1);
		L1 = findViewById(R.id.layout1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				img1.scrollBy(0, 20);
//				img1.setPadding(img1.getPaddingLeft(), img1.getPaddingTop() - 10,
//						img1.getPaddingRight(), img1.getPaddingBottom());
//				Log.e("FYF", "scrollX is " + img1.getScrollY() + " paddingTop " + img1.getPaddingTop());
				for (int i = 1; i <= 100; i++) {
					img1.invalidate();
				}
			}
		});
	}
}

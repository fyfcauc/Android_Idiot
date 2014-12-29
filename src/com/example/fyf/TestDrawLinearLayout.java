package com.example.fyf;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TestDrawLinearLayout extends LinearLayout {

	public static class TestDrawImageView extends ImageView {

		public TestDrawImageView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
		
		public TestDrawImageView(Context context, AttributeSet attrs) {
			super(context, attrs);
			// TODO Auto-generated constructor stub
		}
		
		public TestDrawImageView(Context context, AttributeSet attrs, int defStyle) {
			super(context, attrs, defStyle);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void layout(int l, int t, int r, int b) {
			// TODO Auto-generated method stub
			super.layout(l, t, r, b);
			Log.e("FYF", getId() + " ImageView layout");
		}
		
		@Override
		protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
			// TODO Auto-generated method stub
			Log.e("FYF", getId() + " ImageView onMeasure");
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		}
		
		
		@Override
		public void draw(Canvas canvas) {
			// TODO Auto-generated method stub
			super.draw(canvas);
			Log.e("FYF", getId() + " ImageView draw");
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			super.onDraw(canvas);
			Log.e("FYF", getId() + " ImageView onDraw");
		}
		
	}
	
	public TestDrawLinearLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public TestDrawLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public TestDrawLinearLayout(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.draw(canvas);
		Log.e("FYF", getId() + "TestDrawLinearLayout draw");
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Log.e("FYF", getId() + "TestDrawLinearLayout on draw");
	}
}

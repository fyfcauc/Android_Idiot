package com.example.fyf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class TestAttachView extends View {

	private int square = 1000;
	public TestAttachView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public TestAttachView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public TestAttachView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		Log.e("FYF", "onAttachedToWindow");
	};
	
//	@Override
//	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//		// TODO Auto-generated method stub
////		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//		
//		setMeasuredDimension(square, square);
//		square -= 10;
//	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		Log.e("FYF", "onDraw");
		super.onDraw(canvas);
		Paint p = new Paint();
		p.setColor(Color.RED);
		p.setTextSize(22); 
		canvas.drawCircle(0, 0, 100, p);
		canvas.drawText(String.valueOf(square), 100, 100, p);
		Log.e("FYF", "setScaleX called");
	}
	
	@Override
	protected void onDetachedFromWindow() {
		// TODO Auto-generated method stub
		super.onDetachedFromWindow();
		Log.e("FYF", "onDetachedFromWindow");
	}
	
}

package com.example.fyf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class FYFView extends View {
	int mX = 100;
	int mY = 100;
	Paint mPaint;
	private static int width = 1000;
	private static int height = 1000;
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {  
        // TODO Auto-generated method stub
		Log.e("FYF", "onMeasure " + widthMeasureSpec + " " + heightMeasureSpec);
        setMeasuredDimension(500, 500);  
//      super.onMeasure(widthMeasureSpec, heightMeasureSpec);  
    }
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
			mX = (int) event.getX();
			mY = (int) event.getY();
		}
		return super.onTouchEvent(event);
	}
	
	private void init() {
		mPaint = new Paint(); //设置一个笔刷大小是3的黄色的画笔  
		mPaint.setColor(Color.YELLOW);  
		mPaint.setStrokeJoin(Paint.Join.ROUND);  
		mPaint.setStrokeCap(Paint.Cap.ROUND);  
		mPaint.setStrokeWidth(3);   
		setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
            	   Log.e("TEST", "LONGCLICK!");	
//            	   invalidate();
//            	   forceLayout();
//            	   requestLayout();
            	   ViewGroup.LayoutParams prams = FYFView.this.getLayoutParams();
               prams.width = width;
               prams.height = height;
               height -= 50;
               width -= 50;
               FYFView.this.setLayoutParams(prams);
            	   return true;
            }
		});
	}
	public FYFView(Context context) {
		super(context);
		init();
		// TODO Auto-generated constructor stub
	}

	public FYFView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
		// TODO Auto-generated constructor stub
	}

	public FYFView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
		// TODO Auto-generated constructor stub
	}

	@Override
    protected void onDraw(Canvas canvas) {
		Log.e("TEST", "onDraw!");	
		canvas.drawCircle(mX, mY, 90, mPaint);   
	}
}

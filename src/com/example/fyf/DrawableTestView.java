package com.example.fyf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

public class DrawableTestView extends View {

	private ShapeDrawable mDrawable;
	public DrawableTestView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public DrawableTestView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public DrawableTestView(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
//		super.onDraw(canvas);
		mDrawable = new ShapeDrawable(new OvalShape());
	    mDrawable.getPaint().setColor(0x33ff0000);
//	    mDrawable.setBounds(0, 0, 300, 300);
	    mDrawable.setBounds(new Rect(100, 100, 200, 400));
	    mDrawable.draw(canvas);
//	    Paint p = new Paint();
//		p.setColor(Color.rgb(255, 0, 0));
//		float cx, cy, radius;
//        cx = cy = getWidth() / 2.0f;
//        radius = getWidth() / 2.8f;
//        canvas.drawCircle(cx, cy, radius, p);
	}
}

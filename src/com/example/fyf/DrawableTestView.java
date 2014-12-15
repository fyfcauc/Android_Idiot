package com.example.fyf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DrawableTestView extends View {

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
		Paint p = new Paint();
		p.setColor(Color.rgb(255, 0, 0));
		float cx, cy, radius;
        cx = cy = getWidth() / 2.0f;
        radius = getWidth() / 2.8f;
        canvas.drawCircle(cx, cy, radius, p);
	}
}

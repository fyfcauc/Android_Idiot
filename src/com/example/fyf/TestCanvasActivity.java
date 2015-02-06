package com.example.fyf;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class TestCanvasActivity extends Activity {

	public static class myView extends View {

		public myView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			init();
		}
		
		public myView(Context context, AttributeSet attrs) {
			super(context, attrs);
			// TODO Auto-generated constructor stub
			init();
		}
		
		public myView(Context context, AttributeSet attrs, int defStyleAttr) {
			super(context, attrs, defStyleAttr);
			// TODO Auto-generated constructor stub
			init();
		}
		
		Bitmap b;
		Drawable d;
		
		private void init() {
			
//			setWillNotDraw(false);
			b = BitmapFactory.decodeResource(getResources(), R.drawable.bender03pb);
			d = new BitmapDrawable(getResources(), b);
			d.setBounds(100, 100, 200, 200);
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			super.onDraw(canvas); 
			canvas.save();
			canvas.scale(-1, 1, 100, 100);
			
			canvas.drawBitmap(b, 0, 0, new Paint());
			d.draw(canvas);
			canvas.restore();
		}
		
	}
	
	public TestCanvasActivity() {
		// TODO Auto-generated constructor stub
	}

}

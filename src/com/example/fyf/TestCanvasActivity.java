package com.example.fyf;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TestCanvasActivity extends Activity {

	
	private static int Tx = 0;
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
			d.setBounds(0, 0, 500, 500);
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			// TODO Auto-generated method stub
			Log.e("FYF", "onDraw");
			super.onDraw(canvas); 
			canvas.save(); 
			
			
//			canvas.save();
//			canvas.rotate(-90f);
			canvas.rotate(-180f, getMeasuredWidth()/2, getMeasuredHeight()/2);
			canvas.translate(0, Tx);
//			canvas.restore();
//			canvas.scale(-1, -1, 100, 100);
			canvas.drawBitmap(b, 100, 100, new Paint());
//			d.draw(canvas);
			canvas.restore();
		}
		
	}
	
	public TestCanvasActivity() {
		// TODO Auto-generated constructor stub
	}
	
	Button b1;
	View v1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_canvas);
		v1 = findViewById(R.id.v1);
		b1 = (Button)findViewById(R.id.b1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Tx -= 10;
				v1.invalidate();
			}
		});
	}

}

package com.example.fyf;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class DrawableActivity extends Activity {

	private Button mButton;
	private ImageView mImageView;
	private View mRootView;
	public DrawableActivity() {
		// TODO Auto-generated constructor stub
	}

	private Bitmap TestSomeDraw() {
		Bitmap b = Bitmap.createBitmap(1000, 1000, Bitmap.Config.RGB_565);
        Canvas c = new Canvas(b);
        
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setColor(Color.rgb(255, 255, 255));
        
        float cx, cy, radius;
        cx = cy = 1000 / 2.0f;

        radius = 1000 / 2.8f;

        c.drawCircle(cx, cy, radius, p);
        
        String familyName = null;
        Typeface tf = Typeface.create(familyName, Typeface.BOLD);
        p.setColor(Color.rgb(255, 0, 0));
        p.setTypeface(tf);
        p.setTextSize((int)(1.4f * radius));
        p.setTextAlign(Paint.Align.CENTER);
        
        Rect r = new Rect();
        char[] text = new char[3];
        text[0] = 'F';
        text[1] = 'Y';
        text[2] = 'F';
        p.getTextBounds(text, 0, 2, r);
//        c.drawText(text, 0, 3, 500 / 2.0f, (500 + r.height()) / 2.0f, p);
//        c.drawPaint(p);
//        c.drawRect(new Rect(-100, -100, 0, 0), p);
//        c.scale(0.5f, 0.5f);
//        c.drawRect(new Rect(0, 0, 1000, 500), p);
//        c.scale(100, 100);
//        c.scale(1.0f, 1.0f);
        c.drawRect(new Rect(0, 0, 500, 500), p);
        c.scale(0.5f, 0.5f);
        p.setColor(Color.rgb(0, 0, 255));
        c.drawRect(new Rect(0, 0, 500, 500), p);
        c.translate(500, 500);
        p.setColor(Color.rgb(0, 255, 0));
        c.drawRect(new Rect(0, 0, 500, 500), p);
        return b;
	}
	
	private Bitmap getSnapShot() {
		Bitmap b = Bitmap.createBitmap(1000, 1000, Bitmap.Config.RGB_565);
		Canvas c = new Canvas(b);
//		c.translate(-300, 300);
//		c.scale(100, 100);
		mRootView.draw(c);
		return b;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.drawable_test);
		mButton = (Button)findViewById(R.id.button1);
		mImageView = (ImageView)findViewById(R.id.imageView1);
		mRootView = findViewById(R.id.root_view);
		mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				mImageView.setBackground(new BitmapDrawable(mRootView.getDrawingCache()));;
//				mImageView.setBackgroundResource(R.drawable.bender03pb);
//				mImageView.setImageResource(R.drawable.bender03pb);
				mImageView.setImageBitmap(TestSomeDraw());
//				mImageView.setImageBitmap(getSnapShot());
			}
		});
	}
}

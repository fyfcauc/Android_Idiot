package com.example.fyf;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class TestVKBActivity extends Activity {

	public TestVKBActivity() {
		// TODO Auto-generated constructor stub
	}

	EditText e1;
	Button b1;
	static Display sDisplay;
	
	enum InputMethod {
		ADJUST_RESIZE,
		ADJUST_PAN,
		ADJUST_UN,
	};
	InputMethod softInputMethod = InputMethod.ADJUST_UN ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_vkb);
		e1 = (EditText)findViewById(R.id.editText1);
		b1 = (Button)findViewById(R.id.b1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (softInputMethod == InputMethod.ADJUST_UN) {
					softInputMethod = InputMethod.ADJUST_RESIZE;
					getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
				} else if(softInputMethod == InputMethod.ADJUST_RESIZE) {
					softInputMethod = InputMethod.ADJUST_PAN;
					getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
				} else {
					softInputMethod = InputMethod.ADJUST_UN;
					getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
				}
				printFrameRect();
				Log.e("FYF", softInputMethod.name());
			}
		});
		sDisplay = getWindowManager().getDefaultDisplay();
	}
		
	private void printFrameRect() {
		Rect r = new Rect();
		getWindow().getDecorView().getWindowVisibleDisplayFrame(r);
		Log.e("FYF", "getWindowVisibleDisplayFrame " + r.top + " " + r.left + " " + r.bottom + " " + r.right);
		Point p = new Point();
		sDisplay.getSize(p);
		int contentTop = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
		Log.e("FYF", "Display getsize " + p.x + " " + p.y + " contentTop " + contentTop);
		Log.e("FYF", "Title bar height " + (contentTop - r.top));
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		printFrameRect();
		return super.onTouchEvent(event);
	}
}

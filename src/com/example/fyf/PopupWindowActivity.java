package com.example.fyf;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;

public class PopupWindowActivity extends Activity {

	public PopupWindowActivity() {
		// TODO Auto-generated constructor stub
	}

	Button mPopupButton;
	PopupWindow mPopupWindow;
	View mPopView;
	View mRootView;
	View mRoot2View;
	View mRoot3View;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_popup_window);
		LayoutInflater inflater =
				(LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE); 
		mPopView = inflater.inflate(R.layout.popup_window, null);
		mPopupWindow = new PopupWindow(mPopView, LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		
		// to let the popup window disappear after click other place
		mPopupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
		mPopupWindow.setFocusable(true); 
		
		mRootView = findViewById(R.id.root);
		mRoot2View = findViewById(R.id.root2);
		mRoot3View = findViewById(R.id.root3);
		
		mPopupButton = (Button)findViewById(R.id.button1);
		mPopupButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.e("FYF", "showAsDropDown");
				
				mPopupWindow.showAsDropDown(mRootView, -100, -100);
//				mPopupWindow.showAsDropDown(mRoot2View);
//				mPopupWindow.showAsDropDown(null, 0, mPopView.getHeight());
			}
		});
	}
}

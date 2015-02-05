package com.example.fyf;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;

public class TestMenuActivity extends Activity {
	
	public TestMenuActivity() {
		// TODO Auto-generated constructor stub
	}

	private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
		
		@Override
		public boolean onCreateActionMode(ActionMode mode, android.view.Menu menu) {
			MenuInflater inflater = mode.getMenuInflater();
			inflater.inflate(R.menu.mymenu, menu);
			Log.e("FYF", "onCreateActionMode");
			return true;
		};
		
		@Override
		public boolean onPrepareActionMode(ActionMode arg0, android.view.Menu arg1) {
			return false;
		};
		
		
		@Override
		public boolean onActionItemClicked(ActionMode arg0, android.view.MenuItem arg1) {
			Log.e("FYF", "onDestroyActionMode");
			switch(arg1.getItemId()) {
				case R.id.i1:
					iv1.setImageResource(R.drawable.bender03pb);
					return true;
				case R.id.i2:
					iv1.setImageResource(0);
					return true;
				case R.id.i3:
					iv1.setImageResource(R.drawable.home);
					return true;
				default:
					return false;
			}
		};
		
		public void onDestroyActionMode(ActionMode arg0) {
			Log.e("FYF", "onDestroyActionMode");
		};
	};
	
	ImageView iv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_menu);
		iv1 = (ImageView)findViewById(R.id.img1);
		iv1.setLongClickable(true);
		iv1.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View arg0) {
				// TODO Auto-generated method stub
				startActionMode((Callback) mActionModeCallback);
				return false;
			}
		});
	}
}

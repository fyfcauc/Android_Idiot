package com.example.fyf;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
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
//		iv1.setOnLongClickListener(new OnLongClickListener() {
//			
//			@Override
//			public boolean onLongClick(View arg0) {
//				// TODO Auto-generated method stub
////				startActionMode((Callback) mActionModeCallback);
//				return true;
//			}
//		});
		registerForContextMenu(findViewById(R.id.l1));
		registerForContextMenu(iv1);
//		registerForContextMenu(getWindow().getDecorView());
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		Log.e("FYF", "onCreateContextMenu " + v.getId());
		MenuInflater inflater= getMenuInflater();
		inflater.inflate(R.menu.mymenu, menu);
	}
	
	// used by 2.3 and lower
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		Log.e("FYF", "onPrepareOptionsMenu");
		super.onPrepareOptionsMenu(menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()) {
		
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
			return super.onMenuItemSelected(featureId, item);
		}		
	}
}

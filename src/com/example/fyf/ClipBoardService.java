package com.example.fyf;

import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ClipBoardService extends Service {

	public ClipBoardService() {
		// TODO Auto-generated constructor stub
	}

	private ClipboardManager mClipboardManager;
	ClipboardManager.OnPrimaryClipChangedListener mClipListner;
	private void listenClipBoard() {
		mClipboardManager
		= (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
		mClipListner = 
				new ClipboardManager.OnPrimaryClipChangedListener() {
			@Override
            public void onPrimaryClipChanged() {
				ClipData clip = mClipboardManager.getPrimaryClip();
				if (clip != null && clip.getItemCount() > 0) {
                    CharSequence clipString = clip.getItemAt(0).getText();
                    String newClipString = clipString.toString().trim();
                    Log.e("FYF", "Service Clip " + newClipString);
				}
			}
		};
		mClipboardManager.addPrimaryClipChangedListener(mClipListner);
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.e("FYF", "service onCreate");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		super.onStartCommand(intent, flags, startId);
		Log.e("FYF", "Service start");
		listenClipBoard();
		String extra = intent.getStringExtra("NAME");
		if (extra  != null) {
			Log.e("FYF", "Service start with NAME " + extra);
		}
		Log.e("FYF", "Service start with TIME " + intent.getIntExtra("TIME", -1));
		return Service.START_STICKY;
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mClipboardManager.removePrimaryClipChangedListener(mClipListner);
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}

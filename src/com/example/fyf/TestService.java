package com.example.fyf;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

public class TestService extends Service {
	
	public static final int INIT = 0;
	public static final int DO_SOME = INIT + 1;
	public static final int SUCIDE = DO_SOME + 1;
	public static final int CLIENT_DO_SOME = SUCIDE + 1;
	private static final String TAG = "TestService";
	private IBinder mClientBinder;
	private final IBinder mServiceBinder = new Binder() {
		protected boolean onTransact(int code, Parcel data, Parcel reply,
				int flags) throws RemoteException {
			switch(code) {
			case INIT:
				mClientBinder = data.readStrongBinder();
				Log.e(TAG, "TestService init " + data.readString());
				return true;
			case DO_SOME:
				Log.e(TAG, "TestService do some");
				responseClient("Hello, I am service");
				return true;
			case SUCIDE:
				Log.e(TAG, "TestService, I do not want to die!");
				// looks like do not work in bind
				//				TestService.this.stopSelf();
				// can work, but too hack.
//				android.os.Process.killProcess(android.os.Process.myPid());
				return true;
			};
			return false;
		};
	};
	
	
	public TestService() {
		// TODO Auto-generated constructor stub
	}

	private synchronized void responseClient(String response) {
		Parcel p = Parcel.obtain();
		p.writeString(response);
		try {
			mClientBinder.transact(CLIENT_DO_SOME, p, null, 0);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			p.recycle();
		}
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.e(TAG, "onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Log.e(TAG, "onUnbind()");
		return super.onUnbind(intent);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.e(TAG, "onDestroy()");
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return mServiceBinder;
	}
}

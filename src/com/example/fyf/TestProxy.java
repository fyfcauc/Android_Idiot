package com.example.fyf;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

public class TestProxy {

	private IBinder mServerBinder;
	private Context mContext;
	private final Handler mUIHandler = new Handler(Looper.getMainLooper());
	private final static String TAG = "TestProxy";
	private final IBinder mClientBinder = new Binder() {
		protected boolean onTransact(int code,
					Parcel data, Parcel reply, int flags) throws RemoteException {
			switch (code) {
			case TestService.CLIENT_DO_SOME:
				final String serverMessage = data.readString();
				mUIHandler.post(new Runnable() {
					@Override
					public void run() {
						Log.e(TAG, "serverMessage " + serverMessage);
					}
				});
				return true;
			}
			return false;
		};
	};
	public TestProxy(Context context) {
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	private class InitAsyncTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			Parcel p = Parcel.obtain();
			p.writeStrongBinder(mClientBinder);
			p.writeString("Hello from client");
			try {
				mServerBinder.transact(TestService.INIT, p, null, 0);
			} catch (Exception e) {
				
			} finally {
				p.recycle();
			}
			return null;
		}
		
	};
	
	private final ServiceConnection mServiceConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			// TODO Auto-generated method stub
			Log.e(TAG, "onServiceDisconnected");
			mServerBinder = null;
		}
		
		@Override
		public void onServiceConnected(ComponentName arg0, IBinder arg1) {
			// TODO Auto-generated method stub
			Log.e(TAG, "onServiceConnected");
			 mServerBinder = arg1;
			 new InitAsyncTask().execute();
		}
	};
	
	public void init() {
		Intent bindIntent = new Intent(mContext, TestService.class);
		boolean res = mContext.bindService(bindIntent, mServiceConnection,  Context.BIND_AUTO_CREATE);
		Log.e(TAG, "bindService " + res);
	}
	
	public void unbind() {
		// Note: do not unbind a unbinded service!!!!!!!!!!
		try {
			mContext.unbindService(mServiceConnection);
        } catch (Exception e) {
        }
	}
	
	private void transactToServer(int cmdCode, Parcel p) {
		if (mServerBinder != null) {
			try {
				mServerBinder.transact(cmdCode, p, null, 0);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (p != null) {
					p.recycle();
				}
			}
		}
		
	}
	
	public void sayHello() {
		Parcel p = Parcel.obtain();
		transactToServer(TestService.DO_SOME, p);
	}
	
	public void killService() {
		Parcel p = Parcel.obtain();
		transactToServer(TestService.SUCIDE, p);
	}
}

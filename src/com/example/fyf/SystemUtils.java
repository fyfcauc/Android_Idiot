package com.example.fyf;

import android.content.Context;

public class SystemUtils {
	private static Context sAppContext;
	
	public void setAppContext(Context curAppContext) {
		sAppContext = curAppContext;
	}
	
	public Context getAppContext() {
		return sAppContext;
	}
}

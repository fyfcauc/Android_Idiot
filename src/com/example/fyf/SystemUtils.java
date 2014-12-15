package com.example.fyf;

import android.content.Context;
import android.util.Log;

public class SystemUtils {
	private static Context sAppContext;
	
	public void setAppContext(Context curAppContext) {
		sAppContext = curAppContext;
	}
	
	public Context getAppContext() {
		return sAppContext;
	}
	
	public static void printStack(final String tag) {
        StackTraceElement elements[] = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : elements) {
            Log.e(tag, element.toString());
        }
    }
}

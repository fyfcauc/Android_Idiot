package com.example.fyf;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

public class SystemUtils {
	private static Context sAppContext;
	
	public void setAppContext(Context curAppContext) {
		sAppContext = curAppContext;
	}
		
	static {
		Log.e("FYF", "SystemUtils is loaded "
				+ Thread.currentThread().getId() + " " + android.os.Process.myPid());
	}
	
	public static int testVal;
	
	public Context getAppContext() {
		return sAppContext;
	}
	
	public static void printStack(final String tag) {
        StackTraceElement elements[] = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : elements) {
            Log.e(tag, element.toString());
        }
    }
	
	public static void printChildRect(ViewGroup parent, final String tag) {
		Log.e(tag, "printChildRect " + parent.getChildCount());
		for (int i = 0; i < parent.getChildCount(); ++i) {
			Rect childRect = new Rect();
			parent.getChildAt(i).getHitRect(childRect);
			Log.e(tag, "Child " + i + " " + childRect.toString());
		}
	}
	
	public static String motionEventToString(MotionEvent ev) {
		switch (ev.getActionMasked()) {
		case MotionEvent.ACTION_DOWN:
			return "ACTION_DOWN";
		case MotionEvent.ACTION_UP:
			return "ACTION_UP";
		case MotionEvent.ACTION_MOVE:
			return "ACTION_MOVE";
		case MotionEvent.ACTION_CANCEL:
			return "ACTION_CANCEL";
		default:
			return "ACTION_UNDEFINE " + ev.getActionMasked();
		}
	}
}

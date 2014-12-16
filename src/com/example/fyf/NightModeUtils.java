package com.example.fyf;

import android.view.View;
import android.view.ViewGroup;

public class NightModeUtils {

	public NightModeUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static void setNightModeForViewAndChilds(View view, boolean nightMode) {
		if (view instanceof HasNightMode) {
			((HasNightMode) view).setNightMode(nightMode);
		}
		
		if (view instanceof ViewGroup) {
			for (int i = 0; i < ((ViewGroup)view).getChildCount(); i++) {
				View curChild = ((ViewGroup)view).getChildAt(i);
				setNightModeForViewAndChilds(curChild, nightMode);
			}
		}
	}
}

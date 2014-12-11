package com.example.fyf;

import android.app.Application;
import android.util.Log;

public class FYFApplication extends Application {
	
	public String sharString = "I AM SHARED";
	public FYFApplication() {
		Log.e("FYF", "HELLO WORLD!");
	}

}

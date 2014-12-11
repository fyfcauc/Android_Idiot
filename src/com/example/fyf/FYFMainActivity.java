package com.example.fyf;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class FYFMainActivity extends Activity {

	FYFWebview mWebView;
	Button mGoButton;
	Button mGo2Button;
	EditText mUrl;
	ViewPager mMainViewPager;
	long firstTime;
	private boolean firstLaunch = true;
	private static final String PREFIX = "http://";
//	private Context mConext = getApplicationContext();
	
	ArrayList<View> mImageArrayList = new ArrayList<View>();
	
	private void generateData() {
		Log.e("TEST", "generateData()");
		ImageView image1 = new ImageView(getApplicationContext());
		image1.setImageResource(R.drawable.abc_ic_voice_search);
		ImageView image2 = new ImageView(getApplicationContext());
		image2.setImageResource(R.drawable.abc_ic_cab_done_holo_dark);
		ImageView image3 = new ImageView(getApplicationContext());
		image3.setImageResource(R.drawable.ic_launcher);
//		LayoutInflater inflater = (LayoutInflater) getApplicationContext().
//                getSystemService(
//                Context.LAYOUT_INFLATER_SERVICE);
//		mImageArrayList.add(inflater.inflate(R.layout.fragment2, null));
//		mImageArrayList.add(inflater.inflate(R.layout.fragment1, null));
		mImageArrayList.add(image1);
		mImageArrayList.add(image2);
		mImageArrayList.add(image3);
	}
	
	PagerAdapter mPagerAdapter = new PagerAdapter() {
		
		
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mImageArrayList.size();
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			Log.e("TEST", "instantiateItem() " + position);
	        if (position >= 0 && position < mImageArrayList.size()) {
	        		container.addView(mImageArrayList.get(position));
	        		return mImageArrayList.get(position);
	        } else {
	           return null;	
	        }
	    }
		
		@Override
        public void destroyItem(ViewGroup container, int position, Object obj) {
            container.removeView(mImageArrayList.get(position));
        }
	};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		Log.e("TEST", "onCreate " + (mConext == null ? "mContext is null " : "mContext OK"));
		Log.e("TEST", "onCreate " + (getApplicationContext() == null ? "getContext is null " : "getContext OK"));
		setContentView(R.layout.activity_fyf_main);
		mWebView = (FYFWebview)findViewById(R.id.webview);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.setWebViewClient(new WebViewClient(){       
            public boolean shouldOverrideUrlLoading(WebView view, String url) {       
            		long curTime = System.currentTimeMillis();
            		if (firstLaunch) {
            			Log.e("TEST", "shouldOverrideUrlLoading firstLaunch "
            					+ firstTime + " " + (curTime - firstTime));
                		firstLaunch = false;
                }
            		Log.e("TEST", "shouldOverrideUrlLoading " +
            				(curTime	 - mWebView.upTime) + " " + url);
                view.loadUrl(url);       
                return true;       
            }       
		});
		mGoButton = (Button)findViewById(R.id.openUrl);
		mGo2Button = (Button)findViewById(R.id.goToTest);
		mUrl = (EditText)findViewById(R.id.url);
		mMainViewPager = (ViewPager)findViewById(R.id.mainViewPager);
		mGoButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mWebView.loadUrl(PREFIX + mUrl.getText().toString());
		    }
		});
		generateData();
		mGo2Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				 Intent startIntent = new Intent(getBaseContext(), TestActivity.class);
				 startActivity(startIntent);
			}
		});
		mMainViewPager.setAdapter(mPagerAdapter);
		mMainViewPager.setOnPageChangeListener(new OnPageChangeListener(){
			@Override  
            public void onPageScrollStateChanged(int arg0) {  
                // TODO Auto-generated method stub  
                //arg0=arg0%list.size();  
                 Log.e("TEST", "onPageScrollStateChanged");
            }  
      
            //当当前页面被滑动时调用   
            @Override  
            public void onPageScrolled(int arg0, float arg1, int arg2) {  
                // TODO Auto-generated method stub  
            	    Log.e("TEST", "onPageScrolled");
            }  
      
            //当新的页面被选中时调用   
            @Override  
            public void onPageSelected(int arg0) {
            	Log.e("TEST", "onPageSelected");	
            }
		});  
		mMainViewPager.setCurrentItem(0);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		firstTime = System.currentTimeMillis();
		mWebView.loadUrl("http://www.sina.com");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fyfmain, menu);
		return true;
	}

}

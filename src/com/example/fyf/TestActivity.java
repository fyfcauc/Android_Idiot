package com.example.fyf;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;

public class TestActivity extends FragmentActivity {

	private Button mChangeButton;
	private int currentFragmentLayoutId;
	private FYFFrameLayout mViewGroup;
	
	private OnClickListener mChangeFragmentListener = 
			new OnClickListener() {
				@Override
				public void onClick(View v) {
					if (currentFragmentLayoutId != R.layout.fragment2) {
						currentFragmentLayoutId = R.layout.fragment2;
					} else {
						currentFragmentLayoutId = R.layout.fragment3;
					}
					FragmentManager fm = getSupportFragmentManager();
					FragmentTransaction ft = fm.beginTransaction();
					FYFFragment newFragemnt = new FYFFragment();
//					Bundle mBundle = new Bundle();
					newFragemnt.setLayoutId(currentFragmentLayoutId);
//					mBundle.putInt("layoutId", currentFragmentLayoutId);
					ft.replace(R.id.fragmentContainer, newFragemnt);
					ft.commit();
				}
	};

	private OnClickListener mAddImageViewListener = 
			new OnClickListener() {
				@Override
				public void onClick(View v) {
					ImageView imageView = new ImageView(getApplicationContext());
					imageView.setImageResource(R.drawable.ic_launcher);
//					mViewGroup.addView(imageView, 0);
					LayoutParams params = imageView.getLayoutParams();
		            if (params == null) {
		                params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		            }
		            mViewGroup.addViewSlience(imageView, -1, params, true);
		            mViewGroup.requestLayout();
				}
	};
	
	private int mFragementContainerId = R.id.fragmentContainer;

	public TestActivity() {
//		Log.e("FYF", getApplicationContext().getPackageName());
		// TODO Auto-generated constructor stub
	}
	
	private void addViewPager(Fragment fragment) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
//		Bundle mBundle = new Bundle();
//		mBundle.putInt("layoutId", currentFragmentLayoutId);
//		FYFFragment newFragemnt = new FYFFragment();
//		newFragemnt.setLayoutId(R.layout.fragment2);
		ft.replace(R.id.fragmentContainer, fragment);
		ft.commit();
	}
	
	@Override
	public void onResume() {
		super.onResume();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fyf_test);
		mViewGroup = (FYFFrameLayout)findViewById(R.id.fyfContainer);
		mChangeButton = (Button)findViewById(R.id.changeFragment);
//		mChangeButton.setOnClickListener(mChangeFragmentListener);
		mChangeButton.setOnClickListener(mChangeFragmentListener);
		mChangeButton.setEnabled(false);
//		addViewPager(new ViewPagerFragment());
		addViewPager(new ProgressBarFragment());
	}

}

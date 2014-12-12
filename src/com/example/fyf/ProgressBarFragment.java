package com.example.fyf;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

public class ProgressBarFragment extends Fragment {

	private Button mIncButton;
	private Button mDecButton;
	private ProgressBar mProgressBar;
	private int mProgress;
	
	public ProgressBarFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public View onCreateView(LayoutInflater inflater,
    		ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment4, container, false);
		mProgressBar = (ProgressBar)rootView.findViewById(R.id.progressBar);
		mIncButton = (Button)rootView.findViewById(R.id.inc);
		mDecButton = (Button)rootView.findViewById(R.id.dec);
		mIncButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (++mProgress <= mProgressBar.getMax()) {
					mProgressBar.setProgress(mProgress);
				} else {
					mProgress = mProgressBar.getMax();
				} 
			}
		});
		mDecButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (--mProgress >= 0) {
					mProgressBar.setProgress(mProgress);
				} else {
					mProgress = 0;
				} 
			}
		});
		return rootView;
	}
	
}

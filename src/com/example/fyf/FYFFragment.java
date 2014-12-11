package com.example.fyf;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FYFFragment extends Fragment {

	private int mLayoutId = R.layout.fragment1;
	public FYFFragment() {
		// TODO Auto-generated constructor stub
	}
	
	public void setLayoutId(int id) {
		mLayoutId = id;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater,
    		ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(mLayoutId, container, false);
		return rootView;
	}

}

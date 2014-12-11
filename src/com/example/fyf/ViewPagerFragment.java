package com.example.fyf;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewPagerFragment extends Fragment {

	ViewPager mViewPager;
	ArrayList<View> mImageArrayList = new ArrayList<View>();

	private void generateData() {
		Log.e("TEST", "generateData()");
		ImageView image1 = new ImageView(getActivity().getApplicationContext());
		image1.setImageResource(R.drawable.abc_ic_voice_search);
		ImageView image2 = new ImageView(getActivity().getApplicationContext());
		image2.setImageResource(R.drawable.abc_ic_cab_done_holo_dark);
		
//		LayoutInflater inflater = (LayoutInflater) getActivity().getApplicationContext().
//                getSystemService(
//                Context.LAYOUT_INFLATER_SERVICE);
//		mImageArrayList.add(inflater.inflate(R.layout.fragment2, null));
//		mImageArrayList.add(inflater.inflate(R.layout.fragment1, null));
		mImageArrayList.add(image1);
		mImageArrayList.add(image2);
		
	}

	class FYFPagerAdapter extends PagerAdapter{
		ArrayList<View> mInnerImageArrayList = new ArrayList<View>();
		
		public FYFPagerAdapter() {
			ImageView image1 = new ImageView(getActivity().getApplicationContext());
			image1.setImageResource(R.drawable.abc_ic_voice_search);
			ImageView image2 = new ImageView(getActivity().getApplicationContext());
			image2.setImageResource(R.drawable.abc_ic_cab_done_holo_dark);
			ImageView image3= new ImageView(getActivity().getApplicationContext());
			image3.setImageResource(R.drawable.ic_launcher);
			mInnerImageArrayList.add(image1);
			mInnerImageArrayList.add(image2);
			mInnerImageArrayList.add(image3);
		}
		
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mInnerImageArrayList.size();
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			Log.e("TEST", "instantiateItem() " + position);
			if (position >= 0 && position < mInnerImageArrayList.size()) {
	        		container.addView(mInnerImageArrayList.get(position));
	        		return mInnerImageArrayList.get(position);
	        } else {
	           return null;	
	        }
	    }
		
		@Override
        public void destroyItem(ViewGroup container, int position, Object obj) {
            container.removeView(mInnerImageArrayList.get(position));
        }
	}
	
	PagerAdapter mPagerAdapter;
	
	public ViewPagerFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public View onCreateView(LayoutInflater inflater,
    		ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.fragment3, container, false);
//		mViewPager = (ViewPager)rootView.findViewWithTag(R.tag.viewPager1Tag);
//		generateData();
		mPagerAdapter = new FYFPagerAdapter();
		mViewPager = (ViewPager)rootView.findViewById(R.id.viewPager1);
		mViewPager.setAdapter(mPagerAdapter);
		mViewPager.setCurrentItem(0);
		return rootView;
	}
	
	@Override
	public void onResume() {
		super.onResume();
	}
}

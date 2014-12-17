package com.example.fyf;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class AnimateActivity extends Activity {

	public AnimateActivity() {
		// TODO Auto-generated constructor stub
	}

	private ImageView mImageView1;
	private ImageView mImageView2;
	private ImageView mImageView3;
	private ImageView mImageView4;
	
	private void startFadeAnimation(View animatingView, int duration) {
		 Animator anim = ObjectAnimator.ofFloat(animatingView, "alpha", 1.f, 0f);
         anim.setDuration(duration);
         anim.addListener(new AnimatorListenerAdapter() {
             @Override
             public void onAnimationStart(Animator animation) {
            	 Log.e("FYF", "startFadeAnimation");
             }

             @Override
             public void onAnimationEnd(Animator animation) {
            	 Log.e("FYF", "endFadeAnimation");
             }
         });
         anim.start();
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.e("FYF", "Activity onCreate()");
		setContentView(R.layout.activity_animate_test);
		mImageView1 = (ImageView)findViewById(R.id.IMG1);
		mImageView2 = (ImageView)findViewById(R.id.IMG2);
		mImageView3 = (ImageView)findViewById(R.id.IMG3);
		mImageView4 = (ImageView)findViewById(R.id.IMG4);
		startFadeAnimation(mImageView1, 5000);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.e("FYF", "Activity onResume()");
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.e("FYF", "Activity onStart()");
	}
}

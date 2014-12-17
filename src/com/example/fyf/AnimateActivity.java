package com.example.fyf;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
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
	
	private void startScaleXAnimation(View animatingView, int duration) {
		Animator anim = ObjectAnimator.ofFloat(animatingView, "ScaleX", 2.f, 0.5f);
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
	
	private void startAnimateSet(View animatingView, int duration) {
		Animator xMoveAnim = ObjectAnimator.ofFloat(animatingView, "X", 0, 500);
		xMoveAnim.setDuration(duration);
		Animator fadeAnim = ObjectAnimator.ofFloat(animatingView, "alpha", 1.f, 0f);
		fadeAnim.setDuration(duration);
		Animator xScaleAnimator = ObjectAnimator.ofFloat(animatingView, "ScaleX", 2.f, 0.5f);
		fadeAnim.setDuration(duration);
		
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.playTogether(xMoveAnim, fadeAnim, xScaleAnimator);
		animatorSet.addListener(new AnimatorListener() {
			
			@Override
			public void onAnimationStart(Animator arg0) {
				// TODO Auto-generated method stub
				Log.e("FYF", "onAnimationStart");
			}
			
			@Override
			public void onAnimationRepeat(Animator arg0) {
				// TODO Auto-generated method stub
				Log.e("FYF", "onAnimationRepeat");
			}
			
			@Override
			public void onAnimationEnd(Animator arg0) {
				// TODO Auto-generated method stub
				Log.e("FYF", "onAnimationEnd");
			}
			
			@Override
			public void onAnimationCancel(Animator arg0) {
				// TODO Auto-generated method stub
				Log.e("FYF", "onAnimationCancel");
			}
		});
		animatorSet.start();
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
		mImageView2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.e("FYF", "I am clicked!");
			}
		});
		startFadeAnimation(mImageView1, 5000);
		startScaleXAnimation(mImageView2, 2000);
		startAnimateSet(mImageView3, 5000);
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

package com.example.fyf;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class TestAttachActivity extends Activity {

	public TestAttachActivity() {
		// TODO Auto-generated constructor stub
	}
	
	private static class MyLinearLayout extends LinearLayout {

		private int S = 50;
		public MyLinearLayout(Context context, AttributeSet attrs, int defStyle) {
			super(context, attrs, defStyle);
			// TODO Auto-generated constructor stub
		}
		
		public MyLinearLayout(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
		
		public MyLinearLayout(Context context, AttributeSet attrs) {
			super(context, attrs);
			// TODO Auto-generated constructor stub
		}
		
		
		@Override
		protected void onLayout(boolean changed, int l, int t, int r, int b) {
			// TODO Auto-generated method stub
			Log.e("FYF", "onLayout");
			super.onLayout(changed, l, t, r, b);
			int childNum = getChildCount();
			for (int i = 0; i < childNum; i++) {
				View child = getChildAt(i);
				child.layout(0, 0, S, S);
				S+=50;
			}
		}
		
	}
	
	private Button mButton;
	private Button mButton2;
	private ViewGroup mContainer;
	private View mView;
	private View mView2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_attach);
		mView = findViewById(R.id.view1);
		mView.setClickable(true);
		((ViewGroup)(getWindow().getDecorView().findViewById(android.R.id.content))).getChildAt(0).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				Log.e("FYF", "onClick " + arg0.getId());
//				Log.e("FYF", "mView " + mView.getTop() + " " + mView.getLeft());
//				int coordScreen[] = {mView.getTop(), mView.getLeft()};
//				// init value has no avail
//				coordScreen[0] = 78;
//				
//				int coordWindow[] = Arrays.copyOf(coordScreen, coordScreen.length);
//				coordWindow[0] = 67;
//				
//				mContainer.getLocationOnScreen(coordScreen);
//				Log.e("FYF", "Screen mView " + coordScreen[0] + " " + coordScreen[1]);
//				mContainer.getLocationInWindow(coordWindow);
//				Log.e("FYF", "Window mView " + coordWindow[0] + " " + coordWindow[1]);
//				mView.scrollBy(50, 50);
//				Log.e("FYF", mView.getScrollX() + " " + mView.getScrollY());
				
//				mView.invalidate();
				// still can touch
//				mView.setAlpha(0.0f);
				// can not touch
//				mView.setVisibility(View.INVISIBLE);
				//alpha 0.f -> 1.0f : INVISIBLE -> VISIBLE
//				Animator anim = ObjectAnimator.ofFloat(mView, "alpha", 0.f, 1.0f);
//				anim.setDuration(1000);
//				anim.start();
////				
				
			}
		});
		
//		mView.setOnTouchListener(new OnTouchListener() {
//			
//			@Override
//			public boolean onTouch(View arg0, MotionEvent arg1) {
//				// TODO Auto-generated method stub
//				Log.e("FYF", arg1.getX() + " " + arg1.getY()
//						+ " " + arg1.getRawX() + " " + arg1.getRawY());
//				return false;
//			}
//		});
		
		mView2 = findViewById(R.id.view2);
		mView2.setClickable(true);
		mButton = (Button)findViewById(R.id.button1);
		mContainer = (ViewGroup)findViewById(R.id.container);
//		mButton.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				mView.setPivotX(0.0f);
//				mView.setScaleX(0.5f);
////				mView.setScaleY(1.0f);
//				if (mView.getVisibility() == View.GONE) {
//					mView.setVisibility(View.VISIBLE);
//				} else if (mView.getVisibility() == View.VISIBLE) {
//					mView.setVisibility(View.INVISIBLE);
//				} else {
//					mView.setVisibility(View.GONE);
//				}
//			}
//		});
		
		mContainer.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				Log.e("FYF", "container onTouch " + arg1.getX() + " " + arg1.getY()
						+ " " + mView.getLeft() + mView.getTop()
						+ " " + mView.getBottom() + mView.getRight());
				
				Log.e("FYF", SystemUtils.motionEventToString(arg1));
				
				return true;
			}
		});
		
		mButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				Log.e("FYF", "mContainer onScroll " + mContainer.getScrollX()
//						+ " " + mContainer.getScrollY());
//				mContainer.scrollBy(-50, -50);
////				mContainer.scrollBy(-50, -50);
//		
//				//Note, here use LinearLayout is because mView is contained by a LinearLayout!!!!!!
////				LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams)mView.getLayoutParams();
////				
////				
////				
////				mlp.topMargin -= 50;
////				mView.setLayoutParams(mlp);
////				LinearLayout.LayoutParams mlp = (LinearLayout.LayoutParams)mContainer.getLayoutParams();
////				mContainer.setPadding(mContainer.getPaddingLeft(), mContainer.getPaddingTop() - 50,
////						mContainer.getPaddingRight() ,mContainer.getPaddingBottom());
//				
//				Rect hitRect = new Rect();
//				mView.getHitRect(hitRect);
//				Log.e("FYF", mView.getScrollX() + " " + mView.getScrollY()
//						+ " hitRect " + hitRect
//						+ " location " + mView.getLeft() + " " + mView.getTop()
//						+ " " + mView.getBottom() + " " + mView.getRight());
//				mContainer.requestLayout();
				mContainer.invalidate();
			}
		});
		
		mButton2 = (Button)findViewById(R.id.button2);
		mButton2.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				mView2.setSelected(!mView2.isSelected());
//				mView.scrollBy(-50, -50);
//				mView.setTranslationX(
//						mView.getTranslationX() - 50);
//				mView.setTranslationY(
//						mView.getTranslationY() - 50);
//				
//				
//				Rect hitRect = new Rect();
//				mView.getHitRect(hitRect);
//				Log.e("FYF", mView.getScrollX() + " " + mView.getScrollY()
//						+ " hitRect " + hitRect
//						+ " location " + mView.getLeft() + " " + mView.getTop()
//						+ " " + mView.getBottom() + " " + mView.getRight());
//				mView.forceLayout();
//				mView.requestLayout();
//				mView.invalidate();
				mView.measure(MeasureSpec.makeMeasureSpec(1000, MeasureSpec.EXACTLY),
						MeasureSpec.makeMeasureSpec(1000, MeasureSpec.EXACTLY));
				mContainer.requestLayout();
			}
//				int childNum = mContainer.getChildCount();
////				if (childNum > 1) {
////					mContainer.removeViewInLayout(mContainer.getChildAt(0));
////				} else if (childNum == 1) {
////					mContainer.removeView(mContainer.getChildAt(0));
////				}
//				if (childNum > 0) {
//					Log.e("FYF", "removeAllViewsInLayout");
//					mContainer.removeAllViewsInLayout();
//				} else {
//					Log.e("FYF", "requestLayout");
//					// no this, size do not change
//					mContainer.requestLayout();
//					// no this, view not be refreshed
//					mContainer.invalidate();
//				}
//				
//			}
		});
		
	}

}

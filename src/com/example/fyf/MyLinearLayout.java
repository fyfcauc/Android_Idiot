package com.example.fyf;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyLinearLayout extends LinearLayout {

	public MyLinearLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		init(context, null);
	}

	public MyLinearLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init(context, attrs);
	}

	public MyLinearLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		init(context, attrs);
	}
	
	private TextView mTextView;
	private ImageView mImageView;
	
	private void init(Context context, AttributeSet attrs) {
		LayoutInflater.from(context).inflate(R.layout.my_linear_layout, this, true);
		mTextView = (TextView)this.findViewById(R.id.myTextView);
		mImageView = (ImageView)this.findViewById(R.id.myImageView);
		
		TypedArray attrArray = context.obtainStyledAttributes(attrs, R.styleable.MyLinearLayout);
        int count = attrArray.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attrName = attrArray.getIndex(i);
            switch (attrName) {
            	case R.styleable.MyLinearLayout_My_src:
            		mImageView.setImageResource(
            				attrArray.getResourceId(R.styleable.MyLinearLayout_My_src, R.drawable.ic_launcher));
            		break;
            	case R.styleable.MyLinearLayout_My_text:
            		mTextView.setText(attrArray.getString(R.styleable.MyLinearLayout_My_text));
            		break;
            }
        }
        attrArray.recycle();
        
    }
}

package com.lockerfish.exercises.photospiral;

import android.view.ViewGroup;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class PhotoSpiral extends ViewGroup {

	public PhotoSpiral(Context context) {
		super(context);
	}

	public PhotoSpiral(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
    
	public PhotoSpiral(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// super.onMeasure(widthMeasureSpec, heightMeasureSpec);	
		measureChildren(widthMeasureSpec, heightMeasureSpec);
		View first = getChildAt(0);
		int size = first.getMeasuredWidth() + first.getMeasuredHeight();
		int width = ViewGroup.resolveSize(size, widthMeasureSpec);
		int height = ViewGroup.resolveSize(size, heightMeasureSpec);
		setMeasuredDimension(width, height);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		View first = getChildAt(0);
		int childWidth = first.getMeasuredWidth();
		int childHeight = first.getMeasuredHeight();

		for (int i=0; i < getChildCount(); ++i) {
			View child = getChildAt(i);
			int x = 0;
			int y = 0;
			switch (i) {
				case 1:
					x = childWidth;
					y = 0;
					break;
				case 2:
					x = childHeight;
					y = childWidth;
					break;
				case 3:
					x = 0;
					y = childHeight;
					break;
			}
			child.layout(x, y, x + child.getMeasuredWidth(), y + child.getMeasuredHeight());
		}

	}
}

package com.lockerfish.exercises.squareview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class SquareView extends View {
  public SquareView(Context context) {
    super(context);
  }

  public SquareView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public SquareView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
  	// pass measurement specs to super
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    // width and height are now measured, get whichever is smaller
    int size = Math.min(getMeasuredWidth(), getMeasuredHeight());
    // set both width and height to smallest of the two
    setMeasuredDimension(size, size);
  }
}
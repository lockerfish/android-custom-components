package com.lockerfish.exercises.sidewayslayout;

import android.widget.LinearLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.graphics.Color;

public class SidewaysLayout extends LinearLayout {

	public SidewaysLayout(Context context) {
		super(context);
	}
    
	public SidewaysLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
	}

	@Override
	protected void dispatchDraw(Canvas canvas) {
		// canvas.drawColor(Color.LTGRAY);
		canvas.save();
		canvas.translate(0, getHeight());
		canvas.rotate(-90, 0, 0);
		super.dispatchDraw(canvas);
		canvas.restore();
	}
}

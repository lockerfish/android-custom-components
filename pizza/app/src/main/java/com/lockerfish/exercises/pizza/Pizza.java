package com.lockerfish.exercises.pizza;

import android.content.Context;
import android.view.View;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.content.res.TypedArray;

public class Pizza extends View {

	Paint paint;
	private int numWedges = 5;

	public Pizza(Context context) {
		super(context);
		init(context, null); 
	} 

	public Pizza(Context context, AttributeSet attrs) {
		super(context, attrs);   
		init(context, attrs); 
	} 

	public Pizza(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context, attrs); 
	}

	private void init(Context context, AttributeSet attrs) {
		int strokeWidth = 4;
		int color = Color.YELLOW;

		if (attrs != null) {
			TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Pizza);
			strokeWidth = array.getDimensionPixelSize(R.styleable.Pizza_stroke_width, strokeWidth);
			color = array.getColor(R.styleable.Pizza_color, color);
			numWedges = array.getInt(R.styleable.Pizza_num_wedges, numWedges);
		}
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(strokeWidth);
		paint.setColor(color);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		/*
			drawing something to check our custom view is working
		*/
		// canvas.drawColor(Color.GRAY);

		final int width = getWidth() - getPaddingLeft() - getPaddingRight();
		final int height = getHeight() - getPaddingTop() - getPaddingBottom();
		final int cx = width / 2 + getPaddingLeft();
		final int cy = height / 2 + getPaddingTop();
		final float diameter = Math.min(width, height) - paint.getStrokeWidth();
		final float radius = diameter / 2;

		canvas.drawCircle(cx, cy, radius, paint);

		drawPizzaCuts(canvas, cx, cy, radius);
	}

	private void drawPizzaCuts(Canvas canvas, float cx, float cy, float radius) {
		final float degrees = 360f / numWedges;
		canvas.save();
		for (int i = 0; i < numWedges; ++i) {
			canvas.rotate(degrees, cx, cy);
			canvas.drawLine(cx, cy, cx, cy - radius, paint);
		}
		canvas.restore();			
	}
}

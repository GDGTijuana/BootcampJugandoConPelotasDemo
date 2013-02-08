package com.danmazter.androidbootcamp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Pelota extends View{
	private final float x;
	private final float y;
	private final int r;
	
	private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	
	public Pelota(Context context, float x, float y, int r)
	{
		super(context);
		this.x = x;
		this.y = y;
		this.r = r;
		mPaint.setColor(Color.BLUE);
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		canvas.drawCircle(x, y, r, mPaint);
	}
}
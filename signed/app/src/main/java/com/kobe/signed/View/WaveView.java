package com.kobe.signed.View;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by kobewang on 2018/2/8.
 */
public class WaveView extends View {

    private Paint mPaint;
    private Path mPath;
    private int width, height;

    private int dx;

    public WaveView(Context context, int width, int height) {
        super(context);
        this.width = width;
        this.height = height;
        init();
    }

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        width = this.getWidth();
        height = this.getHeight();
        // first Line
        mPath.reset();
        mPaint.setColor(Color.parseColor("#33ffffff"));
        mPath.moveTo(-width + dx, height / 5 * 2);
        for (int i = 0; i < 3; i++) {
            mPath.rQuadTo(width / 4, height / 2, width / 2, 0);
            mPath.rQuadTo(width / 4, height / 2, width / 2, -height / 8);
        }
        mPath.lineTo(width, height);
        mPath.lineTo(0, height);
        mPath.close();
        canvas.drawPath(mPath, mPaint);
        // second Line
        mPath.reset();
        mPaint.setColor(Color.parseColor("#33ffffff"));
        mPath.moveTo(-width + dx, height / 5 * 3);
        for (int i = 0; i < 3; i++) {
            mPath.rQuadTo(width / 2, -height / 5 * 4, width, 0);
        }
        mPath.lineTo(width, height);
        mPath.lineTo(0, height);
        mPath.close();
        canvas.drawPath(mPath, mPaint);
        // last Line
        mPath.reset();
        mPaint.setColor(Color.parseColor("#33ffffff"));
        mPath.moveTo(-width + dx, height / 5 * 2);
        for (int i = 0; i < 3; i++) {
            mPath.rQuadTo(width / 6, -height / 3, width / 6 * 2, 0);
            mPath.rQuadTo(width / 6, height / 3, width / 6 * 2, 0);
            mPath.rQuadTo(width / 6, -height / 3, width / 6 * 2, 0);
        }
        mPath.lineTo(width, height);
        mPath.lineTo(0, height);
        mPath.close();
        canvas.drawPath(mPath, mPaint);

    }

    public void startAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 0);
        valueAnimator.setDuration(8000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
    }
}

package com.example.administrator.threeweek;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/12/14.
 */
public class MyCircleView extends View{
    Paint paint;
    RectF oval;
    boolean f;
    float sweepArg,tsweepArg;
    public MyCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inidata();
    }

    public void inidata(){
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        sweepArg = 0;
        tsweepArg = 0;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int viewWidth = MeasureSpec.getSize(widthMeasureSpec);
        int viewheight = MeasureSpec.getSize(heightMeasureSpec);
        oval = new RectF(0,0,viewWidth,viewheight);
        setMeasuredDimension(viewWidth,viewheight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        canvas.drawArc(oval,-90,360,true,paint);
        paint.setColor(Color.GREEN);
        canvas.drawArc(oval,-90,sweepArg,true,paint);
        if (f){
            paint.setColor(Color.YELLOW);
            canvas.drawArc(oval,sweepArg-90,tsweepArg,true,paint);
        }
    }
    public void setArc(final int number,final int number1){
        final Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (sweepArg<number){
                    sweepArg+=1;
                }else if(tsweepArg<number1){
                    f = true;
                    tsweepArg++;
                }else{
                    sweepArg = number;
                    tsweepArg = number1;
                    timer.cancel();
                }
                postInvalidate();
            }
        };
        timer.schedule(task,20,20);

    }



}

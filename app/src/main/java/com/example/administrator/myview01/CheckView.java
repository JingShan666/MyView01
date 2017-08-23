package com.example.administrator.myview01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Liu on 2017/8/21 0021.
 */

public class CheckView extends View {
    //随机数据长度
    private static  int TEXT_LENGTH=4;
    //设置验证码字体大小
    private static int TEXT_SIZE=40;
    private Context mContext;
    private Paint mPaint;
    //private Paint mPointPaint;
    public static String text;


    public CheckView(Context context) {
        super(context);

    }

    public CheckView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        mContext = context;
        text= CheckUtil.createCode();
        //创建一个画笔
        mPaint= new Paint();
        //抗锯齿
        mPaint.setAntiAlias(true);
        //设置文字的大小
        mPaint.setTextSize(TEXT_SIZE);
        //设置字体的宽度
        mPaint.setStrokeWidth(3);
        mPaint.setTextSkewX(1); //float类型参数，负数表示右斜，整数左斜paint.setUnderlineText(true); //true为下划线，false为非下划线
        mPaint.setStrikeThruText(true); //true为删除线，false为非删除线

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                text= CheckUtil.createCode();
                invalidate();
            }
        });


    }

    public CheckView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //绘制画布的颜色
        canvas.drawColor(Color.LTGRAY);
        final int height = getHeight();//获得CheckView控件的高度
        final int width = getWidth();//获得CheckView控件的宽度
        /**
             * 绘制文本
             */

            Rect bounds = new Rect();

            //获得绘制文本的范围
            mPaint.getTextBounds(text,0, text.length(), bounds);
            /**
             * canvas.drawText(text, x, y, paint)参数说明：
             * text：表示绘制的文本内容
             * x:默认是这个字符串的左边在屏幕的位置，如果设置了paint.setTextAlign(Paint.Align.CENTER);那就是字符的中心
             * y:指定这个字符baseline在屏幕上的位置
             * paint：我们的画笔
             */
             canvas.drawText(text, getMeasuredWidth()/2 - bounds.width()/2+20, getMeasuredHeight()/2 + bounds.height()/2, mPaint);

            // 绘制小圆点
            int [] point;
            for(int i = 0; i < 100; i ++)    {//画点
                point=CheckUtil.getPoint(height, width);
                canvas.drawCircle(point[0], point[1], 1, mPaint);
            }
    }
}

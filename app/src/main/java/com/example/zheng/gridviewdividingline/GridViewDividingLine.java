package com.example.zheng.gridviewdividingline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/**
 * Created by Zheng on 2017/4/9.
 *
 * @Author Done
 */
public class GridViewDividingLine extends GridView {

    private Paint mPaint;

    public GridViewDividingLine(Context context) {
        this(context, null);
    }

    public GridViewDividingLine(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    //初始化画笔
    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        View localView = getChildAt(0);
        int column = getWidth() / localView.getWidth();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View cellView = getChildAt(i);
            //画item下边分割线
            canvas.drawLine(cellView.getLeft() + 20, cellView.getBottom(), cellView.getRight() - 20, cellView.getBottom(), mPaint);
            //画item右边分割线
            if (i % column < column) {
                canvas.drawLine(cellView.getRight(), cellView.getTop() + 20, cellView.getRight(), cellView.getBottom() - 20, mPaint);
            }
        }
    }
}

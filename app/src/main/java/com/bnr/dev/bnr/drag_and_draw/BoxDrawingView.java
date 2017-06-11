package com.bnr.dev.bnr.drag_and_draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dev-w8-12 on 11-Jun-17.
 */
public class BoxDrawingView extends View {

    // statics
    private static final String TAG = BoxDrawingView.class.getName();

    // members
    private Box mCurrentBox;
    private List<Box> mBoxes = new ArrayList<>();
    //
    private Paint mBoxPaint;
    private Paint mBackgroundPaint;


    // constructors
    public BoxDrawingView(Context context) {
        this(context, null);
    }

    public BoxDrawingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        // boxes
        mBoxPaint = new Paint();
        mBoxPaint.setColor(0x22ff0000);

        // background
        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(0xfff8efe0);

    }


    // operations
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        PointF current = new PointF(event.getX(), event.getY());
        String action = "";

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "ACTION_DOWN";

                // Reset drawing state
                mCurrentBox = new Box(current);
                mBoxes.add(mCurrentBox);

                break;
            case MotionEvent.ACTION_MOVE:
                action = "ACTION_MOVE";

                if (mCurrentBox != null) {
                    mCurrentBox.setCurrent(current);
                    invalidate();
                }

                break;
            case MotionEvent.ACTION_UP:
                action = "ACTION_UP";

                mCurrentBox = null;

                break;
            case MotionEvent.ACTION_CANCEL:
                action = "ACTION_CANCEL";

                mCurrentBox = null;

                break;
        }

        Log.i(TAG, action + " at x = " + current.x + ", y = " + current.y);

        return true;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPaint(mBackgroundPaint);

        for (Box box : mBoxes) {
            float left = Math.min(box.getOrigin().x, box.getCurrent().x);
            float right = Math.max(box.getOrigin().x, box.getCurrent().x);
            float top = Math.min(box.getOrigin().y, box.getCurrent().y);
            float bottom = Math.max(box.getOrigin().y, box.getCurrent().y);

            canvas.drawRect(left, top, right, bottom, mBoxPaint);
        }
    }


}
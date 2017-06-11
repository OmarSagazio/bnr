package com.bnr.dev.bnr.drag_and_draw;

import android.graphics.PointF;

/**
 * Created by dev-w8-12 on 11-Jun-17.
 */
public class Box {

    // members
    private PointF mOrigin;
    private PointF mCurrent;

    // constructor
    public Box(PointF origin) {
        mOrigin = origin;
        mCurrent = origin;
    }


    public PointF getOrigin() {
        return mOrigin;
    }

    public PointF getCurrent() {
        return mCurrent;
    }

    public void setCurrent(PointF current) {
        mCurrent = current;
    }
}

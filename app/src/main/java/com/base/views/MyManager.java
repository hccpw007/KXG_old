package com.base.views;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;

/**
 * Created by Administrator on 2016/4/20.
 */
public class MyManager extends GridLayoutManager {
    public MyManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    public MyManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }
}

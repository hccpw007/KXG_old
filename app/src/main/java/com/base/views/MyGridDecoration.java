package com.base.views;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/4/19.
 */
public class MyGridDecoration extends RecyclerView.ItemDecoration {
    private Paint paint;
    private int vSize;
    private int hSize;
    private boolean isInScroll = false;
    public MyGridDecoration(int hSize, int vSize, int color,boolean isInScroll) {
        this.isInScroll = isInScroll;
        this.hSize = hSize;
        this.vSize = vSize;
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        RecyclerView.Adapter adapter = parent.getAdapter(); //获得RecyclerView的Adapter
        int itemSize = adapter.getItemCount(); //总共有多少个item
        GridLayoutManager layoutManager = (GridLayoutManager) parent.getLayoutManager();
        int spanCount = layoutManager.getSpanCount();

        final int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View child = parent.getChildAt(i);

            int childPosition = parent.getChildPosition(child); //当前View的Position

            int left = child.getLeft() - vSize / 2;
            int top = child.getTop() - hSize / 2;
            int right = child.getRight() + vSize / 2;
            int bottom = child.getBottom() + hSize / 2;


            if (childPosition < spanCount) {
                top = child.getTop();
            }
            if (childPosition > itemSize - spanCount - 1) {
                bottom = child.getBottom();
            }
            if ((childPosition + 1) % spanCount == 1) {
                left = child.getLeft();
            }
            if ((childPosition + 1) % spanCount == 0) {
                right = child.getRight();
            }
            if (childPosition == itemSize - 1) {
                right = child.getRight();
            }
            c.drawRect(left, top, right, bottom, paint);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        RecyclerView.Adapter adapter = parent.getAdapter(); //获得RecyclerView的Adapter
        int itemSize = adapter.getItemCount(); //总共有多少个item
        int childPosition = parent.getChildPosition(view); //当前View的Position
        GridLayoutManager layoutManager = (GridLayoutManager) parent.getLayoutManager();
        int spanCount = layoutManager.getSpanCount();
        int i = (childPosition) % spanCount;

        int left = i * vSize / spanCount;
        int right = (spanCount - 1 - i) * vSize / spanCount;
        int top = hSize / 2;
        int bottom = hSize / 2;
        outRect.set(left, top, right, bottom);

        if (childPosition < spanCount) {
            top = 0;
        }
        if (itemSize%spanCount == 0&&childPosition+1 > itemSize - spanCount ) {
            bottom = 0;
        }
        int i1 = itemSize - spanCount + (spanCount-itemSize % spanCount);
        if (itemSize%spanCount != 0&&childPosition>i1-1 ) {
            bottom = 0;
        }
        outRect.set(left, top, right, bottom);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        if (isInScroll){
            try {
                RecyclerView.Adapter adapter = parent.getAdapter(); //获得RecyclerView的Adapter
                int itemSize = adapter.getItemCount(); //总共有多少个item
                GridLayoutManager layoutManager = (GridLayoutManager) parent.getLayoutManager();
                int spanCount = layoutManager.getSpanCount();
                int itemNum;
                if (itemSize%spanCount ==0){
                    itemNum = itemSize/spanCount;
                }else {
                    itemNum =itemSize/spanCount+1;
                }

                View childAt = parent.getChildAt(0);
                ViewGroup.LayoutParams layoutParams = parent.getLayoutParams();
                layoutParams.height = childAt.getMeasuredHeight()*itemNum+hSize*(itemNum-1);
                parent.setLayoutParams(layoutParams);
            }catch (Exception e){

            }
        }
    }
}

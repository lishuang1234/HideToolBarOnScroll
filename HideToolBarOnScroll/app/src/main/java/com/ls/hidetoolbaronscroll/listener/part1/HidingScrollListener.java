package com.ls.hidetoolbaronscroll.listener.part1;

import android.support.v7.widget.RecyclerView;

/**
 * Created by ls on 15-3-3.
 */
public abstract class HidingScrollListener extends RecyclerView.OnScrollListener {
    private static final int HIDE_DISTANCE = 30;
    private int scrollDistance;
    private boolean isShow = true;


    public HidingScrollListener() {
        super();
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        System.out.println("onScrolled dx :" + dx + "dy: " + dy);
        if (isShow && scrollDistance > HIDE_DISTANCE) {
            isShow = false;
            scrollDistance = 0;
            onHide();
        }
        if (!isShow && scrollDistance < -HIDE_DISTANCE) {
            isShow = true;
            scrollDistance = 0;
            onShow();
        }
        if ((isShow && dy > 0) || (!isShow && dy < 0)) scrollDistance += dy;

    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        System.out.println("onScrollStateChanged newState :" + newState);
    }

    public abstract void onHide();

    public abstract void onShow();
}

package com.ls.hidetoolbaronscroll.activity.part2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;

import com.ls.hidetoolbaronscroll.R;
import com.ls.hidetoolbaronscroll.Utils;
import com.ls.hidetoolbaronscroll.adapter.part2.RecyclerAdapter;
import com.ls.hidetoolbaronscroll.listener.part2.HidingScrollListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ls on 15-3-3.
 */
public class Part2Activity extends ActionBarActivity {
    private Toolbar toolbar;
    private LinearLayout toolbarContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part2_activity);
        initToolBar();
        initRecyclerView();
    }

    private void initRecyclerView() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_part2);
        int paddingTop = Utils.getToolbarHeight(Part2Activity.this) + Utils.getTabHeight
                (Part2Activity.this);
        recyclerView.setPadding(recyclerView.getPaddingLeft(), paddingTop,
                recyclerView.getPaddingRight(), recyclerView.getPaddingBottom());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter(createItemList()));
        recyclerView.setOnScrollListener(new HidingScrollListener(this) {
            @Override
            protected void onHide(int mToolbarHeight) {
                toolbarContainer.animate().translationY(-mToolbarHeight).setInterpolator(new
                        AccelerateInterpolator(2)).start();


            }

            @Override
            protected void onShow() {
                toolbarContainer.animate().translationY(0).setInterpolator(new
                        AccelerateInterpolator(2)).start();
            }

            @Override
            protected void onMove(int mToolbarOffset) {
                System.out.println("part2 activity onMove -mToolbarOffset" + -mToolbarOffset);
                toolbarContainer.setTranslationY(-mToolbarOffset);//直接设置相对于原View的Top坐标的相对距离，一点点改变
            }
        });
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_part2);
        toolbarContainer = (LinearLayout) findViewById(R.id.ll_toolbar_container_part2);
        setSupportActionBar(toolbar);
        setTitle("Part 2");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
    }


    private List<String> createItemList() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add("Item  " + i);
        }
        return list;
    }

}

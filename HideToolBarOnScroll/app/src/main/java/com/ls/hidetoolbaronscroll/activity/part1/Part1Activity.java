package com.ls.hidetoolbaronscroll.activity.part1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.ls.hidetoolbaronscroll.R;
import com.ls.hidetoolbaronscroll.adapter.part1.RecyclerAdapter;
import com.ls.hidetoolbaronscroll.listener.part1.HidingScrollListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ls on 15-3-3.
 */
public class Part1Activity extends ActionBarActivity {
    private ImageButton ibtn_faq;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part1_activity);
        initToolbar();
        ibtn_faq = (ImageButton) findViewById(R.id.btn_faq_part1);
        initRecyclerView();

    }

    private void initRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_part1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter(createItemList()));
        recyclerView.setOnScrollListener(new HidingScrollListener() {
            @Override
            public void onHide() {
                hideViews();

            }

            @Override
            public void onShow() {
                showViews();

            }
        });
    }

    private void hideViews() {
        toolbar.animate().translationY(-toolbar.getMeasuredHeight()).setInterpolator(new
                AccelerateInterpolator(2));
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) ibtn_faq.getLayoutParams();
        ibtn_faq.animate().translationY(ibtn_faq.getMeasuredHeight() + params.bottomMargin)
                .setInterpolator(new AccelerateInterpolator(2)).start();

    }

    private void showViews() {
        toolbar.animate().translationY(0).setInterpolator(new AccelerateInterpolator(2));
        ibtn_faq.animate().translationY(0).setInterpolator(new AccelerateInterpolator(2)).start();


    }

    private List<String> createItemList() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add("Item  " + i);
        }
        return list;
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_part1);
        setSupportActionBar(toolbar);
        setTitle("Part1");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
    }
}

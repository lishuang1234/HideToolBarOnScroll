package com.ls.hidetoolbaronscroll.adapter.part2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ls.hidetoolbaronscroll.R;
import com.ls.hidetoolbaronscroll.adapter.part1.viewholder.RecyclerHeaderViewHolder;
import com.ls.hidetoolbaronscroll.adapter.part1.viewholder.RecyclerItemViewHolder;

import java.util.List;

/**
 * Created by ls on 15-3-3.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> mItemListString;


    public RecyclerAdapter(List<String> itemListString) {
        this.mItemListString = itemListString;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        final View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent,
                false);
        return RecyclerItemViewHolder.newInstance(view);


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        RecyclerItemViewHolder itemViewHolder = (RecyclerItemViewHolder) holder;
        String text = mItemListString.get(position );
        itemViewHolder.setItemText(text);

    }

    @Override
    public int getItemCount() {
        return mItemListString == null ? 0 : mItemListString.size();
    }


}

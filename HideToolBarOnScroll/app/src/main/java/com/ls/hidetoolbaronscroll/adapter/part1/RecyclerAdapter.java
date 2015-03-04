package com.ls.hidetoolbaronscroll.adapter.part1;

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
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_HEADER = 2;

    public RecyclerAdapter(List<String> itemListString) {
        this.mItemListString = itemListString;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        if (viewType == TYPE_ITEM) {
            final View view = LayoutInflater.from(context).inflate(R.layout.recycler_item,
                    parent, false);
            return RecyclerItemViewHolder.newInstance(view);
        } else if (viewType == TYPE_HEADER) {
            final View view = LayoutInflater.from(context).inflate(R.layout.recycler_header,
                    parent, false);
            return new RecyclerHeaderViewHolder(view);
        }
        throw new RuntimeException("exception");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (!isHeaderPosition(position)) {
            RecyclerItemViewHolder itemViewHolder = (RecyclerItemViewHolder) holder;
            String text = mItemListString.get(position-1);
            itemViewHolder.setItemText(text);
        }
    }

    @Override
    public int getItemCount() {
        return (mItemListString == null ? 0 : mItemListString.size()) + 1;
    }

    public boolean isHeaderPosition(int position) {
        return position == 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (isHeaderPosition(position)) return TYPE_HEADER;
        return TYPE_ITEM;
    }
}

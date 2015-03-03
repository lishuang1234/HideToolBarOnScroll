package com.ls.hidetoolbaronscroll.adapter.part1.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ls.hidetoolbaronscroll.R;

/**
 * Created by ls on 15-3-3.
 */
public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
    private final TextView mItemTextView;

    public RecyclerItemViewHolder(View itemView, TextView itemTextView) {
        super(itemView);
        this.mItemTextView = itemTextView;
    }

    public static RecyclerItemViewHolder newInstance(View parent) {
        TextView item = (TextView) parent.findViewById(R.id.item_textView);
        return new RecyclerItemViewHolder(parent, item);
    }
    public void setItemText(String text){
        mItemTextView.setText(text);

    }
}
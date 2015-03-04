package com.ls.hidetoolbaronscroll;

import android.content.Context;
import android.content.res.TypedArray;

/**
 * Created by ls on 15-3-4.
 */
public class Utils {
    public static int getToolbarHeight(Context context) {
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(new int[]{R.attr
                .actionBarSize});
        int toolbarHeight = (int) typedArray.getDimension(0, 0);
        typedArray.recycle();
        return toolbarHeight;
    }

    public static int getTabHeight(Context applicationContext) {
        return (int) applicationContext.getResources().getDimension(R.dimen.tabsHeight);
    }
}

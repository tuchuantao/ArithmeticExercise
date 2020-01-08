package com.kevin.arthmeticexercise;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

/**
 * Create by Kevin-Tu on 2020/1/8.
 */
public class PrintViewTree {

    /**
     * 层序遍历
     * @param viewGroup
     */
    public void print(ViewGroup viewGroup) {
        LinkedList<View> list = new LinkedList<>();
        list.push(viewGroup);
        while (list.size() > 0) {
            View view = list.poll();
            Log.v("kevin", "View=" + view);
            if (view instanceof ViewGroup) {
                int childCount = ((ViewGroup) view).getChildCount();
                for (int i = 0; i < childCount; i++) {
                    list.addLast(((ViewGroup) view).getChildAt(i));
                }
            }
        }
    }

    /**
     * 深度遍历
     * @param viewGroup
     */
    public void print2(ViewGroup viewGroup) {
        LinkedList<View> list = new LinkedList<>();
        list.push(viewGroup);
        while (list.size() > 0) {
            View view = list.poll();
            Log.v("kevin", "View=" + view);
            if (view instanceof ViewGroup) {
                int childCount = ((ViewGroup) view).getChildCount();
                for (int i = 0; i < childCount; i++) {
                    list.push(((ViewGroup) view).getChildAt(i));
                }
            }
        }
    }
}

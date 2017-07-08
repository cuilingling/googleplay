package com.tencent.googleplay.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tencent.googleplay.utils.UIUtils;

/**
 * Created by zhaoyang on 2017/7/9.
 */

public class HomeFragment extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(UIUtils.getContext());
        textView.setGravity(Gravity.CENTER);
        textView.setText(this.getClass().getSimpleName());//"HomeFragment"
        return textView;
    }
}

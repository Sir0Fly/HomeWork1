package com.example.yaoyufei.homework1.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yaoyufei.homework1.R;

public class MainFragment extends Fragment {
    private View view;
    private TextView mFragmentTv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mFragmentTv = (TextView) view.findViewById(R.id.fragment_tv);
    }
}

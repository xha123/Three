package com.example.administrator.threeweek.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.threeweek.R;

/**
 * Created by Administrator on 2016/12/21.
 */
public class Fragment extends android.support.v4.app.Fragment implements ShowFragActivity.Toa{
    TextView tv;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("msg","绑定");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("msg","fragment创建");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment,null);
        Log.i("msg","加载布局");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv = (TextView) view.findViewById(R.id.fragment_tv);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("msg","父activity创建");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("msg","fragment启动");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("msg","fragment运行");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("msg","fragment暂停");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("msg","fragment停止");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("msg","fragment销毁视图");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("msg","fragment销毁");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("msg","fragment解除绑定");
    }

    @Override
    public void send(String str) {
        tv.setText(str);
    }
}

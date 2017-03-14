package com.example.administrator.threeweek.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.threeweek.R;
import com.example.administrator.threeweek.RoundActivity;

/**
 * Created by Administrator on 2016/12/21.
 */
public class Fragmenttwo extends android.support.v4.app.Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragmenttwo,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button bu = (Button) view.findViewById(R.id.fragmenttwo_bu);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RoundActivity.class);
                getContext().startActivity(intent);
                getActivity().finish();
            }
        });
    }
}

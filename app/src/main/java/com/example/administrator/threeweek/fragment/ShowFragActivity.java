package com.example.administrator.threeweek.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.threeweek.R;

/**
 * Created by Administrator on 2016/12/21.
 */
public class ShowFragActivity extends AppCompatActivity {
    Button bu,bu2;
    FragmentManager fm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("msg","activity创建");
        setContentView(R.layout.activity_showfrag);
        fm = getSupportFragmentManager();//获得管理器
        bu = (Button) findViewById(R.id.showfrag_bu);
        bu2 = (Button) findViewById(R.id.showfrag_bu2);

        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();//开启事务器
                Fragment fragment = new Fragment();
                ft.replace(R.id.showfrag_rl,fragment);//替换布局
                Toa toa = fragment;
                toa.send("Activity向fragment传值");
                ft.commit();//提交事务

            }
        });
        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = fm.beginTransaction();//开启事务器
                Fragmenttwo fragmenttwo = new Fragmenttwo();
                ft.replace(R.id.showfrag_rl,fragmenttwo);//替换布局
                ft.commit();//提交事务

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("msg","activity启动");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("msg","activity运行");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("msg","activity暂停");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("msg","activity停止");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("msg","activity销毁");
    }

    public interface Toa{
        void send(String str);
    }
}

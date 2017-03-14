package com.example.administrator.threeweek.toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.threeweek.R;

/**
 * Created by Administrator on 2016/12/20.
 */
public class ThreeActivity extends AppCompatActivity {
    String title;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    RelativeLayout main_rl;
    LinearLayout left_rl;
    TextView show1,show2,show3;
    ActionBarDrawerToggle abdt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent!=null){
            title = intent.getStringExtra("title");
        }
        setContentView(R.layout.item_two_page);
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar = (Toolbar) findViewById(R.id.two_toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.two_dl);
        main_rl = (RelativeLayout) findViewById(R.id.two_rl);
        left_rl = (LinearLayout) findViewById(R.id.two_dra_rl);
        show1 = (TextView) findViewById(R.id.two_left_tv1);
        show2 = (TextView) findViewById(R.id.two_left_tv2);
        show3 = (TextView) findViewById(R.id.two_left_tv3);

        toolbar.setTitle(title);
        abdt = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        abdt.syncState();
        drawerLayout.addDrawerListener(abdt);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        FragmentTa fragmentTa = new FragmentTa();
        FragmentTb fragmentTb = new FragmentTb();
        FragmentTc fragmentTc = new FragmentTc();
        ft.add(R.id.two_rl,fragmentTa);
        ft.add(R.id.two_rl,fragmentTb);
        ft.add(R.id.two_rl,fragmentTc);
        ft.hide(fragmentTa).hide(fragmentTb).hide(fragmentTc);
        Log.i("msg","隐藏碎片");
        if (title.equals("文件")){
            ft.show(fragmentTa);
            ft.commit();
            Log.i("msg","显示碎片1");
        }else if (title.equals("热点")){
            ft.show(fragmentTb);
            ft.commit();
            Log.i("msg","显示碎片2");
        }else if (title.equals("新闻")){
            ft.show(fragmentTc);
            ft.commit();
            Log.i("msg","显示碎片3");
        }
        show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThreeActivity.this,ThreeActivity.class);
                intent.putExtra("title","文件");
                startActivity(intent);
                finish();
            }
        });
        show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThreeActivity.this,ThreeActivity.class);
                intent.putExtra("title","热点");
                Log.i("msg","跳转2");
                startActivity(intent);

                finish();
            }
        });
        show3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThreeActivity.this,ThreeActivity.class);
                intent.putExtra("title","新闻");
                startActivity(intent);
                finish();
            }
        });
    }
}

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
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.threeweek.R;
import com.example.administrator.threeweek.fragment.Fragment;
import com.example.administrator.threeweek.fragment.Fragmenttwo;

/**
 * Created by Administrator on 2016/12/20.
 */
public class TwoActivity extends AppCompatActivity implements View.OnClickListener{
    String title;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    RelativeLayout main_rl,left_rl,show_rl;
    TextView show1,show2,show3;
    ActionBarDrawerToggle abdt;
    Button bu1,bu2;
    FragmentManager fm;
    Fragment fragment;
    Fragmenttwo fragmenttwo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent!=null){
            title = intent.getStringExtra("title");
        }
        setContentView(R.layout.item_one_page);
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fragment = new Fragment();
        fragmenttwo = new Fragmenttwo();
        ft.add(R.id.one_show_rl,fragment);
        ft.add(R.id.one_show_rl,fragmenttwo);
        ft.hide(fragment).hide(fragmenttwo);
        ft.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar = (Toolbar) findViewById(R.id.one_toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.one_dl);
        main_rl = (RelativeLayout) findViewById(R.id.one_rl);
        left_rl = (RelativeLayout) findViewById(R.id.one_dra_rl);
        show1 = (TextView) findViewById(R.id.one_show1_tv);
        show2 = (TextView) findViewById(R.id.one_show2_tv);
        show3 = (TextView) findViewById(R.id.one_show3_tv);
        show_rl = (RelativeLayout) findViewById(R.id.one_show_rl);
        bu1 = (Button) findViewById(R.id.one_bu1);
        bu2 = (Button) findViewById(R.id.one_bu2);

        bu1.setOnClickListener(this);
        bu2.setOnClickListener(this);
        toolbar.setTitle(title);
        abdt = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        abdt.syncState();
        drawerLayout.addDrawerListener(abdt);
        show1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwoActivity.this,roundoActivity.class);
                intent.putExtra("title","第一页");
                startActivity(intent);
                finish();
            }
        });
        show2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TwoActivity.this,"这就是第二页",Toast.LENGTH_SHORT).show();
            }
        });
        show3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TwoActivity.this,ThreeActivity.class);
                intent.putExtra("title","第三页");
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.one_bu1:
                FragmentTransaction ft = fm.beginTransaction();
                ft.hide(fragment).hide(fragmenttwo);
                ft.show(fragment);
                ft.commit();


                break;
            case R.id.one_bu2:
                FragmentTransaction ft1 = fm.beginTransaction();
                ft1.hide(fragment).hide(fragmenttwo);
                ft1.show(fragmenttwo);
                ft1.commit();
                break;
        }
    }
}

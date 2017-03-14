package com.example.administrator.threeweek.toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.threeweek.R;

/**
 * Created by Administrator on 2017/1/1.
 */
public class roundoActivity extends AppCompatActivity{
    Button bu,drawer_bu;
    String title;
    Toolbar toolbar;
    TextView textView,dra_tv;
    DrawerLayout drawerLayout;
    RelativeLayout main_rl,left_rl;
    ActionBarDrawerToggle abd;
    TextView show1_tv,show2_tv,show3_tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        if (intent!=null){
            title = intent.getStringExtra("soft");
        }
        setContentView(R.layout.activity_roundo);
        bu = (Button) findViewById(R.id.roundo_bu);
        Intent intent1 = new Intent();
        intent1.putExtra("name","这是一个回调");
        setResult(6,intent1);
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar = (Toolbar) findViewById(R.id.roundo_toolbar);
        textView = (TextView) findViewById(R.id.roundo_tv);
        main_rl = (RelativeLayout) findViewById(R.id.roundo_rl);
        left_rl = (RelativeLayout) findViewById(R.id.drawer_rl);
        drawer_bu = (Button) findViewById(R.id.drawer_bu);
        dra_tv = (TextView) findViewById(R.id.drawer_tv);
        drawerLayout = (DrawerLayout) findViewById(R.id.roundo_dl);
        show1_tv = (TextView) findViewById(R.id.dra_show1_tv);
        show2_tv = (TextView) findViewById(R.id.dra_show2_tv);
        show3_tv = (TextView) findViewById(R.id.dra_show3_tv);

        toolbar.setLogo(R.mipmap.ic_launcher);//logo
        toolbar.setTitle(R.string.toolbar_title);//设置标题
        toolbar.inflateMenu(R.menu.toolbarmenu);//添加menu
        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.mipmap.qqlo);
        abd = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);//实例化抽屉
        abd.syncState();
        drawerLayout.addDrawerListener(abd);//绑定toolbar和drawerlayout
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_one:
                        textView.setText("这是一个menu的点击效果");
                        break;
                }
                return false;
            }
        });

        drawer_bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dra_tv.setText("这是抽屉的点击效果");
            }
        });
        show1_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(roundoActivity.this,"这就是第一页",Toast.LENGTH_SHORT).show();
                toolbar.setTitle("第一页");
            }
        });
        show2_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(roundoActivity.this,TwoActivity.class);
                intent.putExtra("title","第二页");
                startActivity(intent);
                finish();
            }
        });
        show3_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(roundoActivity.this,ThreeActivity.class);
                intent.putExtra("title","第三页");
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        return true;
    }
}

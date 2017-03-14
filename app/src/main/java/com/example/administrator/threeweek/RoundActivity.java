package com.example.administrator.threeweek;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.administrator.threeweek.fragment.ShowFragActivity;
import com.example.administrator.threeweek.http.Myjavaget;
import com.example.administrator.threeweek.toolbar.roundoActivity;

/**
 * Created by Administrator on 2016/12/8.
 */
public class RoundActivity extends AppCompatActivity implements View.OnClickListener{
    RoundProgressBar rpb;
    ProgressBar pb;
    Button bu,next;
    TextView tv;
    Button show_tz;
    MyCircleView mycv;
    Button wl_bu;
    TextView wl_tv,post_tv;
    String wangluo,post_wl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

    }

    @Override
    protected void onResume() {
        super.onResume();
        rpb = (RoundProgressBar) findViewById(R.id.round_roundpb);
        pb = (ProgressBar) findViewById(R.id.round_pb);
        bu = (Button) findViewById(R.id.round_backbu);
        tv = (TextView) findViewById(R.id.round_tv);
        show_tz = (Button) findViewById(R.id.round_tz);
        mycv = (MyCircleView) findViewById(R.id.round_mycircle);
        next = (Button) findViewById(R.id.round_next_bu);
        wl_bu = (Button) findViewById(R.id.round_wl_bu);
        wl_tv = (TextView) findViewById(R.id.round_wl_tv);
        post_tv = (TextView) findViewById(R.id.round_wl_post_tv);

        wl_bu.setOnClickListener(this);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoundActivity.this, ShowFragActivity.class);
                startActivity(intent);
                finish();
            }
        });


        mycv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mycv.setArc(200,100);

            }
        });
        rpb.setMax(100);
        rpb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myrun mr = new myrun();
                Thread th = new Thread(mr);
                th.start();
            }
        });
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RoundActivity.this,roundoActivity.class);

                startActivityForResult(intent,3);

            }
        });
        show_tz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("msg",requestCode+""+resultCode+"");
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==6){
            String name = data.getStringExtra("name");
            tv.setText(name);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.round_wl_bu:
                wl_tv.setText("数据请求中");
                post_tv.setText("数据请求中");
                Thread th = new Thread(new Wangluo());
                th.start();
                break;


        }
    }

    class myrun implements Runnable{

        @Override
        public void run() {
            int m = 0;
            while (m<100){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                m++;
                Message ms = new Message();
                ms.what = 0;
                ms.obj = m;
                handler.sendMessage(ms);
            }
        }
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    int mm = (int) msg.obj;
                    rpb.setProgress(mm);
                    pb.setProgress(mm);
                    pb.setSecondaryProgress(20);
                    break;
                case 1:
                    wangluo = (String) msg.obj;
                    wl_tv.setText(wangluo);
                    break;
                case 2:
                    post_wl = (String) msg.obj;
                    post_tv.setText(post_wl);
                    break;
            }
        }
    };

    void show(){
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder noti = new NotificationCompat.Builder(this);
        noti.setTicker("开饭啦！");//设置提示语句
        noti.setContentTitle("吃什么呢？");//title
        noti.setContentText("不如算了吧\t好啊");//内容
        noti.setSmallIcon(R.mipmap.ic_launcher);//记得添加图片
        noti.setAutoCancel(true);//设置是否取消
        noti.setWhen(System.currentTimeMillis());//显示时间
        noti.setDefaults(Notification.DEFAULT_ALL);//记得添加模式
        notificationManager.notify(1,noti.build());
    }
    class Wangluo implements Runnable{

        @Override
        public void run() {
            String sl ;
            sl = Myjavaget.getDataByjavaGet();
            Message ms = new Message();
            ms.what = 1;
            ms.obj = sl;
            handler.sendMessage(ms);
            String s2=null;
            s2 = Myjavaget.getDataByjavaPost("sto","3321039672325");
            Message ms2 = new Message();
            ms2.what =2;
            ms2.obj = s2;
            handler.sendMessage(ms2);
        }
    }
}

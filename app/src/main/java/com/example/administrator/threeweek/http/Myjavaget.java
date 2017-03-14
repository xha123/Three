package com.example.administrator.threeweek.http;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2016/12/26.
 */
public class Myjavaget {

    public static String getDataByjavaGet(){
        String result = null;
        try {
            URL url = new URL("http://v.juhe.cn/exp/index?key=cf85f5511d8ee2221d490f58bf6bea31&com=yt&no=883869606345374135");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type","application/json");
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.connect();
            if (connection.getResponseCode()==200){
                //链接成功之后拿到返回的数据
                InputStream is= connection.getInputStream();//拿到返回的数据
                byte[] b=new byte[1024];
                int len=0;
                StringBuffer sb=new StringBuffer();
                while((len=is.read(b))!=-1){
                    sb.append(new String(b,0,len));
                }
                result=sb.toString();
                connection.disconnect();//关闭通道
            }else {
                result = "连接失败";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String getDataByjavaPost(String type,String number){
        String result =null;
        try {
            URL urlcom = new URL("http://v.juhe.cn/exp/index");
            HttpURLConnection urlConnection = (HttpURLConnection) urlcom.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            OutputStream outs = urlConnection.getOutputStream();
            String param = "key="
                    + URLEncoder.encode("cf85f5511d8ee2221d490f58bf6bea31", "utf-8")
                    + "&com="
                    + URLEncoder.encode(type, "utf-8")+"&no="+ URLEncoder.encode
                    (number,"utf-8"); //连接要提交的数据
            outs.write(param.getBytes());
            outs.flush();
            outs.close();
            urlConnection.connect();
            if (urlConnection.getResponseCode()==200){
                BufferedInputStream bis=new BufferedInputStream(urlConnection.getInputStream());
                byte[] b=new byte[1024];
                int len=0;
                StringBuffer sb=new StringBuffer();
                while((len=bis.read(b))!=-1){
                    sb.append(new String(b,0,len));
                }
                result=sb.toString();
                bis.close();
                urlConnection.disconnect();//关闭链接
            }else {
                return "链接失败";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  result;
    }

}

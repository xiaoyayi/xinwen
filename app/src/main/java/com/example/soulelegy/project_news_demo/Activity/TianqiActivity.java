package com.example.soulelegy.project_news_demo.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.soulelegy.project_news_demo.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by Soul elegy on 2017/8/15.
 */

public class TianqiActivity extends AppCompatActivity {
    private String path = "https://m.tianqi.com/";
    private WebView webView;
    private TextView text;
    private String riqi;
    private String wea;
    private String max;
    private String min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.josp_activity);
        text = (TextView) findViewById(R.id.text2);
        ActionBar mActionBar=getSupportActionBar();
        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setDisplayHomeAsUpEnabled(true);



        new Thread() {
            @Override
            public void run() {
                try {
                    //从一个URL加载一个Document对象。
                    Document doc = Jsoup.connect("http://www.weather.com.cn/weather/101010100.shtml").get();
                    //选择“美食天下”所在节点
                    Elements elements = doc.select("div.c7d");
                    //获取日期
                    riqi = elements.select("h1").get(0).text();
                    wea = elements.select("p").attr("title");
                    max = elements.select("span").get(0).text();
                    min = elements.select("i").get(0).text();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            text.setText("时间:" + riqi + "\r\n" + "天气" + wea + "\r\n" + "最高温度" + max + "\r\n" + "最低温度" + min);
                        }
                    });
                    //打印 <a>标签里面的title

                } catch (Exception e) {

                }


                // text.setText("时间:"+riqi+"   天气"+wea+"   最高温度"+max+"    最低"+min);
            }
        }.start();


    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

}



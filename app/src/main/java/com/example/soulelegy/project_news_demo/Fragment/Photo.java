package com.example.soulelegy.project_news_demo.Fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.soulelegy.project_news_demo.R;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by 小亚 on 2017/8/20.
 */

public class Photo extends AppCompatActivity {

    private List<String> list=new ArrayList<>();
    List<ImageView> imageViews;
    private PhotoView pt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_activity);
        pt = (PhotoView) findViewById(R.id.pt);

 /*获取Intent中的Bundle对象*/
        Bundle bundle = this.getIntent().getExtras();

        /*获取Bundle中的数据，注意类型和key*/
        String name = bundle.getString("name");
        String name2 = bundle.getString("name2");
        String name3 = bundle.getString("name3");



    }

}


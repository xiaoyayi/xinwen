package com.example.soulelegy.project_news_demo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by 小亚 on 2017/8/22.
 */

public class ParallaxListView extends ListView {
    private ImageView iv_header;
    private int drawadleHeight;
    private int mOriginalHeight;
    public ParallaxListView(Context context) {
        this(context, null);
    }
    public ParallaxListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public ParallaxListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setparallaxImage(ImageView iv_header) {
        this.iv_header = iv_header;
        //c.获取imageview控件原始高度,要回弹的高度
        mOriginalHeight = iv_header.getHeight();
        //获取图片原始高度
        drawadleHeight = iv_header.getDrawable().getIntrinsicHeight();
    }
}

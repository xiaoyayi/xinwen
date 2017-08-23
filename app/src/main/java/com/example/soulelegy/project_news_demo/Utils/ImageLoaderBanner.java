package com.example.soulelegy.project_news_demo.Utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * data:2017/7/25
 * author:高会全(Administrator )
 * function:
 */

public class ImageLoaderBanner extends ImageLoader{
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {


        Glide.with(context).load(path).into(imageView);
    }
}

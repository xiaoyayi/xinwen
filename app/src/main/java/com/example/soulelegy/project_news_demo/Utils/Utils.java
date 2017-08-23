package com.example.soulelegy.project_news_demo.Utils;

import android.content.Context;

import com.example.soulelegy.project_news_demo.R;

/**
 * Created by Soul elegy on 2017/8/2.
 */

public class Utils {
    public static int getAppTheme(Context context){
        String value = SharedPreferrenceHelper.gettheme(context);
        switch (Integer.valueOf(value)){
            case 1:
                return R.style.AppTheme;
            case 2:
                return R.style.AppThemeDark;
            default:
                return R.style.AppTheme;
        }
    }
    public static void switchAppTheme(Context context){
        String value = SharedPreferrenceHelper.gettheme(context);
        switch (Integer.valueOf(value)){
            case 1:
                SharedPreferrenceHelper.settheme(context,"2");
                break;
            case 2:
                SharedPreferrenceHelper.settheme(context,"1");
                break;
            default:
                SharedPreferrenceHelper.settheme(context,"1");
                break;
        }
    }
}

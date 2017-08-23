package com.example.soulelegy.project_news_demo.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Soul elegy on 2017/8/2.
 */

public class SharedPreferrenceHelper {
    private static final String THEME = "theme";
    public static void settheme(Context context, String theme){
        SharedPreferences sp = context.getSharedPreferences("demo",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(THEME,theme);
        editor.apply();
    }
    public static String gettheme(Context context){
        SharedPreferences sp = context.getSharedPreferences("demo",Context.MODE_PRIVATE);
        return sp.getString(THEME,"1");
    }
}

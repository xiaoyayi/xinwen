package com.example.soulelegy.project_news_demo.Utils;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.content.ContentValues.TAG;

/**
 * Created by Soul elegy on 2017/8/10.
 */

public class HttpUtils {
    //get请求获取网络数据
    public static String getData(String utl) {
            try {
                URL url = new URL(utl);
                System.out.println("iiiii"+utl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(1024 * 8);
                connection.setReadTimeout(1024 * 8);
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    InputStream inputStream = connection.getInputStream();
                    int len = 0;
                    byte[] buf = new byte[1024 * 8];
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    while ((len = inputStream.read(buf)) != -1) {
                        baos.write(buf, 0, len);
                    }
                    baos.close();
                    System.out.println("iiiiiiiiiii"+baos.toString());
                    return baos.toString();
                } else {
                    Log.e(TAG, "onCreate: Error" + responseCode);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
}

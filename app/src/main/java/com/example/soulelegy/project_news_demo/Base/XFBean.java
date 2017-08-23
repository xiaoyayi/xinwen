package com.example.soulelegy.project_news_demo.Base;

import java.util.ArrayList;

/**
 * Created by Soul elegy on 2017/8/17.
 */

public class XFBean {
    public ArrayList<WS> ws;
    public class WS{
        public ArrayList<CW> cw;
    }
    public class CW{
        public String w;
    }

}
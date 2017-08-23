package com.example.soulelegy.project_news_demo.Base;

/**
 * Created by Soul elegy on 2017/8/10.
 */

public class Img_textBase {
    private String text;
    private int img;
    //有參无参构造器
    public Img_textBase(String text, int img) {
        this.text = text;
        this.img = img;
    }
    //get,set方法
    public Img_textBase() {
    }

    public String getText() {
        return text;
    }

    public int getImg() {
        return img;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImg(int img) {
        this.img = img;
    }
    //toString方法
    @Override
    public String toString() {
        return "Img_textBase{" +
                "text='" + text + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}

package com.example.soulelegy.project_news_demo.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.soulelegy.project_news_demo.Base.DataBase;
import com.example.soulelegy.project_news_demo.R;
import com.example.soulelegy.project_news_demo.Utils.ImageloderUtils;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Soul elegy on 2017/8/11.
 */

public class MyAdapter extends BaseAdapter{
    private Context context;
    private List<DataBase.ResultBean.DataBean> list=new ArrayList<>();
    final int one=0;
    final int two=1;

    public MyAdapter(Context context, List<DataBase.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        int p=position%6;
        if (p==0){
            return two;
        }else{
            return one;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2=null;
        int type = getItemViewType(position);
        if (convertView==null){
            switch (type){
                case one:
                    holder1=new ViewHolder1();
                    convertView=View.inflate(context, R.layout.item0,null);
                    holder1.thumbnail_pic_s= (ImageView) convertView.findViewById(R.id.thumbnail_pic_s);
                    holder1.title= (TextView) convertView.findViewById(R.id.title);
                    holder1.data= (TextView) convertView.findViewById(R.id.data);
                    convertView.setTag(holder1);
                    break;
                case two:
                    holder2=new ViewHolder2();
                    convertView=View.inflate(context,R.layout.item1,null);
                    holder2.thumbnail_pic_s= (ImageView) convertView.findViewById(R.id.thumbnail_pic_s);
                    holder2.thumbnail_pic_s02= (ImageView) convertView.findViewById(R.id.thumbnail_pic_s02);
                    holder2.thumbnail_pic_s03= (ImageView) convertView.findViewById(R.id.thumbnail_pic_s03);
                    holder2.title= (TextView) convertView.findViewById(R.id.title);
                    holder2.data= (TextView) convertView.findViewById(R.id.data);
                    convertView.setTag(holder2);
                    break;
            }
        }else{
            switch (type){
                case one:
                    holder1= (ViewHolder1) convertView.getTag();
                    break;
                case two:
                    holder2= (ViewHolder2) convertView.getTag();
                    break;
            }
        }
        switch (type){
            case one:
                holder1.title.setText(list.get(position).getTitle());
                holder1.data.setText(list.get(position).getDate());
                ImageloderUtils.setImageView(list.get(position).getThumbnail_pic_s(),context,holder1.thumbnail_pic_s);
                break;
            case two:
                holder2.title.setText(list.get(position).getTitle());
                holder2.data.setText(list.get(position).getDate());
                ImageloderUtils.setImageView(list.get(position).getThumbnail_pic_s(),context,holder2.thumbnail_pic_s);
                ImageloderUtils.setImageView(list.get(position).getThumbnail_pic_s02(),context,holder2.thumbnail_pic_s02);
                ImageloderUtils.setImageView(list.get(position).getThumbnail_pic_s03(),context,holder2.thumbnail_pic_s03);
                break;
        }
        return convertView;
    }
    class ViewHolder1{
        ImageView thumbnail_pic_s;
        TextView title,data;
    }
    class ViewHolder2{
        ImageView thumbnail_pic_s,thumbnail_pic_s02,thumbnail_pic_s03;
        TextView title,data;
    }
}

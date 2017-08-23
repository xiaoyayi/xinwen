package com.example.soulelegy.project_news_demo.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.soulelegy.project_news_demo.Base.Img_textBase;
import com.example.soulelegy.project_news_demo.R;

import java.util.List;

/**
 * Created by Soul elegy on 2017/8/10.
 */

public class Img_textAdapter extends BaseAdapter{
    private Context context;
    private List<Img_textBase> data;
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public Img_textAdapter(Context context, List<Img_textBase> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewroup) {
        ViewHolder viewHolder;
        if(view==null){
            viewHolder = new ViewHolder();
            view = View.inflate(context, R.layout.left_item,null);
            viewHolder.textView = (TextView) view.findViewById(R.id.tex);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.imv);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();

        }
        viewHolder.textView.setText(data.get(i).getText());
        viewHolder.imageView.setImageResource(data.get(i).getImg());
        return view;
    }
    class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
}

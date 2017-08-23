package com.example.soulelegy.project_news_demo.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.soulelegy.project_news_demo.Activity.WebActivity;
import com.example.soulelegy.project_news_demo.Adapter.MyAdapter;
import com.example.soulelegy.project_news_demo.Base.DataBase;
import com.example.soulelegy.project_news_demo.R;
import com.example.soulelegy.project_news_demo.Utils.HttpUtils;
import com.example.soulelegy.project_news_demo.Utils.ImageLoaderBanner;
import com.example.soulelegy.project_news_demo.xListView.XListView;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class BlankFragment6 extends Fragment implements XListView.IXListViewListener{

    private String utl = "http://v.juhe.cn/toutiao/index?type=redian&key=d4c18a18c3391f90dc971633f6e6f445";
    private XListView xListView;
    private List<DataBase.ResultBean.DataBean> datas;
    private MyAdapter myAdapter;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //刷新listView
            myAdapter.notifyDataSetChanged();
            //隐藏头和尾
            closeXlistView();
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        datas = new ArrayList<DataBase.ResultBean.DataBean>();
        View view = inflater.inflate(R.layout.fragment_blank_fragment6, container, false);
        initView(view);
        new MyAsyncTask().execute(utl);
        //设置XlistView的上拉加载,下拉刷新的接口
        xListView.setXListViewListener(this);
        xListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(getContext())
                        .setTitle("删除")
                        .setMessage("确定要删除我吗?")
                        .setPositiveButton("是", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which)
                            {
                                datas.remove(position-2);
                                myAdapter.notifyDataSetChanged();
                                dialog.dismiss();

                            }
                        })
                        .setNegativeButton("否", null)
                        .show();
                return true;
            }
        });
        return view;
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                datas.add(0,datas.get(5));
                handler.sendEmptyMessage(0);
            }
        },2000);
    }

    @Override
    public void onLoadMore() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for(int x=0; x<5; x++){
                    datas.add(datas.get(x+5));
                }
                handler.sendEmptyMessage(0);
            }
        },2000);
    }
    //刷新给关闭的逻辑代码
    private void closeXlistView() {
        //停止加载更多
        xListView.stopLoadMore();
        //停止刷新
        xListView.stopRefresh();
        //更新时间
        xListView.setRefreshTime(dateFormat());
    }
    //自定义的AsyncTask
    private class MyAsyncTask extends AsyncTask<String, Integer, String> {
        //这个方法运行在主线程,在doInBackground之前运行,我们一般做初始化
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        //这个方法运行在子线程,我们可以做一个耗时操作
        @Override
        protected String doInBackground(String... strings) {
            ////////////////////////////////网络请求的操作,注意用return返回获取到的字符串,加网络权限////////////////////////////
            String data = HttpUtils.getData(strings[0]);
            Gson gson = new Gson();
            DataBase dataBase = gson.fromJson(data, DataBase.class);
            datas.addAll(dataBase.getResult().getData());

            return null;
        }

        //运行在主线程,这个方法在doInBackground执行之后执行.我们一般做从网络拿到数据,使用的数据的操作
        @Override
        protected void onPostExecute(String s) {
            ////////////////////拿到处理后的数据,更新UI///////////////////////////////
            System.out.println("iiiii"+datas);
            myAdapter = new MyAdapter(getContext(), datas);
            getBanner();
            //开启下拉刷新
            xListView.setPullRefreshEnable(true);
            //开启加载更多可用
            xListView.setPullLoadEnable(true);
            xListView.setAdapter(myAdapter);
            xListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getActivity(), WebActivity.class);
                    intent.putExtra("url",datas.get(i-2).getUrl());
                    startActivity(intent);
                }
            });
            super.onPostExecute(s);
        }
    }
    private void getBanner(){
        View view = View.inflate(getContext(),R.layout.header,null);
        Banner banner = (Banner) view.findViewById(R.id.ban);
        banner.setImageLoader(new ImageLoaderBanner());
        List<String> img=new ArrayList<>();
        DataBase.ResultBean.DataBean imgs = datas.get(0);
        img.add(imgs.getThumbnail_pic_s03());
        img.add(imgs.getThumbnail_pic_s02());
        img.add(imgs.getThumbnail_pic_s());
        banner.setImages(img);
        banner.start();
        xListView.addHeaderView(view);
    }
    private void initView(View view) {
        xListView = (XListView) view.findViewById(R.id.xListView);
    }
    /**
     * 格式化毫秒值
     *
     * @return
     */
    private String dateFormat() {
        long currentTimeMillis = System.currentTimeMillis();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String format = dateFormat.format(currentTimeMillis);

        return format;
    }

}

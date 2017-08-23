package com.example.soulelegy.project_news_demo.smallicon;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soulelegy.project_news_demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 小亚 on 2017/8/15.
 */

public class Install_Activity extends AppCompatActivity {
    String[] str1={"账号设置","我的账号","绑定其他平台","系统设置","字体设置","正文字号",
                    "主题设置","要闻推送","Wi-Fi下自动离线","非Wi-Fi网络不下载图片",
                    "列表自动加载更多","手动清理缓存","其他设置","检查更新","帮助与反馈","应用推荐","为网易评分","关于"};
    String[] str2={"","有态度网友","","","字体设置","中号字","高级黑(默认)","","","",
                    "","4.63M","","V26.2","","","",""};
    private ListView lv;
    private List<BaseData> list=new ArrayList<BaseData>();
    private boolean i=true;
    private static final int FristTupe = 0;
    private static final int TwoType = 1;
    private static final int ThreeType = 2;
    private static final int ForType=3;
    private static final int FifthType=4;
    private BaseAdapter adapter=new MyApdapter();
    private BaseData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.install_activity);
        ActionBar mActionBar=getSupportActionBar();
        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        lv=(ListView) findViewById(R.id.lv);
        Initlistview();
        for (int i = 0; i < str1.length; i++) {
            data = new BaseData();
            if (i == 0 || i == 3 || i == 12) {
                //if (i % 5==0) {
                data.setType(FristTupe);
                data.setMima(str1[i]);
            }//第二种类型的数据,也就是2等等j,去展示一个类型
            else if (i==1) {
                    //else if (i%4==0) {
                data.setType(TwoType);
                data.setMima(str1[i]);
                data.setName(str2[i]);

            }//第三种类型的数据
            else if (i == 2 || i == 14|| i==15 || i==16 || i==17) {
                    //else if (i%3==0) {
                data.setType(ThreeType);
                data.setMima(str1[i]);

            }
            else if (i == 4 || i == 5 || i == 6 || i == 11 || i == 13){
                    //else if (i%2==0){
                data.setType(ForType);
                data.setMima(str1[i]);
                data.setName(str2[i]);
            }
            else if (i == 7 || i == 8 || i == 9|| i == 10){
                data.setType(FifthType);
                data.setMima(str1[i]);
            }
            list.add(data);
        }
        MyApdapter myApdapter = new MyApdapter();
        lv.setAdapter(myApdapter);
        if (i==false){
            adapter.notifyDataSetChanged();
        }
    }

    private void Initlistview() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        new AlertDialog.Builder(Install_Activity.this)
                                .setTitle("QQ")
                                .setMessage("有态度网友")
                                .show();
                        break;
                    case 2:
                        new AlertDialog.Builder(Install_Activity.this)
                                .setTitle("其他平台")
                                .setMessage("百度")
                                .show();
                        break;

                    case 7:
                        Toast.makeText(Install_Activity.this,"1111111",Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(Install_Activity.this,"1111111",Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        Toast.makeText(Install_Activity.this,"1111111",Toast.LENGTH_SHORT).show();
                        break;
                    case 10:

                        break;

                    case 14:
                        final AlertDialog alertDialog14 = new AlertDialog.Builder(Install_Activity.this).create();
                        alertDialog14.show();
                        final Window window14 = alertDialog14.getWindow();
                        window14.setContentView(R.layout.dialog14_activity);

                        break;
                    case 15:
                        final AlertDialog alertDialog15 = new AlertDialog.Builder(Install_Activity.this).create();
                        alertDialog15.show();
                        final Window window15 = alertDialog15.getWindow();
                        window15.setContentView(R.layout.dialog15_activity);
                        Button but1= (Button) window15.findViewById(R.id.but1);
                        but1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(Install_Activity.this,"已在下载队列",Toast.LENGTH_SHORT).show();
                                alertDialog15.dismiss();
                            }
                        });
                        Button but2= (Button) window15.findViewById(R.id.but2);
                        but2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                alertDialog15.dismiss();
                            }
                        });
                        break;
                    case 16:
                        final AlertDialog alertDialog = new AlertDialog.Builder(Install_Activity.this).create();
                        alertDialog.show();
                        final Window window = alertDialog.getWindow();
                        window.setContentView(R.layout.dialog16_activity);
                        Button button1= (Button) window.findViewById(R.id.button3);
                        button1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.dismiss();
                            }
                        });
                        Button button2= (Button) window.findViewById(R.id.button2);
                        button2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(Install_Activity.this,"哈批,你确定?",Toast.LENGTH_SHORT).show();
                                alertDialog.dismiss();
                            }
                        });
                        Button button3= (Button) window.findViewById(R.id.button);
                        button3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(Install_Activity.this,"感谢老铁好评",Toast.LENGTH_SHORT).show();
                                alertDialog.dismiss();
                            }
                        });
                        break;
                    case 17:
                        new AlertDialog.Builder(Install_Activity.this)
                                .setTitle("关于网易新闻")
                                .setMessage("网易新闻是由1506D班的精心著作,可能还有些许不足,不过后期经过我们维护,相信会更好")
//                                .setPositiveButton("是", null)
//                                .setNegativeButton("否", null)
                                .show();
                        break;

                }
            }
        });

    }

    private class MyApdapter extends BaseAdapter {
        class ViewHolder1 {
            TextView tv1;
        }
        class ViewHolder2 {
            TextView tv2,tv3;
        }
        class ViewHolder3 {
            TextView tv4;
        }
        class ViewHolder4 {
            TextView tv8,tv9;
        }
        class ViewHolder7 {
            TextView tv7;
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
        public int getItemViewType(int position) {
            return list.get(position).getType();
        }
        @Override
        public int getViewTypeCount() {
            return 4;
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup viewGroup) {
            ViewHolder1 holder1 = null;
            ViewHolder2 holder2 = null;
            ViewHolder3 holder3 = null;
            ViewHolder4 holder4 = null;
            ViewHolder7 holder7 = null;
            int type = getItemViewType(position);
            if (convertView == null) {
                switch (type) {
                    case FristTupe:
                        holder1 = new ViewHolder1();
                        convertView = View.inflate(Install_Activity.this, R.layout.item_activity, null);
                        holder1.tv1 = (TextView) convertView.findViewById(R.id.textView);
                        convertView.setTag(holder1);
                        break;
                    case TwoType:
                        holder4 = new ViewHolder4();
                        convertView = View.inflate(Install_Activity.this, R.layout.item3_activity, null);
                        holder4.tv8 = (TextView) convertView.findViewById(R.id.textView5);
                        holder4.tv9 = (TextView) convertView.findViewById(R.id.textView6);
                        convertView.setTag(holder4);
                        break;
                    case ThreeType:
                        holder3 = new ViewHolder3();
                        convertView = View.inflate(Install_Activity.this, R.layout.item2_activity, null);
                        holder3.tv4 = (TextView) convertView.findViewById(R.id.textView4);
                        convertView.setTag(holder3);
                        break;
                    case ForType:
                        holder2 = new ViewHolder2();
                        convertView = View.inflate(Install_Activity.this, R.layout.item1_activity, null);
                        holder2.tv2 = (TextView) convertView.findViewById(R.id.textView2);
                        holder2.tv3 = (TextView) convertView.findViewById(R.id.textView3);
                        convertView.setTag(holder2);

                        break;
                    case FifthType:
                        holder7 = new ViewHolder7();
                        convertView = View.inflate(Install_Activity.this, R.layout.item4_activity, null);
                        holder7.tv7 = (TextView) convertView.findViewById(R.id.textView7);
                        convertView.setTag(holder7);
                        break;
                }
            } else {
                switch (type) {
                    case FristTupe:
                        holder1 = (ViewHolder1) convertView.getTag();
                        break;
                    case TwoType:
                        holder4 = (ViewHolder4) convertView.getTag();
                        break;
                    case ThreeType:
                        holder3 = (ViewHolder3) convertView.getTag();
                        break;
                    case ForType:
                        holder2 = (ViewHolder2) convertView.getTag();

                        break;
                    case FifthType:
                        holder7 = (ViewHolder7) convertView.getTag();
                        break;
                }
            }
            switch (type) {
                case FristTupe:
                    final BaseData data=list.get(position);
                    holder1.tv1.setText(list.get(position).getMima());
                    break;
                case TwoType:

                    holder4.tv8.setText(list.get(position).getMima());
                    holder4.tv9.setText(list.get(position).getName());
                    break;
                case ThreeType:
                    holder3.tv4.setText(list.get(position).getMima());
                    break;
                case ForType:
                    holder2.tv2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            switch (position){
                                case 4:
                                    Toast.makeText(Install_Activity.this,"1111111",Toast.LENGTH_SHORT).show();
                                    break;
                                case 5:
                                    Toast.makeText(Install_Activity.this,"1111111",Toast.LENGTH_SHORT).show();
                                    break;
                                case 6:
                                    Toast.makeText(Install_Activity.this,"1111111",Toast.LENGTH_SHORT).show();
                                    break;
                                case 11:
                                    new AlertDialog.Builder(Install_Activity.this)
                                            .setMessage("确定要清楚缓存吗?")
                                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which)
                                                {

                                                    list.get(position).setName("0k");
                                                    i=false;
                                                    adapter.notifyDataSetChanged();
                                                    dialog.dismiss();
                                                }
                                            })
                                            .setNegativeButton("取消", null)
                                            .show();
                                    break;
                                case 13:
                                    new AlertDialog.Builder(Install_Activity.this)
                                            .setTitle("27.0版本更新啦")
                                            .setMessage("今日要闻全新上线,星座八卦新番来袭")
                                            .setPositiveButton("立即更新", new DialogInterface.OnClickListener() {
                                                public void onClick(DialogInterface dialog, int which)
                                                {
                                                    Toast.makeText(Install_Activity.this,"正在为您更新请莫要关闭",Toast.LENGTH_SHORT).show();
                                                    dialog.dismiss();
                                                }
                                            })
                                            .setNegativeButton("取消", null)
                                            .show();
                                    break;
                            }
                        }
                    });
                    holder2.tv2.setText(list.get(position).getMima());
                    holder2.tv3.setText(list.get(position).getName());

                    break;
                case FifthType:
                    holder7.tv7.setText(list.get(position).getMima());
                    break;
            }
            return convertView;
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}
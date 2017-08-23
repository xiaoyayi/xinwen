package com.example.soulelegy.project_news_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soulelegy.project_news_demo.Activity.TianqiActivity;
import com.example.soulelegy.project_news_demo.Activity.YuyinActivity;
import com.example.soulelegy.project_news_demo.Adapter.Img_textAdapter;
import com.example.soulelegy.project_news_demo.Adapter.Pager_Adapter;
import com.example.soulelegy.project_news_demo.Base.Img_textBase;
import com.example.soulelegy.project_news_demo.Fragment.BlankFragment0;
import com.example.soulelegy.project_news_demo.Fragment.BlankFragment1;
import com.example.soulelegy.project_news_demo.Fragment.BlankFragment2;
import com.example.soulelegy.project_news_demo.Fragment.BlankFragment3;
import com.example.soulelegy.project_news_demo.Fragment.BlankFragment4;
import com.example.soulelegy.project_news_demo.Fragment.BlankFragment5;
import com.example.soulelegy.project_news_demo.Fragment.BlankFragment6;
import com.example.soulelegy.project_news_demo.Fragment.BlankFragment7;
import com.example.soulelegy.project_news_demo.Fragment.BlankFragment8;
import com.example.soulelegy.project_news_demo.Fragment.BlankFragment9;
import com.example.soulelegy.project_news_demo.Utils.ImageloderUtils;
import com.example.soulelegy.project_news_demo.Utils.Utils;
import com.example.soulelegy.project_news_demo.customview.ParallaxListView;
import com.example.soulelegy.project_news_demo.smallicon.Install_Activity;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.example.soulelegy.project_news_demo.R.id.imageview;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final int REQUEST_CODE = 110;
    private SHARE_MEDIA platform;
    private Boolean aBoolean = true;
    private TextView tv;
    private Button btn_theme;
    private RelativeLayout relativeLayout;
    private ActionBar supportActionBar;
    private TabLayout tab_layout;
    private ViewPager view_pager;
    private HorizontalScrollView hor_scroll;
    private ParallaxListView llv;
    private DrawerLayout drawer_layout;
    private ActionBarDrawerToggle mToggle;
    private ParallaxListView listv;
    private int theme = 0;
    private UMShareAPI mShareAPI = null;
    private ImageView imageView;
    private LinearLayout lin;
    private TextView textiew;
    private ImageButton image;
    private GridView grid1;
    private GridView grid2;
    private List<String> list1=new ArrayList<>();
    private List<String> list2=new ArrayList<>();
    private ArrayAdapter adapter2;
    private ArrayAdapter adapter1;
    private LinearLayout linear1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        theme = Utils.getAppTheme(this);
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PlatformConfig.setQQZone("1106036236", "mjFCi0oxXZKZEWJs");
        UMShareAPI.get(this);

        ZXingLibrary.initDisplayOpinion(this);

        initView();
        initDrawer();
        initTab();
        setAdapter2();
        setAdapter();
        imageinto();

    }

    private void imageinto() {
        list1.add("头条");
        list1.add("娱乐");
        list1.add("体育");
        list1.add("上海");
        list1.add("财经");
        list1.add("科技");
        list1.add("热点");
        list1.add("段子");
        list1.add("图片");
        list1.add("汽车");
        list2.add("八卦");
        list2.add("直播");
        list2.add("开发");
        list2.add("游戏");
        list2.add("明星");
        list2.add("星座");

        image.setOnClickListener(new View.OnClickListener() {
            private Window window;

            @Override
            public void onClick(View v) {
                final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.show();
                final Window window = alertDialog.getWindow();
                window.setContentView(R.layout.image_activity);
                grid1 = (GridView)window.findViewById(R.id.grid1);
                grid2 = (GridView)window.findViewById(R.id.grid2);

                into();
               grid1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                       String str=list1.get(position);
                       list1.remove(position);
                       list2.add(str);
//                adapter1.clear();
//                adapter2.clear();
                       into();
                   }
               });
                grid2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String str=list2.get(position);
                        list2.remove(position);
                        list1.add(str);
//                adapter1.clear();
//                adapter2.clear();
                        into();
                    }
                });

            }
        });

    }
    private void into() {
        adapter1 = new ArrayAdapter(this, R.layout.adap_activity, R.id.button, list1);
        grid1.setAdapter(adapter1);
        adapter2 = new ArrayAdapter(this, R.layout.adap_activity, R.id.button, list2);
        grid2.setAdapter(adapter2);

    }

    private void initTab() {
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new BlankFragment0());
        fragments.add(new BlankFragment1());
        fragments.add(new BlankFragment2());
        fragments.add(new BlankFragment3());
        fragments.add(new BlankFragment4());
        fragments.add(new BlankFragment5());
        fragments.add(new BlankFragment6());
        fragments.add(new BlankFragment7());
        fragments.add(new BlankFragment8());
        fragments.add(new BlankFragment9());
        view_pager.setAdapter(new Pager_Adapter(getSupportFragmentManager(), fragments));
        for (int ii = 0; ii < fragments.size(); ii++) {
            tab_layout.addTab(tab_layout.newTab());
        }
        //5.使得tablayout与viewpager相关联
        tab_layout.setupWithViewPager(view_pager);
        //6.给tablayout指示器设置文本           2，同时改变的还有这个地方
        tab_layout.getTabAt(0).setText("头条");
        tab_layout.getTabAt(1).setText("娱乐");
        tab_layout.getTabAt(2).setText("体育");
        tab_layout.getTabAt(3).setText("上海");
        tab_layout.getTabAt(4).setText("财经");
        tab_layout.getTabAt(5).setText("科技");
        tab_layout.getTabAt(6).setText("热点");
        tab_layout.getTabAt(7).setText("段子");
        tab_layout.getTabAt(8).setText("图片");
        tab_layout.getTabAt(9).setText("汽车");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        isItem_Id(item);
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initDrawer() {
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        mToggle = new ActionBarDrawerToggle(this, drawer_layout, R.string.open, R.string.close);
        mToggle.syncState();
        drawer_layout.addDrawerListener(mToggle);
        drawer_layout.setDrawerListener(new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {}
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        actionBar.hide();
                    }
                    @Override
                    public void onDrawerClosed(View drawerView) {
                        actionBar.show();
                    }
                    @Override
                    public void onDrawerStateChanged(int newState) {}
                }
        );
    }

    //查找控件
    private void initView() {
        listv = (ParallaxListView) findViewById(R.id.listv);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        view_pager = (ViewPager) findViewById(R.id.view_pager);
        hor_scroll = (HorizontalScrollView) findViewById(R.id.hor_scroll);
        llv = (ParallaxListView) findViewById(R.id.llv);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        image = (ImageButton) findViewById(R.id.imageButton2);
        imageView = (ImageView) findViewById(imageview);
        textiew = (TextView) findViewById(R.id.text);
        lin = (LinearLayout) findViewById(R.id.dengludenglu);
        grid1 = (GridView) findViewById(R.id.grid1);
        grid2 = (GridView) findViewById(R.id.grid2);
        mShareAPI = UMShareAPI.get(this);
        lin.setOnClickListener(this);

    }

    //设置左侧listview
    private void setAdapter() {
        List<Img_textBase> data = new ArrayList<Img_textBase>();
        data.add(new Img_textBase("新闻", R.drawable.ic_xinwen));
        data.add(new Img_textBase("订阅", R.drawable.ic_dingyue));
        data.add(new Img_textBase("图片", R.drawable.ic_tupian));
        data.add(new Img_textBase("视频", R.drawable.ic_shipin));
        data.add(new Img_textBase("跟帖", R.drawable.ic_gentie));
        View header = View.inflate(this, R.layout.heander, null);
        llv.addHeaderView(header);
        final ImageView image = (ImageView) header.findViewById(R.id.iv_header);
        //查一下这个方法,并做一个笔记
        //等View界面全部绘制完毕时,去得到已经绘制完毕的宽和高
        image.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //宽和高已经测量完毕
                llv.setImageView(image);
                image.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        llv.setAdapter(new Img_textAdapter(this, data));
    }

    //设置右侧listview
    private void setAdapter2() {
        List<Img_textBase> data_right = new ArrayList<Img_textBase>();
        data_right.add(new Img_textBase("商城", R.drawable.yy_r1_c1));
        data_right.add(new Img_textBase("活动", R.drawable.yy_r3_c1));
        data_right.add(new Img_textBase("应用", R.drawable.yy_r5_c1));
        data_right.add(new Img_textBase("游戏", R.drawable.yy_r7_c1));
        View header = View.inflate(this, R.layout.heander, null);
        listv.addHeaderView(header);
        final ImageView image = (ImageView) header.findViewById(R.id.iv_header);
        //查一下这个方法,并做一个笔记
        //等View界面全部绘制完毕时,去得到已经绘制完毕的宽和高
        image.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //宽和高已经测量完毕
                listv.setImageView(image);
                image.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        listv.setAdapter(new Img_textAdapter(this, data_right));
    }


    //设置menu显示icon
    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.coco, menu);
        return true;
    }

    //设置menu菜单点击事件
    public void isItem_Id(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.touxiang:

                if (aBoolean) {
                    drawer_layout.openDrawer(Gravity.RIGHT);
                    aBoolean = false;
                } else {
                    drawer_layout.closeDrawer(Gravity.RIGHT);
                    aBoolean = true;
                }
                break;
            case R.id.tianqi:
                Intent nt = new Intent(this, TianqiActivity.class);
                startActivity(nt);
                break;
//            case R.id.lixian:
//                Toast.makeText(this, "离线", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.yejian:
                Toast.makeText(this, "日夜", Toast.LENGTH_SHORT).show();
                Utils.switchAppTheme(this);
                Intent intent = getIntent();
                overridePendingTransition(0, 0);//不设置进入退出动画
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                overridePendingTransition(0, 0);
                startActivity(intent);
                break;
            case R.id.sousuo:
                startActivity(new Intent(this, YuyinActivity.class));
                break;
            case R.id.saoyi:
                Intent inte = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(inte, REQUEST_CODE);
                break;
            case R.id.shezhi:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(MainActivity.this, Install_Activity.class);
                startActivity(intent1);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mShareAPI.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onComplete(SHARE_MEDIA arg0, int arg1,
                               Map<String, String> data) {
            if (data != null) {
                textiew.setText(data.get("screen_name"));
                Set<String> keySet = data.keySet();
                //得到头像
                String iconurl = new String();
                //得到昵称
                for (String string : keySet) {
                    if (string.equals("profile_image_url")) {
                        //获取登录的图片
                        iconurl = data.get("profile_image_url");
                        Toast.makeText(MainActivity.this, "data:" + data, Toast.LENGTH_SHORT).show();
                        ImageloderUtils.setImageView(iconurl, MainActivity.this, imageView);
                    }
                }
            }
        }
        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            Toast.makeText(MainActivity.this, "授权失败", Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            Toast.makeText(MainActivity.this, "授权取消", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(View view) {
        platform = SHARE_MEDIA.QQ;
        mShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, umAuthListener);
        mShareAPI.deleteOauth(MainActivity.this, platform, umAuthListener);

    }

}

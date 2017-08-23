package com.example.soulelegy.project_news_demo.Activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.soulelegy.project_news_demo.Base.XFBean;
import com.example.soulelegy.project_news_demo.R;
import com.google.gson.Gson;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import java.util.ArrayList;

/**
 * Created by Soul elegy on 2017/8/17.
 */

public class YuyinActivity extends AppCompatActivity implements View.OnClickListener {
    private String[] mStrs = {"aaa", "bbb", "ccc", "airsaid"};
    private SearchView mSearchView;
    private ListView mListView;
    private StringBuilder mStringBuilder;
    private EditText sousuo;
    private Button inin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=59954023");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yuyinsousuo);
        initView();
        ActionBar mActionBar=getSupportActionBar();
        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setDisplayHomeAsUpEnabled(true);



    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.inin:
                sayin();
                break;
        }
    }

    private void sayin() {
        RecognizerDialog mDialog = new RecognizerDialog(this, null);
        mDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");//设置为中文模式
        mDialog.setParameter(SpeechConstant.ACCENT, "mandarin");//设置普通话模式
        mStringBuilder = new StringBuilder();
        mDialog.setListener(new RecognizerDialogListener() {
            @Override
            public void onResult(RecognizerResult recognizerResult, boolean b) {
                String resultString = recognizerResult.getResultString();
                String content = parseData(resultString);
                mStringBuilder.append(content);
                    String result = mStringBuilder.toString();
                    sousuo.setText(result);
                    System.out.println(result);
                    String anwser =new String();
                    if (result.contains("哈哈哈")) {
                        anwser = "笑啥呢";
                    }else if (result.contains("你叫什么名字?")) {
                        anwser = "我叫小娜";
                    }

                    shuo(anwser);

            }
            @Override//识别失败执行的方法,speechError错误码
            public void onError(SpeechError speechError) {
                System.out.println("错误码 " + speechError);
            }
        });
        mDialog.show();
    }


    /**
     * 把声音转换为文字
     *
     * @param view
     */
    public void Listen(View view) {
        //1.创建RecognizerDialog对象,第二个参数就是一个初始化的监听器,我们用不上就设置为null
        RecognizerDialog mDialog = new RecognizerDialog(this, null);
        //2.设置accent、language等参数
        mDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");//设置为中文模式
        mDialog.setParameter(SpeechConstant.ACCENT, "mandarin");//设置普通话模式
        //若要将UI控件用于语义理解，必须添加以下参数设置，设置之后onResult回调返回将是语义理解
        //mDialog.setParameter("asr_sch", "1");
        //mDialog.setParameter("nlp_version", "2.0");
        //创建一个装每次解析数据的容器
        mStringBuilder = new StringBuilder();
        //3.设置回调接口
        mDialog.setListener(new RecognizerDialogListener() {
            @Override//识别成功执行,参数recognizerResult 识别的结果,Json格式的字符串
            //第二参数 b:等于true时会话结束.方法才不会继续回调
            //一般情况下通过onResult接口多次返回结果,完整识别内容是多次结果累加的
            public void onResult(RecognizerResult recognizerResult, boolean b) {
                //拿到讯飞识别的结果
                String resultString = recognizerResult.getResultString();
/*                System.out.println("讯飞识别的结果 " + resultString);
                System.out.println("b参数是什么 " + b);*/
                //自定义解析bean数据的方法,得到解析数据
                String content = parseData(resultString);
//                System.out.println("解析后的数据 "+ content);
                mStringBuilder.append(content);
                //对参数2b进行判断,如果为true,代表这个方法不会对调,那么我们容器的数据转为字符串,拿来使用即可
                if (b) {
                    String result = mStringBuilder.toString();
                    System.out.println(result);
                    //回答对象,在没有匹配到用户说的话,默认输出语句
                    String anwser = "不好意思,没听明白";
                    if (result.contains("你好")) {
                        anwser = "你好,我是小娜,很高兴为你服务";
                    } else if (result.contains("美女")) {

                        String[] anwserList = new String[]{"主人有什么事吗?","喊我干啥?"};//"你是坏人不和你玩", "小助手很纯洁,不要说我听不懂的话", "小助手我就是美女,主人", "500元,小助手帮主人找美女一起打英雄联盟"};
                        int random = (int) (Math.random() * anwserList.length);
                        anwser = anwserList[random];
                    }
                    shuo(anwser);
                }
            }

            @Override//识别失败执行的方法,speechError错误码
            public void onError(SpeechError speechError) {
                System.out.println("错误码 " + speechError);
            }
        });
        //4.显示dialog，接收语音输入
        mDialog.show();
    }

    /**
     * 把文字转换为声音
     *
     * @param view
     */
    public void Talk(View view) {
        String[] anwserList = new String[]{"书山有路勤为径,学海无涯苦做粥","不经一番寒彻苦,那来梅花扑鼻香"};//"你是坏人不和你玩", "小助手很纯洁,不要说我听不懂的话", "小助手我就是美女,主人", "500元,小助手帮主人找美女一起打英雄联盟"};
        int random = (int) (Math.random() * anwserList.length);
        shuo(anwserList[random]);
       // shuo("书山有路勤为径,学海无涯苦做粥");
    }

    public void shuo(String result) {
        //1.创建 SpeechSynthesizer 对象, 第二个参数：本地合成时传 InitListener
        SpeechSynthesizer mTts = SpeechSynthesizer.createSynthesizer(this, null);
        //2.合成参数设置，详见《MSC Reference Manual》SpeechSynthesizer 类
        // 设置发音人（更多在线发音人，用户可参见 附录13.2
        mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan"); //设置发音人
        mTts.setParameter(SpeechConstant.SPEED, "50");//设置语速
        mTts.setParameter(SpeechConstant.VOLUME, "80");//设置音量，范围 0~100
        mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD); //设置云端,这些功能用到了讯飞服务器,所以要有网络
        //设置合成音频保存位置（可自定义保存位置），保存在“./sdcard/iflytek.pcm”
        //保存在 SD 卡需要在 AndroidManifest.xml 添加写 SD 卡权限
        //仅支持保存为 pcm 和 wav 格式，如果不需要保存合成音频，注释该行代码
        // mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, "./sdcard/iflytek.pcm");
        // 3.开始合成,第一个参数就是转换成声音的文字,自定义,第二个参数就是合成监听器对象,我们不需要对声音有什么特殊处理,就传null
        mTts.startSpeaking(result, null);
    }

    private String parseData(String resultString) {
        //创建gson对象.记得要关联一下gson.jar包,方可以使用
        Gson gson = new Gson();
        //参数1 String类型的json数据   参数2.存放json数据对应的bean类
        XFBean xfBean = gson.fromJson(resultString, XFBean.class);
        //创建集合,用来存放bean类里的对象
        ArrayList<XFBean.WS> ws = xfBean.ws;
        //创建一个容器,用来存放从每个集合里拿到的数据,使用StringBUndle效率高
        StringBuilder stringBuilder = new StringBuilder();
        for (XFBean.WS w : ws) {
            String text = w.cw.get(0).w;
            stringBuilder.append(text);
        }
        //把容器内的数据转换为字符串返回出去
        return stringBuilder.toString();
    }

    private void initView() {
        sousuo = (EditText) findViewById(R.id.sousuo);
        inin = (Button) findViewById(R.id.inin);
        inin.setOnClickListener(this);
    }

    private void submit() {
        // validate
        String sousuoString = sousuo.getText().toString().trim();
        if (TextUtils.isEmpty(sousuoString)) {
            Toast.makeText(this, "sousuoString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}

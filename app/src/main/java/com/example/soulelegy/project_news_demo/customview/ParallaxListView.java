package com.example.soulelegy.project_news_demo.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by Soul elegy on 2017/8/16.
 */

public class ParallaxListView extends ListView {
    private ImageView imageView;
    //图片的高度
    private int drawableHeight;
    //控件的高度
    private int mOriginalHeight;

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
        //获取imageview的高度
        mOriginalHeight = imageView.getHeight();
        //获取umageview中图片的高度
        drawableHeight = imageView.getDrawable().getIntrinsicHeight();
    }
    //三个构造方法
    public ParallaxListView(Context context) {
        this(context, null);
    }
    public ParallaxListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public ParallaxListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //滑动到listview两端的时候才会被调用
    //所有和Y轴有关的
    // deltay.isTouchEvent两个参数很重要
    //isTouchEvent : 是否是手指触摸滑动, true为手指, false为惯性
    //deltaY : 竖直方向的瞬时偏移量 / 变化量 dx   顶部到头下拉为-, 底部到头上拉为+
    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        // scrollY : 竖直方向的偏移量 / 变化量
        // scrollRangeY : 竖直方向滑动的范围
        // maxOverScrollY : 竖直方向最大滑动范围
        Log.d("jiejie", "deltaY: " + deltaY + " scrollY: " + scrollY + " scrollRangeY: " + scrollRangeY + " maxOverScrollY: " + maxOverScrollY + " isTouchEvent: " + isTouchEvent);
        //当isTouchEvent为true,也就是手指触摸滑动时
        //当竖直方向的偏移量为零,也就是要下拉时
        if (isTouchEvent && deltaY < 0) {
            //高度不超过图片最大高度时，才让其生效
            //避免图片无限放大
            if (imageView.getHeight() <= drawableHeight) {
                int newHeight = (int) (imageView.getHeight() + Math.abs(deltaY / 3.0f));
                /*int newHeight = (int) (imageView.getHeight() + Math.abs(deltaY));*/
                //把拉动的瞬时变化量的绝对值交给Header，就可以实现放大的效果了
                imageView.getLayoutParams().height = newHeight;
                imageView.requestLayout();
            }
        }
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
                //执行回弹动画，方式一：属性动画
                //从当前高度mImage.getHeight(),执行动画到原始高度mOriginalHeight
                final int startHeight = imageView.getHeight();
                final int endHeight = mOriginalHeight;
                final ValueAnimator animator = ValueAnimator.ofInt(startHeight,endHeight);
                //动画更新的监听
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float fraction = animator.getAnimatedFraction();
                        Log.d("ParallaxListView", "fraction:" + fraction);
                        //获取中间的值,并赋给控件新高度,可以使控件平稳回弹效果
                        Integer animatedValue = (Integer) animator.getAnimatedValue();
                        //让新的高度值去生效
                        imageView.getLayoutParams().height=animatedValue;
                        Log.d("ParallaxListView", "animatedValue:" + animatedValue);
                        imageView.requestLayout();
                    }
                });
                /*animator.setDuration(5000);*/
                animator.setInterpolator(new OvershootInterpolator(0.2f));
                animator.start();
                /*//ValueAnimator(startHeight,endHeight);
                //执行回弹动画，方式二：自定义Animation
                ResetAnimation animation = new ResetAnimation(imageView, startHeight, endHeight);
                startAnimation(animation);*/
                break;
            default:
                break;
        }

        return super.onTouchEvent(ev);
    }

/*
    private void ValueAnimator(final int startHeight, final int endHeight) {
            // TODO Auto-generated method stub
          ValueAnimator mValueAnimator = ValueAnimator.ofInt(1);
              mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                  @Override
                  public void onAnimationUpdate(ValueAnimator valueAnimator) {
                      // TODO Auto-generated method stub
                      float fraction = valueAnimator.getAnimatedFraction();
                      //percent 0.0-1.0
                      Integer newHeight = evaluate(fraction, startHeight, endHeight);

                      imageView.getLayoutParams().height = newHeight;
                      imageView.requestLayout();
                  }
              });
              mValueAnimator.setInterpolator(new OvershootInterpolator());
                mValueAnimator.setDuration(800);
             mValueAnimator.start();
           }





    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;
        return (int) (startInt + fraction * (endValue - startInt));
    }

    private class ResetAnimation extends Animation {
        private final ImageView mImageView;
        private final int startHeight;
        private final int endHeight;
        public ResetAnimation(ImageView mImage, int startHeight, int endHeight) {
            // TODO Auto-generated constructor stub
            this.mImageView = mImage;
            this.startHeight = startHeight;
            this.endHeight = endHeight;
            *//**
             * Interpolator被用来修饰动画效果，定义动画的变化率，可以使存在的动画效果accelerated(加速)
             * decelerated(减速)，repeated(重复)，bounced(弹跳)等
             *
             * OvershootInterpolator    向前甩一定值后再回到原来位置
             *//*
            setInterpolator(new OvershootInterpolator());
            //设置动画的执行时长
            setDuration(800);
        }
        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            // TODO Auto-generated method stub
            System.out.println(interpolatedTime);
            //interpolatedTime 0.0f -> 1.0f
            Integer newHeightInteger = evaluate(interpolatedTime, startHeight, endHeight);
            mImageView.getLayoutParams().height = newHeightInteger;
            mImageView.requestLayout();
            super.applyTransformation(interpolatedTime, t);
        }
    }*/
}


package com.example.yumatakahashi.test;

/**
 * Created by yuma.takahashi on 2015/05/16.
 */

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ScrollViewPagerIndicator extends FrameLayout implements ViewPager.OnPageChangeListener {

    private LinearLayout mContainer;
    private ImageView mMark;

    private int mCount;
    private int mCurrentPosition;

    public ScrollViewPagerIndicator(Context context) {
        this(context, null);
    }

    public ScrollViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);

        // インディケータのコンテナ
        mContainer = new LinearLayout(context);
        mContainer.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        mContainer.setGravity(Gravity.LEFT);
        mContainer.setOrientation(LinearLayout.HORIZONTAL);
        mContainer.setBackgroundColor(Color.WHITE);
        addView(mContainer);

        // 現在の位置のマーク
        mMark = new ImageView(context);
        mMark.setImageResource(R.drawable.indicator_selected);
        mMark.setLayoutParams(new LayoutParams((int) (getResources().getDimension(R.dimen.menu_padding_top_bottom) * 2 + getResources().getDimension(R.dimen.menu_icon)), (int) (getResources().getDimension(R.dimen.menu_indicator_height) + 0.5f)));
        mMark.setY(getResources().getDimension(R.dimen.menu_padding_top_bottom) * 2 + getResources().getDimension(R.dimen.menu_icon) - getResources().getDimension(R.dimen.menu_indicator_height));
        addView(mMark);
    }

    /**
     * ページ数をセットする
     *
     * @param count
     */
    public void setCount(int count, ViewPager viewPager) {
        mCount = count;
        final ViewPager vp = viewPager;
        int[] positions = new int[count];
        for (int i = 0; i < count; i++) {
            positions[i] = i;
        }

        mContainer.removeAllViews();
        // 指定されたページ数分だけコンテナにImageViewを追加
        for (final int i : positions) {
            // ImageViewにインディケータの画像をセット
            ImageView iv = new ImageView(getContext());
            int paddingDpLeftRight = getResources().getDimensionPixelSize(R.dimen.menu_padding_left_right);
            int paddingDpTopBottom = getResources().getDimensionPixelSize(R.dimen.menu_padding_top_bottom);
            iv.setPadding(paddingDpLeftRight, paddingDpTopBottom, paddingDpLeftRight, paddingDpTopBottom);

            // 追加ボタン
            iv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    vp.setCurrentItem(i);
                }
            });

            mContainer.addView(iv);
        }
        setCurrentPosition(-1);
    }

    /**
     * 現在の位置をセットする
     *
     * @param position
     */
    public void setCurrentPosition(int position) {
        if (position >= mCount) {
            position = mCount - 1;
        }
        if (position < 0) {
            position = mCount > 0 ? 0 : -1;
        }

        if (position >= 0 && position < mCount) {
            // マークの位置を変更
            updateMarkPosition(position, 0);
        }
    }

    private int mScrollingState = ViewPager.SCROLL_STATE_IDLE;

    @Override
    public void onPageSelected(int position) {
        // スクロール中はonPageScrolled()で描画するのでここではしない
        if (mScrollingState == ViewPager.SCROLL_STATE_IDLE) {
            updateMarkPosition(position, 0);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        mScrollingState = state;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels) {
        updateMarkPosition(position, positionOffset);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (mCurrentPosition >= 0 && mCurrentPosition < mCount && changed) {
            updateMarkPosition(mCurrentPosition, 0);
        }
    }

    private Resources res = getResources();
    private int grey600 = res.getColor(R.color.grey600);
    private int theme300 = res.getColor(R.color.theme300);

    private void updateMarkPosition(int position, float positionOffset) {
        mCurrentPosition = position;

        // 現在の位置のタブのView
        final View view = mContainer.getChildAt(position);
        int left = view.getLeft();
        int width = view.getWidth();

        // マークの左端の位置
        int indicatorLeft = (int) (left + positionOffset * width);

        // マークと左端の位置をセット
        mMark.setX(indicatorLeft);

        int count = mContainer.getChildCount();
        for (int i = 0; i < count; i++) {
            ImageView iv = (ImageView) mContainer.getChildAt(i);
            switch (i){
                case 0:
                    iv.setImageResource(R.drawable.menu_search);
                    break;
                case 1:
                    iv.setImageResource(R.drawable.menu_favorite);
                    break;
                case 2:
                    iv.setImageResource(R.drawable.menu_message);
                    break;
                case 3:
                    iv.setImageResource(R.drawable.menu_plan);
                    break;
            }
            if (i == mCurrentPosition) {
                iv.setColorFilter(theme300);
            } else {
                iv.setColorFilter(grey600);
            }
        }
    }
}
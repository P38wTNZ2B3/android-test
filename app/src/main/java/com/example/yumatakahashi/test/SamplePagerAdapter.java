package com.example.yumatakahashi.test;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yuma.takahashi on 2015/05/03.
 */
public class SamplePagerAdapter extends PagerAdapter {
    private static final int PAGE_COUNT = 5;

    private Context mContext;

    public SamplePagerAdapter(Context context) {
        super();
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        // TextViewを生成
        TextView textView = new TextView(mContext);
        textView.setText("Position:" + position);
        //コンテナに追加
        container.addView(textView);

        // ここではTextView自体をキーとして返しています
        return textView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // viewの削除
        // objectはinstantiateItemで返却したオブジェクトです
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        // ページ数を返します。今回は固定値としています。
        return PAGE_COUNT;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // キーが正しいかを判定
        return view == (TextView) object;
    }
}

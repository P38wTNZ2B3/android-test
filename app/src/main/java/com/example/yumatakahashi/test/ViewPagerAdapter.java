package com.example.yumatakahashi.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;

/**
 * Created by yuma.takahashi on 2015/05/04.
 */
public class ViewPagerAdapter extends PagerAdapter {

    ArrayList<ModelClass> arrayModelClasses = new ArrayList<ModelClass>();

    private ImageLoader mImageLoader;

    @SuppressLint("NewApi")
    @Override
    public void finishUpdate(ViewGroup container) {
        // TODO Auto-generated method stub
        super.finishUpdate(container);

    }

    public ViewPagerAdapter() {

        super();

    }

    public ViewPagerAdapter(ArrayList<ModelClass> arrayModelClasses) {

        super();
        this.arrayModelClasses = arrayModelClasses;

    }

    @Override
    public int getCount() {

        return arrayModelClasses.size();

    }

    @Override
    public boolean isViewFromObject(View collection, Object object) {

        return collection == ((View) object);
    }

    @Override
    public Object instantiateItem(View collection, int position) {

        // Inflating layout
        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.drawer_list_item, null);

        TextView itemText = (TextView) view.findViewById(R.id.title);

        //startAsyncLoadImage("http://test-yuma.s3.amazonaws.com/test/droid.png");
        //ImageView imageIcon = (ImageView) view.findViewById(R.id.icon);
        //imageIcon.setImageResource(R.mipmap.droid_blue);




        try {

            itemText.setText(arrayModelClasses.get(position)
                    .getTitleToDisplay());

        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        ((ViewPager) collection).addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }


}
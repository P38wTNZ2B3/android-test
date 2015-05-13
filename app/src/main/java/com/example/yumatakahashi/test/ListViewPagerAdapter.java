package com.example.yumatakahashi.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuma.takahashi on 2015/05/04.
 */
public class ListViewPagerAdapter extends ArrayAdapter<ModelClass> {

    ViewPagerAdapter mViewPagerAdapter;
    private Context context;
    private ArrayList<ModelClass> navigationItems;
    private int selectedIndex;

    public ListViewPagerAdapter(Context context, ArrayList<ModelClass> navigationItems) {
        super(context, R.layout.view_pager_list_view, navigationItems);
        this.context = context;
        this.navigationItems = navigationItems;


        for (int i = 0; i < 1000; i++) {
            flag.put(i, false);
        }
    }

    @Override
    public int getCount() {
        return navigationItems.size();
    }

    public void setSelectedIndex(int position) {
        selectedIndex = position;
        notifyDataSetChanged();
    }

    @Override
    public ModelClass getItem(int position) {
        return navigationItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }





    private Map<Integer, Boolean> flag = new HashMap<Integer, Boolean>();
    private Map<Integer, ViewPagerAdapter> keep = new HashMap<Integer, ViewPagerAdapter>();

    //private ViewPager vp;

    @SuppressLint("NewApi")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        //View view;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            //convertView = inflater.inflate(R.layout.view_pager_list_view, null);
            convertView = inflater.inflate(R.layout.view_pager_list_view, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            //view = convertView;
            //return view;
        }

        //if (flag.get(position)) {
        //    return view;
        //}

        //ModelClass modelClass = getItem(position);

        //ArrayList<ModelClass> navigationItemsLocal = new ArrayList<ModelClass>();
        /*String[] s = {
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
                "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
                "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png"
        };
                for (String ss : s) {
            navigationItemsLocal.add(new ModelClass(ss));
        }
*/
        /*String[][] s = {
                {
                         "https://test-yuma.s3.amazonaws.com/test/droid.png",
                         "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
                         "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_red.png"
                },
                {
                        "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img01.jpg",
                        "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img02.jpg",
                        "https://s3-ap-northeast-1.amazonaws.com/test-yuma/iphoroid/gallery_img03.jpg"
                }

        };
        for (String ss : s[position]) {
            navigationItemsLocal.add(new ModelClass(ss));
        }*/
        //mViewPagerAdapter = new ViewPagerAdapter(navigationItemsLocal);


        /*if (flag.get(position)) {
            mViewPagerAdapter = keep.get(position);
        } else {
            mViewPagerAdapter = new ViewPagerAdapter(navigationItemsLocal, position);
            keep.put(position, mViewPagerAdapter);
            flag.put(position, true);
            ((ViewPager) view.findViewById(R.id.list_pager)).setAdapter(mViewPagerAdapter);
        }*/



        if (flag.get(position)) {
            mViewPagerAdapter = keep.get(position);
        } else {
            mViewPagerAdapter = new ViewPagerAdapter(navigationItems.get(position), position);
            keep.put(position, mViewPagerAdapter);
            flag.put(position, true);
        }

        //vp = (ViewPager) view.findViewById(R.id.list_pager);
        //mViewPagerAdapter = new ViewPagerAdapter(navigationItemsLocal, position);
        if (holder.vp.getTag() == null || !holder.vp.getTag().equals(mViewPagerAdapter)) {
            //((ViewPager) view.findViewById(R.id.list_pager)).setAdapter(mViewPagerAdapter);
            holder.vp.setAdapter(mViewPagerAdapter);
            holder.vp.setTag(mViewPagerAdapter);
        }





        /*if (mViewPagerAdapter.getTag() == null ||
                !mViewPagerAdapter.getTag().equals(item.getImageUrl())) {
            ImageLoader.getInstance().displayImage(item.getImageUrl(), holder.mImageView);
            holder.mImageView.setTag(item.getImageUrl());
        }*/

        //view.setTag(position);

        return convertView;
    }

    private static class ViewHolder {
        ViewPager vp;

        public ViewHolder(View view) {
            this.vp = (ViewPager) view.findViewById(R.id.list_pager);
        }
    }


    /*@SuppressLint("NewApi")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            //convertView = inflater.inflate(R.layout.view_pager_list_view, null);
            convertView = inflater.inflate(R.layout.view_pager_list_view, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ModelClass modelClass = getItem(position);

        //ViewPager vp = (ViewPager) convertView.findViewById(R.id.list_pager);

        //if (selectedIndex != -1 && position == selectedIndex) {
        //   vp.setBackground(getContext().getResources().getDrawable(
        //            //R.drawable.gradient_selected));
        //            R.mipmap.ic_launcher));
        //} else {
        //    vp.setBackground(getContext().getResources().getDrawable(
        //            //R.drawable.gradient));
        //            R.mipmap.ic_launcher));
        //}
        //if (selectedIndex != -1 && position == selectedIndex) {
        //   vp.setBackground(getContext().getResources().getDrawable(
        //            R.mipmap.selected));
        //} else {
        //   vp.setBackground(getContext().getResources().getDrawable(
        //            R.mipmap.selected));
        //}

        mViewPagerAdapter = new ViewPagerAdapter(navigationItems);
        holder.vp.setAdapter(mViewPagerAdapter);

        return convertView;
    }

    private static class ViewHolder {
        ViewPager vp;

        public ViewHolder(View view) {
            this.vp = (ViewPager) view.findViewById(R.id.list_pager);
        }
    }*/
}


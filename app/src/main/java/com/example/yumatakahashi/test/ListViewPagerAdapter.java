package com.example.yumatakahashi.test;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by yuma.takahashi on 2015/05/04.
 */
public class ListViewPagerAdapter extends ArrayAdapter<ModelClass> {

    private ArrayList<ModelClass> navigationItems;

    public ListViewPagerAdapter(Context context, ArrayList<ModelClass> navigationItems) {
        super(context, R.layout.view_pager_list_view, navigationItems);
        this.navigationItems = navigationItems;
    }

    @Override
    public int getCount() {
        return navigationItems.size();
    }

    @Override
    public ModelClass getItem(int position) {
        return navigationItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.view_pager_list_view, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (holder.vp.getTag() == null || !holder.vp.getTag().equals(position)) {
            //holder.vp.setAdapter(new ViewPagerAdapter(navigationItems.get(position), position));
            holder.vp.setAdapter(new ViewPagerAdapter(navigationItems.get(position)));
            holder.vp.setTag(position);
        }

        return convertView;
    }

    private static class ViewHolder {
        ViewPager vp;
        public ViewHolder(View view) {
            this.vp = (ViewPager) view.findViewById(R.id.list_pager);
        }
    }
}


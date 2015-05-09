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

    @SuppressLint("NewApi")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            //convertView = View.inflate(getContext(), R.layout.view_pager_list_view, parent);
            convertView = inflater.inflate(R.layout.view_pager_list_view, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ModelClass modelClass = getItem(position);

        //ViewPager vp = (ViewPager) convertView.findViewById(R.id.list_pager);

        /*if (selectedIndex != -1 && position == selectedIndex) {
            vp.setBackground(getContext().getResources().getDrawable(
                    //R.drawable.gradient_selected));
                    R.mipmap.ic_launcher));
        } else {
            vp.setBackground(getContext().getResources().getDrawable(
                    //R.drawable.gradient));
                    R.mipmap.ic_launcher));
        }*/
/*        if (selectedIndex != -1 && position == selectedIndex) {
            vp.setBackground(getContext().getResources().getDrawable(
                    R.mipmap.selected));
        } else {
            vp.setBackground(getContext().getResources().getDrawable(
                    R.mipmap.selected));
        }*/

        mViewPagerAdapter = new ViewPagerAdapter(navigationItems);
        holder.vp.setAdapter(mViewPagerAdapter);

        return convertView;
    }

    private static class ViewHolder {
        ViewPager vp;

        public ViewHolder(View view) {
            this.vp = (ViewPager) view.findViewById(R.id.list_pager);
        }
    }

}
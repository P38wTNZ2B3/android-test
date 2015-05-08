package com.example.yumatakahashi.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yuma.takahashi on 2015/05/03.
 */
public class CustomListItemAdapter extends ArrayAdapter<String> {
    private LayoutInflater mLayoutInflater;

    public CustomListItemAdapter(Context context, List<String> objects) {
        // 第2引数はtextViewResourceIdとされていますが、カスタムリストアイテムを使用する場合は特に意識する必要のない引数です
        super(context, 0, objects);
        // レイアウト生成に使用するインフレーター
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        View view = convertView;
        if (convertView == null) {
            // レイアウトファイルからViewを生成する
            view = mLayoutInflater.inflate(R.layout.customlistitem, parent, false);

            holder = new ViewHolder();
            //holder.image = (ImageView) view.findViewById(R.id.imageView1);
            //holder.title = (TextView) view.findViewById(R.id.TitleText);
            //holder.subtitle = (TextView) view.findViewById(R.id.SubTitleText);
            holder.textview1 = (TextView) view.findViewById(R.id.TextView1);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        // リストアイテムに対応するデータを取得する
        String item = getItem(position);

        // 各Viewに表示する情報を設定
        //TextView text1 = (TextView) view.findViewById(R.id.TitleText);
        //text1.setText("Title:" + item);
        //TextView text2 = (TextView) view.findViewById(R.id.SubTitleText);
        //text2.setText("SubTitle:" + item);
        TextView textview1 = (TextView) view.findViewById(R.id.TextView1);
        textview1.setText("textview1:" + item);

/*
        View view = null;

        // ListViewに表示する分のレイアウトが生成されていない場合レイアウトを作成する
        if (convertView == null) {
            // レイアウトファイルからViewを生成する
            view = mLayoutInflater.inflate(R.layout.customlistitem, parent, false);

            // リストアイテムに対応するデータを取得する
            String item = getItem(position);

            // 各Viewに表示する情報を設定
            TextView text1 = (TextView) view.findViewById(R.id.TitleText);
            text1.setText("Title:" + item);
            TextView text2 = (TextView) view.findViewById(R.id.SubTitleText);
            text2.setText("SubTitle:" + item);
        } else {
            // レイアウトが存在する場合は再利用する
            view = convertView;
        }
*/


        return view;
    }

    static class ViewHolder {
        ImageView image;
        TextView title;
        TextView subtitle;
        TextView textview1;
    }
}

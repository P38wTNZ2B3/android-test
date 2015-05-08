package com.example.yumatakahashi.test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by yuma.takahashi on 2015/05/04.
 */
public class SubActivity extends FragmentActivity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        if(intent != null){
            //String str = intent.getStringExtra("org.jpn.techbooster.demo.intent.testString");
            //Toast.makeText(this, str, Toast.LENGTH_LONG).show();

            // FragmentManager も、android.support.v4.app.FragmentManager を利用する
            FragmentManager manager = getSupportFragmentManager();
            // レイアウトから Fragment を見つけ出してインスタンスを得る
            Fragment fragment = manager.findFragmentById(R.id.MyFragment);

        }
    }




}

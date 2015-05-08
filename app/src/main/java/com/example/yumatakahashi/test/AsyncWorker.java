package com.example.yumatakahashi.test;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
//import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by yuma.takahashi on 2015/05/06.
 */
public class AsyncWorker extends AsyncTaskLoader<Bitmap> {
    //private Bitmap bitmap;
    //private String url = "";
    private String imageUrl = "";


    public AsyncWorker(Context context, String url) {
        super(context);
        this.imageUrl = url;
    }

    @Override
    public Bitmap loadInBackground() {
        //Bitmap bmp = null;

        //url から画像を取得する処理・・・
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        //return bmp;
    }

    //@Override
    //protected void onStartLoading() {
    //     forceLoad();
    //}
}

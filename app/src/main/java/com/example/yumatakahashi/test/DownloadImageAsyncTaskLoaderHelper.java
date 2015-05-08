package com.example.yumatakahashi.test;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by yuma.takahashi on 2015/05/04.
 */
public class DownloadImageAsyncTaskLoaderHelper extends AsyncTaskLoader<Bitmap> {

    private String imageUrl = "";
    private Context context = null;

    public DownloadImageAsyncTaskLoaderHelper(Context context, String url) {
        super(context);

        this.imageUrl = url;
        this.context = context;
    }

    @Override
    public Bitmap loadInBackground() {
        //return HttpUtil.getBitmapHttpService(context, url);

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
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
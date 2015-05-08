package com.example.yumatakahashi.test;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.widget.ImageView;

/**
 * Created by yuma.takahashi on 2015/05/05.
 */
public class StartAsyncLoadImage extends FragmentActivity implements LoaderManager.LoaderCallbacks<Bitmap> {

    // Loaderの初期化から起動までを行います
    public void startAsyncLoadImage(String url) {
        Bundle args = new Bundle();
        args.putString("url", url);
        getSupportLoaderManager().initLoader(0, args, this);    // onCreateLoaderが呼ばれます

        // 複数のLoaderを同時に動かす場合は、第一引数を一意のIDにしてやる必要があります。
        // GridViewなどに表示する画像を非同期で一気に取得する場合とか
    }

    @Override
    public Loader<Bitmap> onCreateLoader(int id, Bundle args) {

        // 非同期で処理を実行するLoaderを生成します.
        // ここを切り替えてあげるだけで様々な非同期処理に対応できます.
        if(args != null) {
            String url = args.getString("url");
            return new DownloadImageAsyncTaskLoaderHelper(this, url);
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Bitmap> arg0, Bitmap arg1) {

        // 非同期処理が終了したら呼ばれます.
        // 今回はDownloadが完了した画像をImageViewに表示します.
        ImageView imageView = (ImageView)findViewById(R.id.icon);
        Drawable iconImage = new BitmapDrawable(getResources(), arg1);
        imageView.setImageDrawable(iconImage);
        imageView.invalidate();
    }

    @Override
    public void onLoaderReset(Loader<Bitmap> arg0) {

    }

}

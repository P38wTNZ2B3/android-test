package com.example.yumatakahashi.test;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by yuma.takahashi on 2015/05/03.
 */
public class BoundService extends Service {
    public static final String TAG = BoundService.class.getSimpleName();
    private final IBinder mBinder = new ServiceBinder();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(TAG, "onCreate");
    }

    // 最初にバインドした時のコールバック
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    // 再度バインドした時のコールバック
    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.v(TAG, "onRebind");
    }

    // バインドを解除された時のコールバック
    @Override
    public boolean onUnbind(Intent intent) {
        Log.v(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy");
    }

    // サービスをバインドした後、バインドしたサービスのインスタンスそのものを得るためのインタフェース
    public class ServiceBinder extends Binder {
        public BoundService getService() {
            return BoundService.this;
        }
    }
}
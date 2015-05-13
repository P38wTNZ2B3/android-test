package com.example.yumatakahashi.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

/**
 * Created by yuma.takahashi on 2015/05/04.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private ModelClass modelClass;
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    public void finishUpdate(ViewGroup container) {
        super.finishUpdate(container);

    }

    public ViewPagerAdapter() {
        super();
    }

    public ViewPagerAdapter(ModelClass modelClass) {
        super();
        this.modelClass = modelClass;
    }

    @Override
    public int getCount() {
        return modelClass.getImageUrl().length;
    }

    @Override
    public boolean isViewFromObject(View collection, Object object) {
        return collection == ((View) object);
    }


    private RequestQueue queue = MyApplication.getInstance().getRequestQueue();
    private ImageLoader mImageLoader = new ImageLoader(queue, new LruCacheSample());

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        LayoutInflater inflater = (LayoutInflater) collection.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.drawer_list_item, null);

        TextView itemText = (TextView) view.findViewById(R.id.title);
        NetworkImageView nImageView = (NetworkImageView) view.findViewById(R.id.network_image_view);

        String url = modelClass.getImageUrl()[position];

        itemText.setText(position + modelClass.getImageUrl()[position]);
        nImageView.setImageUrl(url, mImageLoader);
        //Log.d(TAG, "image load : " + url);

        collection.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public class NoImageCacheSample implements ImageLoader.ImageCache {

        NoImageCacheSample() {}

        // ImageCacheのインターフェイス実装
        @Override
        public Bitmap getBitmap(String url) {
            return null;
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
        }
    }

    public class LruCacheSample implements ImageLoader.ImageCache {

        private LruCache<String, Bitmap> mMemoryCache;

        LruCacheSample(){
            int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
            int cacheSize = maxMemory / 8;       // 最大メモリに依存
            // int cacheSize = 5 * 1024 * 1024;  // 5MB

            mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    // 使用キャッシュサイズ(KB単位)
                    //return bitmap.getByteCount() / 1024;
                    return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
                }
            };
        }

        // ImageCacheのインターフェイス実装
        @Override
        public Bitmap getBitmap(String url) {
            return mMemoryCache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            mMemoryCache.put(url,bitmap);
        }
    }
}
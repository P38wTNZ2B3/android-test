package com.example.yumatakahashi.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuma.takahashi on 2015/05/04.
 */
public class ViewPagerAdapter extends PagerAdapter {

    //ArrayList<ModelClass> arrayModelClasses = new ArrayList<ModelClass>();
    //ModelClass modelClass = new ModelClass();
    ModelClass modelClass;

    //@SuppressLint("NewApi")
    @Override
    public void finishUpdate(ViewGroup container) {
        super.finishUpdate(container);

    }

    public ViewPagerAdapter() {
        super();
    }

    public ViewPagerAdapter(ModelClass modelClass, Integer row) {
        super();
        //this.arrayModelClasses = arrayModelClasses;
        this.modelClass = modelClass;
        this.row = row;
        Map<Integer, View> hashmap = new HashMap<Integer, View>();
        hashmap.put(0, null);
        hashmap.put(1, null);
        hashmap.put(2, null);
        hashmap.put(3, null);
        //hashmap.put(0, null);
        this.map.put(row, hashmap);
    }

    @Override
    public int getCount() {
        return modelClass.getImageUrl().length;
    }

    @Override
    public boolean isViewFromObject(View collection, Object object) {
        return collection == ((View) object);
    }

    //@Override
    //public Object instantiateItem(ViewGroup collection, int position) {
    /*public Object instantiateItem(View collection, int position) {

        // Inflating layout
        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.drawer_list_item, null);

        TextView itemText = (TextView) view.findViewById(R.id.title);

        RequestQueue queue = MyApplication.getInstance().getRequestQueue();
        //String url = "http://techbooster.org/wp-content/uploads/2013/08/densi.png";
        String url = arrayModelClasses.get(position).getTitleToDisplay();

        //NetworkImageView nImageView = (NetworkImageView) view.findViewById(R.id.network_image_view);
        //nImageView.setImageUrl(url, new ImageLoader(queue, new LruCacheSample()));
        ImageView iv = (ImageView) view.findViewById(R.id.network_image_view);
        iv.setImageResource(R.mipmap.droid_blue);


        //nImageView.setImageUrl(url, new ImageLoader(queue, new NoImageCacheSample()));
        //nImageView.setDefaultImageResId(defaultImageResId);
        //nImageView.setErrorImageResId(errorImageResId);


        try {
            itemText.setText(position + arrayModelClasses.get(position).getTitleToDisplay());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        ((ViewPager) collection).addView(view, 0);
        return view;
    }*/
    private RequestQueue queue = MyApplication.getInstance().getRequestQueue();
    private ImageLoader mImageLoader = new ImageLoader(queue, new LruCacheSample());
    private NetworkImageView nImageView;
    private Integer row;
    private Map<Integer, Map<Integer, View>> map = new HashMap<Integer, Map<Integer, View>>();
    @Override
    //public Object instantiateItem(ViewGroup collection, int position) {
    public Object instantiateItem(View collection, int position) {
        ViewHolder holder;

        /*if (map.get(row).get(position) != null) {
            //((ViewPager) collection).addView(map.get(row).get(position), 0);
            return map.get(row).get(position);
        }*/

        // Inflating layout
        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.drawer_list_item, null);

        TextView itemText = (TextView) view.findViewById(R.id.title);

        //String url = arrayModelClasses.get(position).getTitleToDisplay();
        String url = modelClass.getImageUrl()[position];

        //if (nImageView == null) {
            nImageView = (NetworkImageView) view.findViewById(R.id.network_image_view);
        //}

        //NetworkImageView nImageView = (NetworkImageView) view.findViewById(R.id.network_image_view);
        if (nImageView.getTag() == null ||
                !nImageView.getTag().equals(url)) {
            ///ImageLoader.getInstance().displayImage(item.getImageUrl(), holder.mImageView);
            nImageView.setImageUrl(url, mImageLoader);
            nImageView.setTag(url);
            Log.d(TAG, "image load " + url);
        }


        //itemText.setText(position + arrayModelClasses.get(position).getTitleToDisplay());
        itemText.setText(position + modelClass.getImageUrl()[position]);

        map.get(row).put(row, view);

        //nImageView.setImageUrl(url, new ImageLoader(queue, new NoImageCacheSample()));
        //nImageView.setDefaultImageResId(defaultImageResId);
        //nImageView.setErrorImageResId(errorImageResId);


        /*try {
            itemText.setText(position + arrayModelClasses.get(position).getTitleToDisplay());
        } catch (Exception e1) {
            e1.printStackTrace();
        }*/
        ((ViewPager) collection).addView(view, 0);
        return view;
    }

    private static class ViewHolder {
        NetworkImageView niv;

        public ViewHolder(View view) {
            this.niv = (NetworkImageView) view.findViewById(R.id.network_image_view);
        }
    }

    @Override
    //public void destroyItem(ViewGroup container, int position, Object object) {
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
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

    public static final String TAG = MainActivity.class.getSimpleName();
    private static final int MEM_CACHE_SIZE = 1 * 1024 * 1024; // 1MB

    public class LruCacheSample implements ImageLoader.ImageCache {

        private LruCache<String, Bitmap> mMemoryCache;


        LruCacheSample(){
            //int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
            //int cacheSize = maxMemory / 8;       // 最大メモリに依存
            //Log.d(TAG, "cache size: " + cacheSize);
            // int cacheSize = 5 * 1024 * 1024;  // 5MB

            //mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            mMemoryCache = new LruCache<String, Bitmap>(MEM_CACHE_SIZE) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    // 使用キャッシュサイズ(KB単位)
                    //return bitmap.getByteCount() / 1024;
                    return bitmap.getRowBytes() * bitmap.getHeight();
                }
            };
        }

        // ImageCacheのインターフェイス実装
        @Override
        public Bitmap getBitmap(String url) {
            //Log.d(TAG, "cache use");
            return mMemoryCache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            mMemoryCache.put(url,bitmap);
        }
    }
}
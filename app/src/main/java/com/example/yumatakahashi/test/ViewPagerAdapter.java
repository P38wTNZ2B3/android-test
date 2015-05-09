package com.example.yumatakahashi.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by yuma.takahashi on 2015/05/04.
 */
public class ViewPagerAdapter extends PagerAdapter {

    ArrayList<ModelClass> arrayModelClasses = new ArrayList<ModelClass>();

    private ImageLoader mImageLoader;

    @SuppressLint("NewApi")
    @Override
    public void finishUpdate(ViewGroup container) {
        // TODO Auto-generated method stub
        super.finishUpdate(container);

    }

    public ViewPagerAdapter() {

        super();

    }

    public ViewPagerAdapter(ArrayList<ModelClass> arrayModelClasses) {

        super();
        this.arrayModelClasses = arrayModelClasses;

    }

    @Override
    public int getCount() {

        return arrayModelClasses.size();

    }

    @Override
    public boolean isViewFromObject(View collection, Object object) {

        return collection == ((View) object);
    }

    @Override
    public Object instantiateItem(View collection, int position) {

        // Inflating layout
        LayoutInflater inflater = (LayoutInflater) collection.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.drawer_list_item, null);

        TextView itemText = (TextView) view.findViewById(R.id.title);

        //startAsyncLoadImage("http://test-yuma.s3.amazonaws.com/test/droid.png");
        //ImageView imageIcon = (ImageView) view.findViewById(R.id.icon);
        //imageIcon.setImageResource(R.mipmap.droid_blue);


        //RequestQueue queue = Volley.newRequestQueue(this);
        RequestQueue queue = MyApplication.getInstance().getRequestQueue();
        //String url = "http://techbooster.org/wp-content/uploads/2013/08/densi.png";
        String url = arrayModelClasses.get(position).getTitleToDisplay();

        NetworkImageView nImageView = (NetworkImageView) view.findViewById(R.id.network_image_view);
        nImageView.setImageUrl(url, new ImageLoader(queue, new LruCacheSample()));
        //nImageView.setImageUrl(url, new ImageLoader(queue, new NoImageCacheSample   ()));
        //nImageView.setDefaultImageResId(defaultImageResId);
        //nImageView.setErrorImageResId(errorImageResId);

        try {

            itemText.setText(arrayModelClasses.get(position)
                    .getTitleToDisplay());

        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        ((ViewPager) collection).addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    public class NoImageCacheSample implements ImageLoader.ImageCache {

        NoImageCacheSample(){
        }

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
                    return bitmap.getByteCount() / 1024;
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
package com.example.yumatakahashi.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;


//public class MainActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<Bitmap> {
public class MainActivity extends FragmentActivity {

    //ネットリクエストをQueue
    private RequestQueue mQueue;
    public static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
/*
        // FragmentManager も、android.support.v4.app.FragmentManager を利用する
        FragmentManager manager = getSupportFragmentManager();
        // レイアウトから Fragment を見つけ出してインスタンスを得る
        Fragment fragment = manager.findFragmentById(R.id.MyFragment);
*/


        ImageView iv = (ImageView)this.findViewById(R.id.image01);
        // drawableフォルダにある任意のイメージを設定
        iv.setImageResource(R.mipmap.ic_launcher);

        // ImageViewオブジェクトにクリックイベントを追加する
        iv.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        // イメージ画像がクリックされたときに実行される処理
                        //Toast.makeText(MainActivity.this, "click", Toast.LENGTH_LONG).show();

                        // メッセージのオブジェクトとして Intent を作る
                        // どの Context から、どのクラスに対してメッセージを送るかを指定する
                        Intent intent = new Intent(MainActivity.this, SubActivity.class);
                        // Intent を Context に渡して、メッセージを送る
                        // この場合、NextActivity クラスにメッセージが送られ、NextActivity が立ち上がる
                        startActivity(intent);
                    }
                }
        );


        //mQueue = Volley.newRequestQueue(getApplicationContext());
        //requestVolley();

        /*
        // 東京都の天気情報
        String url =
                "http://weather.livedoor.com/forecast/webservice/json/v1?city=130010";

        mQueue = Volley.newRequestQueue(this);
        mQueue.add(new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // JSONObjectのパース、List、Viewへの追加等
                    }
                },

                new Response.ErrorListener() {
                    @Override public void onErrorResponse(VolleyError error) {
                        // エラー処理 error.networkResponseで確認
                        // エラー表示など
                    }
                }));
*/


/*
        //リクト用のQueueを初期化
        mQueue = Volley.newRequestQueue(this);
        //接続先
        String url = "http://www.bluecode.jp/test/stock/price.php";

        //キューにリクエストを追加
        mQueue.add(new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>(){

                    @Override
                    public void onResponse(JSONObject response){

                        try{

                            Log.v("tama",response.getString("price"));
                            //取得した値を表示
                            //tv.setText(response.getString("price"));
                            //Log.v(response.getString("price"));
                            //response.getString("price");
                            //Log.v("tama",response.getString("price"));

                        }catch(JSONException e){

                            e.printStackTrace();

                        }
                    }

                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error){
                        //エラー処理
                    }

                }));

*/








        /*// カスタムイメージビューを作成
        LoaderImageView liv = (LoaderImageView) findViewById(R.id.imageView);
        // 取得するURLをセット
        liv.setUrl("https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid.png");
        // ローダーを作成しロード開始
        //Loader loader = getSupportLoaderManager().initLoader(0, null, liv);
        //loader.forceLoad();
        getSupportLoaderManager().initLoader(0, null, liv);

*/
        //startAsyncLoadImage("http://test-yuma.s3.amazonaws.com/test/droid.png");
/*
        ViewPager pager = (ViewPager) findViewById(R.id.Pager);

        FragmentManager fm = getSupportFragmentManager();
        SampleFragmentPagerAdapter sampleFragmentPagerAdapter = new SampleFragmentPagerAdapter(fm);

        pager.setAdapter(sampleFragmentPagerAdapter);


        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add("hoge" + i);
        }

        ListView listView = (ListView) findViewById(R.id.ListView);
        // android.R.layout.simple_list_item_1はAndroidで既に定義されているリストアイテムのレイアウトです
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          //      android.R.layout.customlistitem, list);
        CustomListItemAdapter adapter = new CustomListItemAdapter(this, list);


        listView.setAdapter(adapter);



        // タップした時の動作を定義する
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Adapterからタップした位置のデータを取得する
                String str = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        */

    }
    /*
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
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        Drawable iconImage = new BitmapDrawable(getResources(), arg1);
        imageView.setImageDrawable(iconImage);
        imageView.invalidate();
    }

    @Override
    public void onLoaderReset(Loader<Bitmap> arg0) {

    }

*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
/*
    private void requestVolley() {
        // Volley でリクエスト
        String url = "http://www.google.com/uds/GnewsSearch?q=Obama&v=1.0";
        mQueue.add(new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "response : " + response.toString());
                        //Log.d(MainActivity, "response : " + response.toString());
                    }
                }, null));
        new Response.Listener<JSONObject>() {};
        mQueue.start();
    }
*/


}

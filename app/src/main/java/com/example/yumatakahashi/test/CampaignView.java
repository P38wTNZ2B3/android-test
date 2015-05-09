package com.example.yumatakahashi.test;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yuma.takahashi on 2015/05/04.
 */
public class CampaignView extends Fragment implements AbsListView.OnScrollListener {

    ListViewPagerAdapter listViewPagerAdapter;

    public static final String TAG = MainActivity.class.getSimpleName();

    public CampaignView() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View campainview = inflater.inflate(R.layout.campaignview, container,
                false);

        return campainview;
    }

    /*private final static String[] s = {
            "https://test-yuma.s3.amazonaws.com/test/droid.png",
            "https://test-yuma.s3.amazonaws.com/test/droid.png",
            "https://test-yuma.s3.amazonaws.com/test/droid.png",
            "https://test-yuma.s3.amazonaws.com/test/droid.png",
            "https://test-yuma.s3.amazonaws.com/test/droid.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://test-yuma.s3.amazonaws.com/test/droid.png",
            "https://test-yuma.s3.amazonaws.com/test/droid.png",
            "https://test-yuma.s3.amazonaws.com/test/droid.png",
            "https://test-yuma.s3.amazonaws.com/test/droid.png",
            "https://test-yuma.s3.amazonaws.com/test/droid.png"
    };*/

    private final static String[] s = {
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png",
            "https://s3-ap-northeast-1.amazonaws.com/test-yuma/test/droid_blue.png"
    };


    private ArrayList<ModelClass> aList = new ArrayList<ModelClass>();
    //private List<Map<String, String>> mList;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        //String[] s = { "a", "b", "c", "d", "b", "c", "d", "b", "c", "d", "b",
        //        "c", "d", "b", "c", "d", "b", "c", "d" };
        /*String[] s = {
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png",
                "https://test-yuma.s3.amazonaws.com/test/droid.png"
        };
*/

        //ArrayList<ModelClass> aList = new ArrayList<ModelClass>();



/*
        //int id = 0;
        for (String s1 : s) {

            aList.add(new ModelClass(s1));

            //AsyncLoaderImageView imageView = (AsyncLoaderImageView)getActivity().findViewById(R.id.icon);
            //imageView.setImageUrl(s1);

            //getLoaderManager().initLoader(id, null, imageView);//ローダーを実行
            //id++;

        }
*/

/*        //RequestQueue queue = Volley.newRequestQueue(this);
        RequestQueue mQueue = MyApplication.getInstance().getRequestQueue();


        // Volley でリクエスト
        String url = "http://www.google.com/uds/GnewsSearch?q=Obama&v=1.0";
        mQueue.add(new JsonObjectRequest(Request.Method.GET, url, (String) null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.d(TAG, "response : " + response.toString());
                        Toast.makeText(getActivity(), response.toString(), Toast.LENGTH_LONG).show();
                    }
                }, null));
        mQueue.start();
  */


        /*
        ListView lv1 = (ListView) getActivity().findViewById(
                R.id.campaignListView);
        // lv1.setAdapter(new ArrayAdapter<String>(getActivity(),
        // android.R.layout.simple_list_item_1,aList));
        listViewPagerAdapter = new ListViewPagerAdapter(getActivity(), aList);
        lv1.setAdapter(listViewPagerAdapter);
        lv1.addFooterView(getFooter());
        lv1.setOnScrollListener(this);
*/


        ListView listView = getListView();
        listView.addFooterView(getFooter());
        listView.setAdapter(getAdapter());
        listView.setOnScrollListener(this);


    }

    private ListViewPagerAdapter mAdapter;

    private ListViewPagerAdapter getAdapter() {
        if (mAdapter == null) {
/*            mAdapter = new ListViewPagerAdapter(this, getList(),
                    android.R.layout.simple_list_item_1, new String[] { TEXT },
                    new int[] { android.R.id.text1 });*/
            mAdapter = new ListViewPagerAdapter(getActivity(), getList());
        }
        return mAdapter;
    }

    private View mFooter;
    private final static int MAX_COUNT = 10;
    private int mCount = 0;
    private final static int MAX_VIEW_COUNT = 5;
    private ListView mListView;
    private AsyncTask<Long, Void, Void> mTask;
    //private final static String TEXT = "text";


    private View getFooter() {
        if (mFooter == null) {
            mFooter = getActivity().getLayoutInflater().inflate(R.layout.listview_footer,
                    null);
        }
        return mFooter;
    }

    //private List<String> mList;

    private ArrayList<ModelClass> getList() {
        if (aList == null) {
            aList = new ArrayList<ModelClass>();
            addListData();
        }
        return aList;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        if (totalItemCount == firstVisibleItem + visibleItemCount) {
            additionalReading();
        }
    }

    private void additionalReading() {
        // 読み込み回数が最大値以上ならスキップ。フッタを消す
        if (mCount >= MAX_COUNT) {
            invisibleFooter();
            return;
        }
        // 既に読み込み中ならスキップ
        if (mTask != null && mTask.getStatus() == AsyncTask.Status.RUNNING) {
            return;
        }
        mTask = new AsyncTask<Long, Void, Void>() {
            @Override
            protected Void doInBackground(Long[] params) {
                try {
                    Log.d(TAG, "sleep..." + params[0]);
                    Thread.sleep(params[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            };

            protected void onPostExecute(Void result) {
                addListData();
                getListView().invalidateViews();
            };
        }.execute(Math.abs(new Random(System.currentTimeMillis()).nextLong() % 3000));
    }

    private void invisibleFooter() {
        getListView().removeFooterView(getFooter());
    }

    private ListView getListView() {
        if (mListView == null) {
            mListView = (ListView) getActivity().findViewById(R.id.campaignListView);
        }
        return mListView;
    }

    private void addListData() {
        Log.d(TAG, "additionalReading");
        ArrayList<ModelClass> list = getList();
        //ArrayList<ModelClass> subList = (ArrayList) getList().subList(mCount, mCount + MAX_VIEW_COUNT);
        for (String b : s) {
            ModelClass modelClass = new ModelClass(b);
            //string.put(TEXT, b + mCount);
            list.add(modelClass);
        }
        mCount++;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }

}
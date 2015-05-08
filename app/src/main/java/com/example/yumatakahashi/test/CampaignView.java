package com.example.yumatakahashi.test;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by yuma.takahashi on 2015/05/04.
 */
public class CampaignView extends Fragment {

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

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        //String[] s = { "a", "b", "c", "d", "b", "c", "d", "b", "c", "d", "b",
        //        "c", "d", "b", "c", "d", "b", "c", "d" };
        String[] s = {
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


        ArrayList<ModelClass> aList = new ArrayList<ModelClass>();




        //int id = 0;
        for (String s1 : s) {

            aList.add(new ModelClass(s1));
/*
            AsyncLoaderImageView imageView = (AsyncLoaderImageView)getActivity().findViewById(R.id.icon);
            imageView.setImageUrl(s1);

            getLoaderManager().initLoader(id, null, imageView);//ローダーを実行
            id++;
            */
        }


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


        ListView lv1 = (ListView) getActivity().findViewById(
                R.id.campaignListView);
        // lv1.setAdapter(new ArrayAdapter<String>(getActivity(),
        // android.R.layout.simple_list_item_1,aList));
        listViewPagerAdapter = new ListViewPagerAdapter(getActivity(), aList);
        lv1.setAdapter(listViewPagerAdapter);



    }

}
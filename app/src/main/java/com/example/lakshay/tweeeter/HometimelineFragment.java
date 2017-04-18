package com.example.lakshay.tweeeter;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.twitter.sdk.android.Twitter;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lakshay on 4/13/2017.
 */

public class HometimelineFragment extends android.support.v4.app.Fragment {
    RecyclerView hometimelinelistview;
   User_Tweet_Fragment_Adapter userTweetFragmentAdapter;
    ArrayList<Tweet> tweets;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view=  inflater.inflate(R.layout.hometimelinefragmentlayout,container,false);
        hometimelinelistview=(RecyclerView) view.findViewById(R.id.hometimeline_listview);

        tweets= new ArrayList<>();

     userTweetFragmentAdapter= new User_Tweet_Fragment_Adapter(getActivity(),tweets);


       hometimelinelistview.setAdapter(userTweetFragmentAdapter);
       hometimelinelistview.setLayoutManager(new LinearLayoutManager(getActivity()));
        fetchhometimline();

        return  view;


    }
    public void fetchhometimline(){
        HashMap<String,String>query=new HashMap<>();
        query.put("screen_name",Twitter.getSessionManager().getActiveSession().getUserName());
        query.put("count",200+"");

        GetauthHeader getauthHeader= new GetauthHeader();
        getauthHeader.setBaseurl("https://api.twitter.com/1.1/statuses/home_timeline.json");
        getauthHeader.setQuery(query);
        String header= getauthHeader.returnheader();
        Log.i("header",header);

        ApiInterface apiInterface= ApiClient.getAuthorizedApiInterface();
        apiInterface.gethometweets(header,Twitter.getSessionManager().getActiveSession().getUserName(),200).enqueue(new Callback<ArrayList<Tweet>>() {
            @Override
            public void onResponse(Call<ArrayList<Tweet>> call, Response<ArrayList<Tweet>> response) {
                Log.i("hometimeline",response.body()+"");
                Log.i("interfresponsemessage",response.message());
                ArrayList<Tweet> hometweets=response.body();
                tweets.addAll(hometweets);
                userTweetFragmentAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Tweet>> call, Throwable t) {

            }
        });

    }


}

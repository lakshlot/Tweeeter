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

import com.twitter.sdk.android.Twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Lakshay on 4/7/2017.
 */

public class User_Tweet_Fragment extends Fragment {
    RecyclerView listview;
    ArrayList<Tweet> tweets;
    User_Tweet_Fragment_Adapter userTweetFragmentAdapter;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.users_tweets_fragment,container,false);
        listview=(RecyclerView) view.findViewById(R.id.user_tweets_list);
        tweets= new ArrayList<>();
        userTweetFragmentAdapter= new User_Tweet_Fragment_Adapter(getActivity(),tweets);
        listview.setAdapter(userTweetFragmentAdapter);
        listview.setLayoutManager(new LinearLayoutManager(getActivity()));


    fetchtweets();

        return  view;


    }
    public void fetchtweets(){
        HashMap<String,String> query=new HashMap<>();
        query.put("screen_name",Twitter.getSessionManager().getActiveSession().getUserName());

        GetauthHeader getauthHeader= new GetauthHeader();
       getauthHeader.setBaseurl("https://api.twitter.com/1.1/statuses/user_timeline.json");
        getauthHeader.setQuery(query);
        String header= getauthHeader.returnheader();
        ApiInterface apiInterface= ApiClient.getAuthorizedApiInterface();
        apiInterface.gettweets(header, Twitter.getSessionManager().getActiveSession().getUserName()).enqueue(new Callback<ArrayList<Tweet>>() {
            @Override
            public void onResponse(Call<ArrayList<Tweet>> call, Response<ArrayList<Tweet>> response) {
                Log.i("tweetarraylist", response.body().toString());
                ArrayList<Tweet> tweetArrayList = response.body();
               tweets.addAll(tweetArrayList);
               userTweetFragmentAdapter.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<ArrayList<Tweet>> call, Throwable t) {

            }
        });

    }
}




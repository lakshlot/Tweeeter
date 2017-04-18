package com.example.lakshay.tweeeter;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ListView;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.Timeline;
import com.twitter.sdk.android.tweetui.TimelineResult;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.twitter.sdk.android.tweetui.TweetView;

public class Search_Activity extends AppCompatActivity {
    private boolean flagloading;
    private boolean endsearchresult;
    private static String search_query="#modi";
    private TweetTimelineListAdapter adapter;
    private static final String Search_resulttype="recent";
    private static final int Search_count=20;
    private long maxId;
    ListView searchlist;
    Timeline<Tweet> tweetTimeline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_);




    }
}

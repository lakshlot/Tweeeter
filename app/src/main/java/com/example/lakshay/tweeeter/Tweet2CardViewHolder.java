package com.example.lakshay.tweeeter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Lakshay on 4/10/2017.
 */

public class Tweet2CardViewHolder extends RecyclerView.ViewHolder {
    //Imageview
    CircleImageView userprofilepic;
    ImageView Mediapic;

    //TextViews
    TextView username;
    TextView screen_name;
    TextView tweetpostday;
    TextView replycount;
    TextView likecount;
    TextView retweetcount;
    TextView status;
    //Buttons
    Button moreoptionsbutton;



    public Tweet2CardViewHolder(View itemView) {
        super(itemView);
        this.userprofilepic=(CircleImageView)itemView.findViewById(R.id.user_profile_card_view);
        this.Mediapic=(ImageView)itemView.findViewById(R.id.tweet_mediaView);
        this.likecount=(TextView)itemView.findViewById(R.id.textView10);
        this.replycount=(TextView)itemView.findViewById(R.id.textView6);
        this.retweetcount=(TextView)itemView.findViewById(R.id.textView8);
        this.username=(TextView)itemView.findViewById(R.id.user_profile_card_view);
        this.status=(TextView)itemView.findViewById(R.id.tweet_statuscardtext);
        this.screen_name=(TextView)itemView.findViewById(R.id.screen_name_cardview);
        this.tweetpostday=(TextView)itemView.findViewById(R.id.tweet_post_day_card_view);
        this.moreoptionsbutton=(Button)itemView.findViewById(R.id.tweet_moreoptionbutton);

    }
}

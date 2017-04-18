package com.example.lakshay.tweeeter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Lakshay on 4/9/2017.
 */

public class User_Tweet_Fragment_Adapter extends  RecyclerView.Adapter<User_Tweet_Fragment_Adapter.TweetCardViewHolder>{

        private ArrayList<Tweet> tweets;
    Context context;

        public User_Tweet_Fragment_Adapter(Context context,ArrayList<Tweet> tweets) {
            this.tweets = tweets;
            this.context=context;
        }

        @Override
        public int getItemCount() {
            return tweets.size();
        }

        @Override
        public void onBindViewHolder(TweetCardViewHolder tweetCardViewHolder, int i) {
           Tweet tweet = tweets.get(i);
           tweetCardViewHolder.likecount.setText(tweet.favorite_count+"");
           tweetCardViewHolder.retweetcount.setText(tweet.retweet_count+"");
            tweetCardViewHolder.status.setText(tweet.text);
            tweetCardViewHolder.tweetpostday.setText(tweet.created_at);
            tweetCardViewHolder.username.setText(tweet.user.getName());
            tweetCardViewHolder.screen_name.setText(tweet.user.getScreen_name());
            Picasso.with(context).load(tweet.user.getProfile_image_url()).into(tweetCardViewHolder.userprofilepic);

        }

        @Override
        public TweetCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.
                    from(context).
                    inflate(R.layout.user_tweets_horizontal_view, viewGroup, false);

            return new TweetCardViewHolder(itemView);
        }
    public static  class TweetCardViewHolder extends RecyclerView.ViewHolder {
        //Imageview
        CircleImageView userprofilepic;
        ImageView Mediapic;
        ImageView retweeticon;
        ImageView replyicon;
        ImageView likeicon;


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


        public TweetCardViewHolder(View itemView) {
            super(itemView);
            this.userprofilepic = (CircleImageView) itemView.findViewById(R.id.user_profile_card_view);
            this.Mediapic = (ImageView) itemView.findViewById(R.id.tweet_mediaView);
            this.likecount = (TextView) itemView.findViewById(R.id.textView10);
            this.replycount = (TextView) itemView.findViewById(R.id.textView6);
            this.retweetcount = (TextView) itemView.findViewById(R.id.textView8);
            this.username = (TextView) itemView.findViewById(R.id.username_cardview);
            this.status = (TextView) itemView.findViewById(R.id.tweet_statuscardtext);
            this.screen_name = (TextView) itemView.findViewById(R.id.screen_name_cardview);
            this.tweetpostday = (TextView) itemView.findViewById(R.id.tweet_post_day_card_view);
            this.moreoptionsbutton = (Button) itemView.findViewById(R.id.tweet_moreoptionbutton);
            this.replyicon=(ImageView)itemView.findViewById(R.id.textView5);
            this.retweeticon=(ImageView)itemView.findViewById(R.id.textView7);
            this.likeicon=(ImageView)itemView.findViewById(R.id.textView9);

        }
    }

}




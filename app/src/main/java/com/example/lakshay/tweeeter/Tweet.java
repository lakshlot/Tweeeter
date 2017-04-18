package com.example.lakshay.tweeeter;

import com.twitter.sdk.android.core.models.User;

import java.util.Date;

/**
 * Created by Lakshay on 4/10/2017.
 */

public class Tweet {
    String  created_at;
    String text;
    int retweet_count;
    int favorite_count;
    User_Profile user;



    public Tweet(String created_at, String text, int retweet_count, int favorite_count) {
        this.created_at = created_at;
        this.text = text;
        this.retweet_count = retweet_count;
        this.favorite_count = favorite_count;
    }
    public User_Profile getUser() {
        return user;
    }

    public void setUser(User_Profile user) {
        this.user = user;
    }
    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRetweet_count() {
        return retweet_count;
    }

    public void setRetweet_count(int retweet_count) {
        this.retweet_count = retweet_count;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }
}

package com.example.lakshay.tweeeter;

/**
 * Created by Lakshay on 3/29/2017.
 */

public class User_Profile {
  long id;
    String name;
    String screen_name;
    int followers_count;
    int  friends_count; // following
    int statuses_count;
    int retweet_count;
    String profile_image_url;
    String profile_banner_url;


    public User_Profile(long id, String name, String screen_name, int followers_count, int friends_count, int statuses_count, int retweet_count, String profile_image_url, String profile_banner_url) {
        this.id = id;
        this.name = name;
        this.screen_name = screen_name;
        this.followers_count = followers_count;
        this.friends_count = friends_count;
        this.statuses_count = statuses_count;
        this.retweet_count = retweet_count;
        this.profile_image_url = profile_image_url;
        this.profile_banner_url = profile_banner_url;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    public int getFriends_count() {
        return friends_count;
    }

    public void setFriends_count(int friends_count) {
        this.friends_count = friends_count;
    }

    public int getStatuses_count() {
        return statuses_count;
    }

    public void setStatuses_count(int statuses_count) {
        this.statuses_count = statuses_count;
    }

    public int getRetweet_count() {
        return retweet_count;
    }

    public void setRetweet_count(int retweet_count) {
        this.retweet_count = retweet_count;
    }

    public String getProfile_image_url() {
//        String[] s;
//        s=profile_image_url.split("_");
//        return s[0]+"_"+s[1]+".jpg";
        return profile_image_url;
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getProfile_banner_url() {
        return profile_banner_url;
    }

    public void setProfile_banner_url(String profile_banner_url) {
        this.profile_banner_url = profile_banner_url;
    }
}

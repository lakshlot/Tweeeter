package com.example.lakshay.tweeeter;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Lakshay on 3/19/2017.
 */

public interface ApiInterface {


@GET("users/show.json")
Call<User_Profile> getUsers(@Header("Authorization")String header,@Query("screen_name") String screename);

    @GET("statuses/user_timeline.json")
    Call<ArrayList<Tweet>> gettweets(@Header("Authorization") String header,@Query("screen_name") String screename);

    @GET("statuses/home_timeline.json")
    Call<ArrayList<Tweet>> gethometweets(@Header("Authorization") String header,@Query("screen_name")String screename,@Query("count") int count);


}

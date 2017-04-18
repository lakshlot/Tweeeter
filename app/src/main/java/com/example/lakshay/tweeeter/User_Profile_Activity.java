package com.example.lakshay.tweeeter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.Image;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.core.services.StatusesService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class User_Profile_Activity extends AppCompatActivity  {
    private TwitterSession session;
    private long userid;
    Button logoutbutton;
    Toolbar toolbar;



    //ImageViews

    ImageView profile_picturedisplay;
    ImageView banner_display;




    private String authheader;
    private  String randomstr;

   //urls
    String banner_url;
    String profilepicture_url;

    //Textviews
    TextView namedisplay;
    TextView screenamedisplay;
    TextView noftweetsdiplay;
    TextView nooffollowers;
    TextView nooffollowing;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__profile_);
      toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.getBackground().setAlpha(0);



        FloatingActionButton floatingActionButton=(FloatingActionButton)findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Twitter.getSessionManager().clearActiveSession();
                Twitter.logOut();
                finish();
            }
        });






        fetchcontent();


        //Setting ImageView
        profile_picturedisplay=(ImageView)findViewById(R.id.profile_picture);
        banner_display=(ImageView)findViewById(R.id.banner_view);


        //Setting TextViews
        screenamedisplay=(TextView)findViewById(R.id.screen_name);
        namedisplay=(TextView)findViewById(R.id.user_name);
        noftweetsdiplay=(TextView)findViewById(R.id.no_of_tweets);
        nooffollowers=(TextView)findViewById(R.id.no_of_followers);
        nooffollowing=(TextView)findViewById(R.id.no_of_following);


      




















//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
    }

     public  void fetchcontent() {
         HashMap<String,String>query=new HashMap<>();
         query.put("screen_name",Twitter.getSessionManager().getActiveSession().getUserName());

         GetauthHeader getauthHeader= new GetauthHeader();
        getauthHeader.setBaseurl("https://api.twitter.com/1.1/users/show.json");
         getauthHeader.setQuery(query);
         String header= getauthHeader.returnheader();

         final ApiInterface apiInterface = ApiClient.getAuthorizedApiInterface();



         apiInterface.getUsers(header,Twitter.getSessionManager().getActiveSession().getUserName())
                .enqueue(new Callback<User_Profile>() {
                    @Override
                    public void onResponse(Call<User_Profile> call, Response<User_Profile> response) {



                        //Assigning urls
                        banner_url=response.body().getProfile_banner_url();
                        profilepicture_url=response.body().getProfile_image_url();

                        //Assigning Texts
                        screenamedisplay.setText(response.body().getScreen_name());
                        noftweetsdiplay.setText(""+response.body().getStatuses_count());
                        namedisplay.setText(response.body().getName());
                        nooffollowers.setText(""+response.body().getFollowers_count());
                        nooffollowing.setText(""+response.body().getFriends_count());
                        toolbar.setTitle(response.body().getName());
                        toolbar.setSubtitle("yash56200");



                        //Assigning ImageViews
                        Picasso.with(User_Profile_Activity.this).load(banner_url).into(banner_display);
                        Picasso.with(User_Profile_Activity.this).load(profilepicture_url).into(profile_picturedisplay);



                        //Log Body


                        Log.i("Bodyresponsemessage",response.message());
                        Log.i("Bodyresponse",response.body().toString());
                        Log.i("bodybannerurl",banner_url);
                        Log.i("bodyprofileurl",profilepicture_url);
                        Log.i("bodyscreenname",response.body().getScreen_name());
                        Log.i("bodyname",response.body().getName());
                        Log.i("body",response.body().getStatuses_count()+"");











                    }

                    @Override
                    public void onFailure(Call<User_Profile> call, Throwable t) {
                        Log.i("Bodyonfailure",t.getMessage());

                    }
                });






     }





}



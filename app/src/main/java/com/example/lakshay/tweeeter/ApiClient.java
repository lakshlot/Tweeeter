package com.example.lakshay.tweeeter;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.AuthToken;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Header;


public class ApiClient {
    static ApiInterface apiInterface;

    public static ApiInterface getAuthorizedApiInterface() {

        if (apiInterface == null) {

//             OkHttpClient.Builder builder = new OkHttpClient.Builder();
//            Interceptor interceptor = new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    Request request = chain.request().newBuilder().addHeader("Authorization",getauthHeader.returnheader()).build();
//                    return chain.proceed(request);
//                }
//            };
//            builder.addInterceptor(interceptor);




            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.twitter.com/1.1/")
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().
                            serializeNulls().create()))
                    .build();
            apiInterface = retrofit.create(ApiInterface.class);
            ;
        }
        return apiInterface;
    }
}













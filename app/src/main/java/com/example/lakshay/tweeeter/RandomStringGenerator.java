package com.example.lakshay.tweeeter;

import android.util.Log;

import java.util.Random;

/**
 * Created by Lakshay on 4/1/2017.
 */

public class RandomStringGenerator {

    public String getRandomstring(){
        Random random= new Random();
        String randomstring= "kYjzVBB8Y0ZFabxSWbWovY3uYSQ2pTgmZeNu2VS4cgj"+random.toString();
        return randomstring;
    }
    }

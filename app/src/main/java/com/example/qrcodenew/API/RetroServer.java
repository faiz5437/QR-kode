package com.example.qrcodenew.API;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {

//    private static String BASE_URL = "https://reqres.in/api/";
    private static Retrofit retro;
    public static ApiRequestData endpoint (String BASE_URL){
        Retrofit retro = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retro.create(ApiRequestData.class);
    }
}

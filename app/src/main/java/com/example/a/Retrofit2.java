package com.example.a;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit2 {
    private static Retrofit retrofit=null;

    public static Retrofit  getCilen(String uir){
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(uir).addConverterFactory(GsonConverterFactory.create()).build();
        }



        return retrofit;
    }
}

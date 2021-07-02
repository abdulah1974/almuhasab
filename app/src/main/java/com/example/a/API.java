package com.example.a;

import android.telephony.mbms.FileServiceInfo;

import java.io.File;

import retrofit2.Retrofit;

public class API {
    private API(){

    }
    public  static final  String API_Uir="http://192.168.100.75:5050/mstriat/upload";
    public static File  getfil(){
        return ApiClient.getApiClient(API_Uir).create(File.class);

    }
}

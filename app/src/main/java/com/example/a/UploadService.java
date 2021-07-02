package com.example.a;

import java.io.File;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;


public interface UploadService {

@Multipart
@POST("upload")
Call<File> upload ( MultipartBody.Part file);


}

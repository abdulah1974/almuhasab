package com.example.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.a.model.fileinfo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class upload extends AppCompatActivity {
EditText Name;
EditText Number;
EditText Price;
EditText Description;
Bitmap bitmap;
ImageView imageView;
String encodedimage;
String ImagePath;
Button button;
    private String selectedFilePath;
    Uri fileP ;
    UploadService UploadService;
    private int STORAGE_PERMISSION_CODE = 1;

   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        Name = findViewById(R.id.Name);
        Number = findViewById(R.id.Number);
        Price = findViewById(R.id.Price);
        Description = findViewById(R.id.Description);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(gallery,"Sellect Photo"),1);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadtoserver(fileP);
                ss();
            }
        });


    }


    @Override
    public void  onActivityResult(int requestCode , int resultCode , @Nullable Intent data) {
        if (requestCode ==1&& resultCode == RESULT_OK){
            Uri filePath = data.getData();
            fileP = data.getData();
            try {
                InputStream  inputStream = getContentResolver().openInputStream(filePath);
                bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
                ImagePath = getRealPathFromURI(data.getData());
                Toast.makeText(upload.this,"change",Toast.LENGTH_LONG).show();
                encodebitmap(bitmap);
                uploadtoserver(filePath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
    public String getRealPathFromURI (Uri contentUri) {
        String path = null;
        String[] proj = { MediaStore.MediaColumns.DATA };
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            path = cursor.getString(column_index);
        }
        cursor.close();
        return path;
    }


    private void uploadtoserver(Uri uri)
    {
        try {


            final String name = Name.getText().toString().trim();
            final String number = Number.getText().toString().trim();
            final String price = Price.getText().toString().trim();
            final String description = Description.getText().toString().trim();
            final String url = "";
            File file = new File(ImagePath);

            // create RequestBody instance from file
            RequestBody requestFile =
                    RequestBody.create(
                            MediaType.parse(getContentResolver().getType(uri)),
                            file
                    );

            // MultipartBody.Part is used to send also the actual file name
            MultipartBody.Part body =
                    MultipartBody.Part.createFormData("photo", file.getName(), requestFile);

            Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://192.168.100.75:5050/mstriat/upload")
                    .addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.build();
            UploadService uploadService = retrofit.create(UploadService.class);


            RequestBody description_ =
                    RequestBody.create(
                            okhttp3.MultipartBody.FORM, description);

           /// Call<ResponseBody> call = uploadService.upload(body , description_);

        }catch (Exception e){}
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void encodebitmap(Bitmap bitmap)
    {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);

        byte[] byteofimages=byteArrayOutputStream.toByteArray();
        encodedimage=android.util.Base64.encodeToString(byteofimages, Base64.DEFAULT);
    }
    public  void ss()
    {

        File file = new File(selectedFilePath);
        RequestBody requestBody=RequestBody.create(MediaType.parse("multipart/form-data"),file);
            MultipartBody.Part body=  MultipartBody.Part.createFormData("file",file.getName(),requestBody);
            Call<File> call=UploadService.upload(body);
            call.enqueue(new Callback<File>() {
                @Override
                public void onResponse(Call<File> call, Response<File> response) {
                    Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<File> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),"no",Toast.LENGTH_LONG).show();
                }
            });
        }
        }












package com.example.a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent;
        SharedPreferences sharedPreferences=getSharedPreferences("Abd", Context.MODE_PRIVATE);
        if (sharedPreferences.getString("email",null)!=null||sharedPreferences.getString("pass",null)!=null){
            intent=new Intent(MainActivity.this,home.class);
        }else {
            intent =new Intent(MainActivity.this,login.class);
        }


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                startActivity(intent);


                // Intent mainIntent = new Intent(MainActivity.this,LoginOrSignin.class);
                // startActivity(mainIntent);
                // finish();


            }
        }, 2000);
    }
}
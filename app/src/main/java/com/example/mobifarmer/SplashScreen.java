package com.example.mobifarmer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {



    private int sleeptimer = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_splash_screen);
        Logoluncher logoluncher = new Logoluncher();
        logoluncher.start();



    }



    private class Logoluncher extends  Thread {


        public void run(){

            try{

                sleep(1000 * sleeptimer);
            } catch(InterruptedException e){
                e.printStackTrace();

            }


            Intent intent = new Intent(SplashScreen.this,MainActivity.class);
            startActivity(intent);
            SplashScreen.this.finish();

        }

    }

 

}

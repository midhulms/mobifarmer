package com.example.mobifarmer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {



    private Button farmer;
    private Button customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        farmer = (Button)findViewById(R.id.btnfarmer);
        customer = (Button) findViewById(R.id.btncustomer);

        farmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,farmerlogin.class);
                startActivity(intent);
            }
        });

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this,customerlogin.class);
                startActivity(intent);
            }
        });




    }


    @Override
    public void onBackPressed(){

    }




}

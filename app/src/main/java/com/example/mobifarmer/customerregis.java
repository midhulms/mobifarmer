package com.example.mobifarmer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class customerregis extends AppCompatActivity {


    private EditText etname, etemail, etlocation, etphone, etdate, etpass;
    private Button btnsend, btngets;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerregis);
        setupUIviews();

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    ///uploade the database

                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(customerregis.this, customerlogin.class));
            }
        });


    }


    private void setupUIviews() {

        etname = (EditText) findViewById(R.id.editusername);
        etpass = (EditText) findViewById(R.id.etpass);
        etemail = (EditText) findViewById(R.id.email);
        etlocation = (EditText) findViewById(R.id.location);
        etphone = (EditText) findViewById(R.id.phoneno);
        etdate = (EditText) findViewById(R.id.date);
        btnsend = (Button) findViewById(R.id.btnsend);
        textView = (TextView) findViewById(R.id.login);


    }

    private Boolean validate() {

        Boolean result = false;

        String name = etname.getText().toString();
        String password = etpass.getText().toString();
        String email = etemail.getText().toString();
        String location = etlocation.getText().toString();
        String phone = etphone.getText().toString();
        String date = etdate.getText().toString();


        if (name.isEmpty() && password.isEmpty() && email.isEmpty() && location.isEmpty()&& phone.isEmpty() && date.isEmpty()) {


            Toast.makeText(this, "please enter all the details", Toast.LENGTH_SHORT).show();
        } else {

            result = true;

        }

        return result;

    }

}




package com.example.mobifarmer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class forgetandchangepassword extends AppCompatActivity {


    private Button chanpassw;
    private EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetandchangepassword);

        chanpassw= (Button)findViewById(R.id.btnchanpass);
        email=(EditText)findViewById(R.id.etmail);


         email.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


                 Intent intent =new Intent(forgetandchangepassword.this,MainActivity.class);
                 startActivity(intent);


             }
         });


    }





}

package com.example.mobifarmer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class farmerregis extends AppCompatActivity {


    private EditText etname,etpass, etemail, etlocation, etcrop, etphone, etdate;
    private Button btnsend;
    private TextView textView;
    private FirebaseAuth fireauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmerregis);
        setupUIviews();

        fireauth= FirebaseAuth.getInstance();



        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    ///uploade the database

                    String useremail= etemail.getText().toString().trim();
                    String password= etpass.getText().toString().trim();


                    fireauth.createUserWithEmailAndPassword(useremail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {


                            if(task.isSuccessful()){

                                Toast.makeText(farmerregis.this, "Registeration Succesfull",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(farmerregis.this,farmerlistview.class));

                            }else

                            {

                                Toast.makeText(farmerregis.this, "Registeration failled",Toast.LENGTH_SHORT).show();

                            }



                        }
                    });


                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(farmerregis.this,farmerlogin.class));
            }
        });


    }


    private void setupUIviews(){

        etname = (EditText) findViewById(R.id.editusername);
        etpass= (EditText)findViewById(R.id.etpass);
        etemail = (EditText) findViewById(R.id.email);
        etlocation = (EditText) findViewById(R.id.location);
        etcrop = (EditText) findViewById(R.id.crop);
        etphone = (EditText) findViewById(R.id.phoneno);
        etdate = (EditText) findViewById(R.id.date);
        btnsend = (Button) findViewById(R.id.btnsend);
        textView = (TextView) findViewById(R.id.login);


    }

    private Boolean validate() {

        Boolean result = false;

        String name =etname.getText().toString();
        String password=etpass.getText().toString();
        String email=etemail.getText().toString();
        String location=etlocation.getText().toString();
        String crop=etcrop.getText().toString();
        String phone=etphone.getText().toString();
        String date=etdate.getText().toString();


        if(name.isEmpty() && password.isEmpty() && email.isEmpty() && location.isEmpty() && crop.isEmpty() && phone.isEmpty() && date.isEmpty()) {


            Toast.makeText(this, "please enter all the details", Toast.LENGTH_SHORT).show();
         }
        else {

             result = true;

        }

        return result;

    }





}
package com.example.mobifarmer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class farmerlogin extends AppCompatActivity {


    private EditText name, password;
    private Button login;
    private TextView info, signup;

    private int counter = 5;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmerlogin);


        name = (EditText) findViewById(R.id.etname);
        password = (EditText) findViewById(R.id.etpass);
        login = (Button) findViewById(R.id.btnlogin);
        info = (TextView) findViewById(R.id.tvinfo);
        signup = (TextView) findViewById(R.id.tvsignup);


        info.setText("your attempt is limit ");

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null) {

            finish();
            startActivity(new Intent(farmerlogin.this, farmerlistview.class));


        } else {


        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), password.getText().toString());
                signup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });


                Intent intent = new Intent(farmerlogin.this, farmerregis.class);
                startActivity(intent);


            }
        });


    }

    public void validate(String username, String password) {

        progressDialog.setMessage("you can subscribe");
        progressDialog.show();


        firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override

            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressDialog.dismiss();
                    Toast.makeText(farmerlogin.this, "Login succesfull", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(farmerlogin.this, farmerlistview.class));
                } else {

                    Toast.makeText(farmerlogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    counter--;
                    info.setText("No OF ATTEMPTS REMAINNG: " + counter);
                    progressDialog.dismiss();
                    if (counter == 0) {
                        login.setEnabled(false);
                    }
                }
            }
        });

    }

    /***

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

     ***/
}


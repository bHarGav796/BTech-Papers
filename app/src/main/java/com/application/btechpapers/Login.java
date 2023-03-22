package com.application.btechpapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    EditText mEmail, mPassword ;
    TextView forgetpassword;
    Button mLoginBtn;
    TextView mCreateBtn;
    ProgressBar mProgressbar;


    FirebaseAuth fAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getWindow().setStatusBarColor(ContextCompat.getColor(Login.this, R.color.appcolor));

        getSupportActionBar().hide();

        mEmail = findViewById(R.id.emailid);
        mPassword = findViewById(R.id.password);
        mProgressbar = findViewById(R.id.PBar);
        mLoginBtn = findViewById(R.id.loginBtn);
        mCreateBtn = findViewById(R.id.createtext);
        forgetpassword = findViewById(R.id.forgetpassword);



         fAuth=FirebaseAuth.getInstance();



        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));

            }
        });



        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ForgetPassword.class));

            }
        });



        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 String email=mEmail.getText().toString().trim();
                 String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required");
                    return;
                }

                if (password.length() <5){
                    mPassword.setError("Password must be minimum 5 characters");
                    return;
                }

                mProgressbar.setVisibility(View.VISIBLE);



                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        }

                        else{
                            Toast.makeText(getApplicationContext(),"Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            mProgressbar.setVisibility(View.GONE);
                        }
                    }
                });



            }
        });


    }
}
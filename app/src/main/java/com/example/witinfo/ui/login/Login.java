package com.example.witinfo.ui.login;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.witinfo.MainActivity;
import com.example.witinfo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {
    EditText email;
    EditText password;
    Button loginButton;
    Button forgetPassword;
    Button signUpButton;
    ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();

        //auto login process
        //move to homepage if user already sign in
        if (firebaseAuth.getCurrentUser()!=null){
            //user is logged in
            startActivity(new Intent(Login.this, MainActivity.class));
            finish();
        }

        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        email = findViewById(R.id.edit_username);
        password = findViewById(R.id.edit_password);
        loginButton = findViewById(R.id.button_login);

        forgetPassword = findViewById(R.id.text_forget_password);
        forgetPassword.setPaintFlags(forgetPassword.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        signUpButton = findViewById(R.id.button_signup);
        progressBar = findViewById(R.id.progress_bar);
        firebaseAuth = FirebaseAuth.getInstance();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login.this.startActivity(new Intent(Login.this,SignUp.class));
            }
        });
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login.this.startActivity(new Intent(Login.this,Reset.class));
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String useremail = email.getText().toString().trim();
                final String userpassword = password.getText().toString().trim();

                if (useremail.isEmpty()){
                   email.setError("Email tidak boleh kosong");
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(useremail).matches()){
                    email.setError("Email tidak valid");
                }
                else if (userpassword.isEmpty()){
                    password.setError("Password tidak boleh kosong");
                }
                else if (userpassword.length()<6){
                    password.setError("Password minimal terdiri dari 6 karakter");
                }
                else {
                    progressBar.setVisibility(View.VISIBLE);

                    //login user

                    firebaseAuth.signInWithEmailAndPassword(useremail,userpassword)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);

                                    if (!task.isSuccessful()) {
                                        Toast.makeText(Login.this, "Login failed because of " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    } else {
                                        Login.this.startActivity(new Intent(Login.this, MainActivity.class));
                                        Login.this.finish();
                                    }
                                }
                            });
                }

            }
        });

    }


}



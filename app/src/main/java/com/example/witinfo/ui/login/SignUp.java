package com.example.witinfo.ui.login;

import android.content.Intent;
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

public class SignUp extends AppCompatActivity {
    private EditText email, password;
    private Button signUpButton;
    private ProgressBar progressBar;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();

        initView();
        registerUser();
    }

    private void initView() {
        email = findViewById(R.id.edit_email);
        password = findViewById(R.id.edit_password);
        signUpButton = findViewById(R.id.button_signup);
        progressBar = findViewById(R.id.progress_bar);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void registerUser() {
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = email.getText().toString().trim();
                String userPassword = password.getText().toString().trim();

                //jika email tidak dimasukkan
                if (userEmail.isEmpty()) {
                    email.setError("Email tidak boleh kosong");
                }//jika email not valid
                else if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
                    email.setError("Email tidak valid");
                }//jika password tidak dimasukkan
                else if (userPassword.isEmpty()) {
                    password.setError("Password tidak boleh kosong");
                }//jika password kurang dari 6 karakter
                else if (userPassword.length() < 6) {
                    password.setError("Password minimal terdiri dari 6 karakter");
                } else {
                    firebaseAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                            .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //jika gagal register do something
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(SignUp.this, "Registration failed because of " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    } else {
                                        //jika sukses menuju login
                                        startActivity(new Intent(SignUp.this, Login.class));
                                        progressBar.setVisibility(View.VISIBLE);
                                    }

                                }
                            });

                }
            }
        });
        }

    public void kehomepage(View view) {
        Intent homepage = new Intent(this, MainActivity.class);
        startActivity(homepage);
    }

    public void backLogin(View view) {
        Intent login = new Intent(this,Login.class);
        startActivity(login);
    }
}

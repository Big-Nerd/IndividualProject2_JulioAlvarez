package com.zybooks.individualproject2_julioalvarez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailLogin, passwordLogin;
    private Button loginConfirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailLogin = (EditText) findViewById(R.id.email_login_field);
        passwordLogin = (EditText) findViewById(R.id.password_login);
        loginConfirmBtn = (Button) findViewById(R.id.login_confirmation_btn);

        //Get sharedprefs
        SharedPreferences sp = getApplicationContext().getSharedPreferences("myUserPrefs", Context.MODE_PRIVATE);
        String emailAddress = sp.getString("email", "");
        String passw = sp.getString("password","");


        loginConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get text from fields on click
                String email = emailLogin.getText().toString().trim();
                String password = passwordLogin.getText().toString().trim();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "All fields are required",Toast.LENGTH_LONG).show();
                    return;
                }
                if (email.equals(emailAddress) && password.equals(passw)) {
                    Toast.makeText(LoginActivity.this, "Login Successful",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this, QuizActivity.class));
                    finish();
                }
                if (!(emailAddress.equals(email)) || !(passw.equals(password))) {
                    Toast.makeText(LoginActivity.this,"Incorrect Email or Password",Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }
}
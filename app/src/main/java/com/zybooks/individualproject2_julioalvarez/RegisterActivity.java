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
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText first_name, family_name, dateOfBirth, email, password;
    private Button regConfirmation;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        first_name = (EditText) findViewById(R.id.first_name_field);
        family_name = (EditText) findViewById(R.id.family_name_field);
        dateOfBirth = (EditText) findViewById(R.id.dob_field);
        email = (EditText) findViewById(R.id.email_field);
        password = (EditText) findViewById(R.id.pswd_field);
        regConfirmation = (Button) findViewById(R.id.reg_confirmation_btn);

        sp = getSharedPreferences("myUserPrefs", Context.MODE_PRIVATE);


        regConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = first_name.getText().toString().trim();
                String familyName = family_name.getText().toString().trim();
                String dob = dateOfBirth.getText().toString().trim();
                String emailAddress = email.getText().toString().trim();
                String pswd = password.getText().toString().trim();

                if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(familyName) || TextUtils.isEmpty(dob) || TextUtils.isEmpty(emailAddress) || TextUtils.isEmpty(pswd)) {
                    Toast.makeText(RegisterActivity.this,"All fields are required",Toast.LENGTH_LONG).show();
                    return;
                }
                if (firstName.length() < 3 || firstName.length() > 30) {
                    Toast.makeText(RegisterActivity.this,"Invalid First Name, must be between 3 and 30 chars",Toast.LENGTH_LONG).show();
                    return;
                }
                if (familyName.length() < 3 || familyName.length() > 30) {
                    Toast.makeText(RegisterActivity.this, "Invalid Family Name, must be between 3 and 30 chars",Toast.LENGTH_LONG).show();
                    return;
                }

                String emailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (!emailAddress.matches(emailValidation)) {
                    Toast.makeText(RegisterActivity.this,"Invalid Email Address",Toast.LENGTH_LONG).show();
                    return;
                }

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("firstname", firstName);
                editor.putString("familyname", familyName);
                editor.putString("DOB", dob);
                editor.putString("email", emailAddress);
                editor.putString("password", pswd);
                editor.commit();
                Toast.makeText(RegisterActivity.this, "Registration Successful",Toast.LENGTH_LONG).show();

                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
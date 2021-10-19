package com.zybooks.individualproject2_julioalvarez;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class GameActivity3 extends AppCompatActivity {

    SharedPreferences sp;
    CheckBox cb1, cb2, cb3, cb4;
    Button btn;

    AlertDialog dialog;
    AlertDialog.Builder builder;
    String alertMsg = "Do you wish to move on?";
    String q3ans = "5";
    String cb1text, cb2text, cb3text, cb4text, userPick = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        cb1 = findViewById(R.id.q3cb1);
        cb2 = findViewById(R.id.q3cb2);
        cb3 = findViewById(R.id.q3cb3);
        cb4 = findViewById(R.id.q3cb4);
        btn = findViewById(R.id.q3btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()) {
                    Toast.makeText(GameActivity3.this, "No boxes have been checked",Toast.LENGTH_LONG).show();
                    return;
                }

                builder = new AlertDialog.Builder(GameActivity3.this);
                builder.setTitle(alertMsg);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (cb1.isChecked()) {
                            cb1text = cb1.getText().toString();
                            userPick = cb1text;
                            Toast.makeText(GameActivity3.this, "Incorrect",Toast.LENGTH_LONG).show();
                        }
                        if (cb2.isChecked()) {
                            cb2text = cb2.getText().toString();
                            userPick = cb2text;
                            Toast.makeText(GameActivity3.this, "Incorrect",Toast.LENGTH_LONG).show();
                        }
                        if (cb3.isChecked()) {
                            cb3text = cb3.getText().toString();
                            userPick = cb3text;
                            Toast.makeText(GameActivity3.this, "Correct", Toast.LENGTH_LONG).show();
                        }
                        if (cb4.isChecked()) {
                            cb4text = cb4.getText().toString();
                            userPick = cb4text;
                            Toast.makeText(GameActivity3.this, "Incorrect", Toast.LENGTH_LONG).show();
                        }

                        SharedPreferences.Editor editor = sp.edit();
                        if (q3ans.equals(userPick)) {
                            editor.putString("answer3", q3ans);
                        }
                        else {
                            editor.putString("answer3", "Wrong Answer");
                        }
                        editor.commit();

                        startActivity(new Intent(GameActivity3.this, GameActivity4.class));
                        finish();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                dialog = builder.create();
                dialog.show();
            }
        });
    }
}
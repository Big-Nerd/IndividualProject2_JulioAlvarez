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

public class GameActivity4 extends AppCompatActivity {

    SharedPreferences sp;
    CheckBox cb1, cb2, cb3, cb4;
    Button btn;

    AlertDialog dialog;
    AlertDialog.Builder builder;
    String alertMsg = "Do you wish to move on?";
    String q4ans = "Bitten by radioactive spider";
    String cb1text, cb2text, cb3text, cb4text, userPick = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game4);

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        cb1 = findViewById(R.id.q4cb1);
        cb2 = findViewById(R.id.q4cb2);
        cb3 = findViewById(R.id.q4cb3);
        cb4 = findViewById(R.id.q4cb4);
        btn = findViewById(R.id.q4btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()) {
                    Toast.makeText(GameActivity4.this, "No boxes have been checked",Toast.LENGTH_LONG).show();
                    return;
                }

                builder = new AlertDialog.Builder(GameActivity4.this);
                builder.setTitle(alertMsg);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (cb1.isChecked()) {
                            cb1text = cb1.getText().toString();
                            userPick = cb1text;
                            Toast.makeText(GameActivity4.this, "Incorrect",Toast.LENGTH_LONG).show();
                        }
                        if (cb2.isChecked()) {
                            cb2text = cb2.getText().toString();
                            userPick = cb2text;
                            Toast.makeText(GameActivity4.this, "Correct",Toast.LENGTH_LONG).show();
                        }
                        if (cb3.isChecked()) {
                            cb3text = cb3.getText().toString();
                            userPick = cb3text;
                            Toast.makeText(GameActivity4.this, "Incorrect", Toast.LENGTH_LONG).show();
                        }
                        if (cb4.isChecked()) {
                            cb4text = cb4.getText().toString();
                            userPick = cb4text;
                            Toast.makeText(GameActivity4.this, "Incorrect", Toast.LENGTH_LONG).show();
                        }

                        SharedPreferences.Editor editor = sp.edit();
                        if (q4ans.equals(userPick)) {
                            editor.putString("answer4", q4ans);
                        }
                        else {
                            editor.putString("answer4", "Wrong Answer");
                        }
                        editor.commit();

                        startActivity(new Intent(GameActivity4.this, GameActivity5.class));
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
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

public class GameActivity5 extends AppCompatActivity {

    SharedPreferences sp;
    CheckBox cb1, cb2, cb3, cb4;
    Button btn;

    AlertDialog dialog;
    AlertDialog.Builder builder;
    String alertMsg = "Do you wish to move on?";
    String q5ans = "Red and Yellow";
    String cb1text, cb2text, cb3text, cb4text, userPick = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game5);

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        cb1 = findViewById(R.id.q5cb1);
        cb2 = findViewById(R.id.q5cb2);
        cb3 = findViewById(R.id.q5cb3);
        cb4 = findViewById(R.id.q5cb4);
        btn = findViewById(R.id.q5btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()) {
                    Toast.makeText(GameActivity5.this, "No boxes have been checked",Toast.LENGTH_LONG).show();
                    return;
                }

                builder = new AlertDialog.Builder(GameActivity5.this);
                builder.setTitle(alertMsg);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (cb1.isChecked()) {
                            cb1text = cb1.getText().toString();
                            userPick = cb1text;
                            Toast.makeText(GameActivity5.this, "Incorrect",Toast.LENGTH_LONG).show();
                        }
                        if (cb2.isChecked()) {
                            cb2text = cb2.getText().toString();
                            userPick = cb2text;
                            Toast.makeText(GameActivity5.this, "Incorrect",Toast.LENGTH_LONG).show();
                        }
                        if (cb3.isChecked()) {
                            cb3text = cb3.getText().toString();
                            userPick = cb3text;
                            Toast.makeText(GameActivity5.this, "Correct", Toast.LENGTH_LONG).show();
                        }
                        if (cb4.isChecked()) {
                            cb4text = cb4.getText().toString();
                            userPick = cb4text;
                            Toast.makeText(GameActivity5.this, "Incorrect", Toast.LENGTH_LONG).show();
                        }

                        SharedPreferences.Editor editor = sp.edit();
                        if (q5ans.equals(userPick)) {
                            editor.putString("answer5", q5ans);
                        }
                        else {
                            editor.putString("answer5", "Wrong Answer");
                        }
                        editor.commit();

                        startActivity(new Intent(GameActivity5.this, LastActivity.class));
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
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

public class GameActivity2 extends AppCompatActivity {

    SharedPreferences sp;
    CheckBox cb1, cb2, cb3, cb4;
    Button btn;

    AlertDialog dialog;
    AlertDialog.Builder builder;
    String alertMsg = "Do you wish to move on?";
    String q2ans1 = "Yankees", q2ans2 = "Red Sox";
    String cb1text, cb2text, cb3text, cb4text, userPick, userPick2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        cb1 = findViewById(R.id.q2cb1);
        cb2 = findViewById(R.id.q2cb2);
        cb3 = findViewById(R.id.q2cb3);
        cb4 = findViewById(R.id.q2cb4);
        btn = findViewById(R.id.q2btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked() && !cb4.isChecked()) {
                    Toast.makeText(GameActivity2.this, "No boxes have been checked",Toast.LENGTH_LONG).show();
                    return;
                }

                builder = new AlertDialog.Builder(GameActivity2.this);
                builder.setTitle(alertMsg);

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (cb1.isChecked() && cb3.isChecked()) {
                            cb1text = cb1.getText().toString();
                            cb3text = cb3.getText().toString();
                            userPick = cb1text;
                            userPick2 = cb3text;
                            Toast.makeText(GameActivity2.this, "Correct",Toast.LENGTH_LONG).show();
                        }
                        if (cb2.isChecked() || cb4.isChecked()) {
                            cb2text = cb2.getText().toString();
                            cb4text = cb4.getText().toString();
                            Toast.makeText(GameActivity2.this, "Incorrect",Toast.LENGTH_LONG).show();
                        }

                        SharedPreferences.Editor editor = sp.edit();
                        if (q2ans1.equals(userPick) && q2ans2.equals(userPick2)) {
                            editor.putString("question2ans1", q2ans1);
                            editor.putString("question2ans2", q2ans2);
                        }
                        else {
                            editor.putString("answer2", "Wrong Answer");
                        }
                        editor.commit();

                        startActivity(new Intent(GameActivity2.this, GameActivity3.class));
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
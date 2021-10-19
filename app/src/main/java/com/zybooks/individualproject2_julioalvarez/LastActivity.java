package com.zybooks.individualproject2_julioalvarez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LastActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5;
    Button btn;
    String ans1text, ans2text, ans3text, ans4text, ans5text;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        tv1.findViewById(R.id.tv1res1);
        tv2.findViewById(R.id.tv2res1);
        tv3.findViewById(R.id.tv3res1);
        tv4.findViewById(R.id.tv4res1);
        tv5.findViewById(R.id.tv5res1);
        btn.findViewById(R.id.lastbtn);

        sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        ans1text = sp.getString("answer1", "");
        ans2text = sp.getString("question2ans1", "");
        ans3text = sp.getString("answer3", "");
        ans4text = sp.getString("answer4", "");
        ans5text = sp.getString("answer5", "");

        tv1.setText(ans1text);
        tv2.setText(ans2text);
        tv3.setText(ans3text);
        tv4.setText(ans4text);
        tv5.setText(ans5text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
    }
}
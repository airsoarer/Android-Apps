package com.example.matt.mrtap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirtyFinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirty_final);

        Button finalActivity = (Button)findViewById(R.id.final_activity);
        TextView highScoreView = (TextView)findViewById(R.id.high_score);

        // Get intent and show score
        Intent intent = getIntent();

        String score = intent.getStringExtra("EXTRA_MESSAGE");
        TextView scoreView = (TextView)findViewById(R.id.final_score_view);
        scoreView.setText(score);

        // High score stuff
        SharedPreferences sharedPreferences = getSharedPreferences("THIRTY", Context.MODE_PRIVATE);
        int highScore = sharedPreferences.getInt("HIGH_SCORE", 0);

        if((Integer.parseInt(score)) > highScore){
            highScoreView.setText(score);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("HIGH_SCORE", Integer.parseInt(score));
            editor.apply();
        }else if((Integer.parseInt(score)) <= highScore){
            highScoreView.setText(Integer.toString(highScore));
        }

        finalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThirtyFinalActivity.this, HomeActivity.class));
            }
        });
    }
}

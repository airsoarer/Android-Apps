package com.example.matt.mrtap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Get Button and high score references
        Button ten = (Button)findViewById(R.id.ten);
        Button thirty = (Button)findViewById(R.id.thrity);
        Button minute = (Button)findViewById(R.id.minute);


        TextView tenTextView = (TextView)findViewById(R.id.ten_second_high_score_view);
        TextView thirtyTextView = (TextView)findViewById(R.id.thirty_second_high_score_view);
        TextView minuteTextView = (TextView)findViewById(R.id.minute_high_score_view);


        // High Score Stuff
        SharedPreferences tenPreferences = getSharedPreferences("TEN", Context.MODE_PRIVATE);
        int tenScore = tenPreferences.getInt("SCORE", 0);
        String tenTxt = Integer.toString(tenScore);

        tenTextView.setText("High Score: " + tenTxt);

        SharedPreferences thirtyPreferences = getSharedPreferences("THIRTY", Context.MODE_PRIVATE);
        int thirtyScore = thirtyPreferences.getInt("HIGH_SCORE", 0);
        String thirtyTxt = Integer.toString(thirtyScore);

        thirtyTextView.setText("High Score: " + thirtyTxt);

        SharedPreferences minutePreferences = getSharedPreferences("MINUTE", Context.MODE_PRIVATE);
        int minuteScore = minutePreferences.getInt("SCORE", 0);
        String minuteTxt = Integer.toString(minuteScore);

        minuteTextView.setText("High Score: " + minuteTxt);


        // Check when buttons are clicked and send to appropriate page
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MainActivity.class));
            }
        });

        thirty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, ThirtyActivity.class));
            }
        });

        minute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, MinuteActivity.class));
            }
        });

    }
}

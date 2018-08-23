package com.example.matt.mrtap;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MinuteActivity extends AppCompatActivity {
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minute);

        final Button tapButton = (Button)findViewById(R.id.tap);
        final TextView timerTextView = (TextView)findViewById(R.id.timer_view);
        final TextView scoreView = (TextView)findViewById(R.id.score_view);

        CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                String time = Long.toString(l/1000);

                if((Integer.parseInt(time)) <= 10){
                    timerTextView.setTextColor(getResources().getColor(R.color.orange));
                }

                if((Integer.parseInt(time)) <= 5){
                    timerTextView.setTextColor(getResources().getColor(R.color.red));
                }

                timerTextView.setText(time);

                tapButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Increase count
                        count = count + 1;

                        // Make count a string
                        String txtCount = Integer.toString(count);

                        // Change number view text
                        scoreView.setText(txtCount);
                    }
                });
            }

            @Override
            public void onFinish() {
                String score = scoreView.getText().toString();
                Intent intent = new Intent(MinuteActivity.this, MinuteFinalActivity.class);
                intent.putExtra("EXTRA_MESSAGE", score);
                startActivity(intent);
            }
        }.start();
    }
}

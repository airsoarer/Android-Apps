package com.example.matt.mrtap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {
    // set count variable
    private int count = 0;
    // Set text view variable
    TextView numberTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button tapButton = (Button)findViewById(R.id.tap);
        final TextView timerTextView = (TextView)findViewById(R.id.timer_view);
        final TextView scoreView = (TextView)findViewById(R.id.score_view);

        CountDownTimer countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                String time = Long.toString(l/1000);

                if((Integer.parseInt(time)) <= 5){
                    timerTextView.setTextColor(getResources().getColor(R.color.orange));
                }

                if((Integer.parseInt(time)) <= 3){
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
                Intent intent = new Intent(MainActivity.this, FinalActivity.class);
                intent.putExtra("EXTRA_MESSAGE", score);
                startActivity(intent);
            }
        }.start();
    }

    public void restart(View view){
        // Get number view
        numberTextview = (TextView)findViewById(R.id.timer_view);

        // Set count to 0
        count = 0;

        // Make count a string
        String txtCount = Integer.toString(count);

        //Change number view text
        numberTextview.setText(txtCount);
    }
}

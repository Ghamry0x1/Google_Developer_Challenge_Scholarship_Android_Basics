package com.example.ghamry.taekwondoscorekeeper;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    public Button b1;
    public Button b2;
    public Button b3;
    public Button b4;
    public Button b5;

    public Button r1;
    public Button r2;
    public Button r3;
    public Button r4;
    public Button r5;

    public Button resetBtn;
    public Button startBtn;

    public TextView player1ScoreTxt;
    public TextView player2ScoreTxt;
    public TextView timerTxt;
    public TextView roundTxt;

    int player1Score;
    int player2Score;
    int round = 1;
    int timer = 90;
    boolean timerProcessing = false;
    boolean timerStarts = false;
    CountDownTimer t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.btnPlusOneBlue);
        b2 = (Button) findViewById(R.id.btnPlusTwoBlue);
        b3 = (Button) findViewById(R.id.btnPlusThreeBlue);
        b4 = (Button) findViewById(R.id.btnPlusFourBlue);
        b5 = (Button) findViewById(R.id.btnFoulBlue);

        r1 = (Button) findViewById(R.id.btnPlusOneRed);
        r2 = (Button) findViewById(R.id.btnPlusTwoRed);
        r3 = (Button) findViewById(R.id.btnPlusThreeRed);
        r4 = (Button) findViewById(R.id.btnPlusFourRed);
        r5 = (Button) findViewById(R.id.btnFoulRed);

        resetBtn = (Button) findViewById(R.id.btnReset);
        startBtn = (Button) findViewById(R.id.btnStart);

        player1ScoreTxt = (TextView) findViewById(R.id.player1Score);
        player2ScoreTxt = (TextView) findViewById(R.id.player2Score);
        roundTxt = (TextView) findViewById(R.id.roundCounter);
        timerTxt = (TextView) findViewById(R.id.timer);

        t = new CountDownTimer(90000, 1) {
            public void onTick(long millisUntilFinished) {
                timerTxt.setText(millisUntilFinished/1000+"s");
            }
            public void onFinish() {
                timerTxt.setText("done");
                timerProcessing = false;
                round++;
                roundTxt.setText("ROUND\n"+String.valueOf(round));
            }
        };

        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!timerStarts){
                    t.start();
                    timerStarts = true;
                    timerProcessing = true;
                }
                if (timerProcessing){
                    timer--;
                    timerTxt.setText(String.valueOf(timer));
                }
            }
        });
    }

    public void blueBtnClicked(View view) {
        if (b1.isPressed()) {
            player1Score++;
            player1ScoreTxt.setText(String.valueOf(player1Score));
        }
        if (b2.isPressed()) {
            player1Score += 2;
            player1ScoreTxt.setText(String.valueOf(player1Score));
        }
        if (b3.isPressed()) {
            player1Score += 3;
            player1ScoreTxt.setText(String.valueOf(player1Score));
        }
        if (b4.isPressed()) {
            player1Score += 4;
            player1ScoreTxt.setText(String.valueOf(player1Score));
        }
        if (b5.isPressed()) {
            player2Score++;
            player2ScoreTxt.setText(String.valueOf(player2Score));
        }
    }

    public void redBtnClicked(View view) {
        if (r1.isPressed()) {
            player2Score++;
            player2ScoreTxt.setText(String.valueOf(player2Score));
        }
        if (r2.isPressed()) {
            player2Score += 2;
            player2ScoreTxt.setText(String.valueOf(player2Score));
        }
        if (r3.isPressed()) {
            player2Score += 3;
            player2ScoreTxt.setText(String.valueOf(player2Score));
        }
        if (r4.isPressed()) {
            player2Score += 4;
            player2ScoreTxt.setText(String.valueOf(player2Score));
        }
        if (r5.isPressed()) {
            player1Score++;
            player1ScoreTxt.setText(String.valueOf(player1Score));
        }
    }

    public void resetBtnClicked(View view) {
        t.cancel();
        player1Score = 0;
        player2Score = 0;
        round = 1;
        timer = 90;
        timerStarts = false;
        timerProcessing = false;
        player1ScoreTxt.setText(String.valueOf(player1Score));
        player2ScoreTxt.setText(String.valueOf(player2Score));
        roundTxt.setText("ROUND\n" + String.valueOf(round));
        timerTxt.setText(String.valueOf(timer) + "s");
    }

}

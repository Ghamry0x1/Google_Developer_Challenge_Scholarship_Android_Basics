package com.example.ghamry.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText name;

    public RadioButton q1a;
    public RadioButton q1b;
    public RadioButton q1c;
    public RadioButton q1d;

    public RadioButton q2a;
    public RadioButton q2b;
    public RadioButton q2c;
    public RadioButton q2d;

    public RadioButton q3a;
    public RadioButton q3b;
    public RadioButton q3c;
    public RadioButton q3d;

    public RadioButton q4a;
    public RadioButton q4b;
    public RadioButton q4c;
    public RadioButton q4d;

    public RadioButton q5a;
    public RadioButton q5b;
    public RadioButton q5c;
    public RadioButton q5d;

    public CheckBox q6a;
    public CheckBox q6b;
    public CheckBox q6c;
    public CheckBox q6d;

    public Button submitBtn;
    public TextView scoreView;
    public int score = 0;
    public int submitCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);

        q1a = (RadioButton) findViewById(R.id.q1a);
        q1b = (RadioButton) findViewById(R.id.q1b);
        q1c = (RadioButton) findViewById(R.id.q1c);
        q1d = (RadioButton) findViewById(R.id.q1d);

        q2a = (RadioButton) findViewById(R.id.q2a);
        q2b = (RadioButton) findViewById(R.id.q2b);
        q2c = (RadioButton) findViewById(R.id.q2c);
        q2d = (RadioButton) findViewById(R.id.q2d);

        q3a = (RadioButton) findViewById(R.id.q3a);
        q3b = (RadioButton) findViewById(R.id.q3b);
        q3c = (RadioButton) findViewById(R.id.q3c);
        q3d = (RadioButton) findViewById(R.id.q3d);

        q4a = (RadioButton) findViewById(R.id.q4a);
        q4b = (RadioButton) findViewById(R.id.q4b);
        q4c = (RadioButton) findViewById(R.id.q4c);
        q4d = (RadioButton) findViewById(R.id.q4d);

        q5a = (RadioButton) findViewById(R.id.q5a);
        q5b = (RadioButton) findViewById(R.id.q5b);
        q5c = (RadioButton) findViewById(R.id.q5c);
        q5d = (RadioButton) findViewById(R.id.q5d);

        q6a = (CheckBox) findViewById(R.id.q6a);
        q6b = (CheckBox) findViewById(R.id.q6b);
        q6c = (CheckBox) findViewById(R.id.q6c);
        q6d = (CheckBox) findViewById(R.id.q6d);

        submitBtn = (Button) findViewById(R.id.submitBtn);
        scoreView = (TextView) findViewById(R.id.scoreView);
    }

    public void submit(View view) {
        calculateScore();
        if (submitCounter == 1) {
            scoreView.setVisibility(View.VISIBLE);
            scoreView.setText("Score: " + score + "/6");
            submitCounter = 0;
        }
    }

    public void calculateScore() {
        if(score == 0) {
            submitCounter = 1;
            if (q1b.isChecked())
                score++;
            if (q2a.isChecked())
                score++;
            if (q3a.isChecked())
                score++;
            if (q4a.isChecked())
                score++;
            if (q5b.isChecked())
                score++;
            if (q6c.isChecked() && !q6a.isChecked() && !q6b.isChecked() && !q6d.isChecked())
                score++;
        }
    }

    public void reset(View view) {
        submitCounter = 0;
        score = 0;
        scoreView.setVisibility(View.INVISIBLE);

        name.setText("");
        q1a.setChecked(false);
        q1b.setChecked(false);
        q1c.setChecked(false);
        q1d.setChecked(false);

        q2a.setChecked(false);
        q2b.setChecked(false);
        q2c.setChecked(false);
        q2d.setChecked(false);

        q3a.setChecked(false);
        q3b.setChecked(false);
        q3c.setChecked(false);
        q3d.setChecked(false);

        q4a.setChecked(false);
        q4b.setChecked(false);
        q4c.setChecked(false);
        q4d.setChecked(false);

        q5a.setChecked(false);
        q5b.setChecked(false);
        q5c.setChecked(false);
        q5d.setChecked(false);

        q6a.setChecked(false);
        q6b.setChecked(false);
        q6c.setChecked(false);
        q6d.setChecked(false);

    }
}

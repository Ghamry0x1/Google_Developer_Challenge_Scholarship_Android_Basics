package com.example.ghamry.userprofile;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView name = (TextView) findViewById(R.id.name);
        TextView birthday = (TextView) findViewById(R.id.birthday);
        TextView country = (TextView) findViewById(R.id.country);
        ImageView profile_picture = (ImageView) findViewById(R.id.profile_picture);

        profile_picture.setImageResource(R.drawable.profilepic);

        name.setText("Mohamed El Ghamry");
        name.setTypeface(null, Typeface.BOLD);
        name.setTextSize(30);
        name.setTextColor(Color.BLACK);

        birthday.setText("January 29, 1997");
        birthday.setTextSize(24);
        birthday.setTextColor(Color.BLACK);

        country.setText("Egypt");
        country.setTextSize(24);
        country.setTextColor(Color.BLACK);
    }
}

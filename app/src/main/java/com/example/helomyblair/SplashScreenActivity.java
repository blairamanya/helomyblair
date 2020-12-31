package com.example.helomyblair;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        textview = findViewById(R.id.first);


            //sleep for 1 seconds
            Thread background = new Thread() {
                public void run() {
                    try {
                        sleep(2000);
                        Intent ss = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(ss);
                        finish();
                    } catch (Exception e) {

                    }
                }

            };background.start();
        }
    }





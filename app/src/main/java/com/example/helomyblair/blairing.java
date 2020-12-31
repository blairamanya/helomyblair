package com.example.helomyblair;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

public class blairing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blairing);

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.ali);
        mediaPlayer.start();
    }
}

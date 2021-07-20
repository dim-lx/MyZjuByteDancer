package com.example.mediaworksdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Pic = findViewById(R.id.btn_pic);
        Button Video = findViewById(R.id.btn_video);

        Pic.setOnClickListener(v -> {
            Intent intent = new Intent(this, PictureDetailActivity.class);
            startActivity(intent);
        });

        Video.setOnClickListener(v -> {
            Intent intent = new Intent(this, VideoDetailActivity.class);
            startActivity(intent);
        });
    }
}
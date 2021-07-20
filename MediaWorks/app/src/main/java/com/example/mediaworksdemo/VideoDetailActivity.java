package com.example.mediaworksdemo;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VideoDetailActivity extends AppCompatActivity {

    String videoUrl =
            "https://media.w3.org/2010/05/sintel/trailer.mp4";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);

        VideoView videoView = findViewById(R.id.vv);
        videoView.setVideoURI(Uri.parse(videoUrl));
        videoView.setMediaController(new MediaController(this));
        videoView.start();
    }
}

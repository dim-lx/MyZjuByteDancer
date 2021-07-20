package com.example.mediaworksdemo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class PictureDetailActivity extends AppCompatActivity {

    String imgUrl1 =
            "https://c-ssl.duitang.com/uploads/item/201804/13/20180413105358_k58WZ.gif";
    String ErrorUrl =
            "https://upload.wikimedia.org";
    String imgUrl2 =
            "https://images.unsplash.com/photo-1564832586408-3b10f4f41541?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=2980&q=80";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);

        ImageView imageView = findViewById(R.id.iv_detail);
        Button Success = findViewById(R.id.btn_load_success);
        Button Fail = findViewById(R.id.btn_load_fail);
        Button RoundedCorners = findViewById(R.id.btn_rounded_corners);
        Button Fade = findViewById(R.id.btn_fade);

        Success.setOnClickListener( v -> {
            Glide.with(this)
                    .load(imgUrl1)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .into(imageView);
        });

        Fail.setOnClickListener( v -> {
            Glide.with(this).
                    load(ErrorUrl).placeholder(R.drawable.loading).error(R.drawable.error).into(imageView); });

        RoundedCorners.setOnClickListener( v-> {
            DrawableCrossFadeFactory drawableCrossFadeFactory =
                    new DrawableCrossFadeFactory.Builder(300).setCrossFadeEnabled(true).build();

            Glide.with(this).load(imgUrl1)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(60)))
                    .transition(DrawableTransitionOptions.with(drawableCrossFadeFactory))
                    .into(imageView);
        });

        Fade.setOnClickListener( v -> {
            Glide.with(this)
                    .load(imgUrl2)
                    .placeholder(R.drawable.loading)
                    .error(R.drawable.error)
                    .transition(withCrossFade(1000))
                    .into(imageView);
        });
    }
}

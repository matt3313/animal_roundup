package com.ourideas.android.animalroundup;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.ourideas.android.animalroundup.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private MediaPlayer animalSound;

    ImageView imageView;

    Random r;

    Integer[] images = {

            R.drawable.donkey,
            R.drawable.hyena,
            R.drawable.lion,

    };

    int currentImage = 0, lastImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalSound = MediaPlayer.create(this, R.raw.hyena);
        animalSound.start();

        imageView = (ImageView) findViewById(R.id.imageView);

        r = new Random();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                do {
                    currentImage = r.nextInt(images.length);


                } while (currentImage == lastImage);

                lastImage = currentImage;
                imageView.setImageResource(images[currentImage]);
            }

        });
    }
}

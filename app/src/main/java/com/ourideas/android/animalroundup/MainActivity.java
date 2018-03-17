package com.example.android.animalapp;

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
            R.drawable.armadillo,
            R.drawable.bat,
            R.drawable.cat,
            R.drawable.chimp,
            R.drawable.cow,
            R.drawable.donkey,
            R.drawable.duck,
            R.drawable.elephant,
            R.drawable.flamingo,
            R.drawable.fox,
            R.drawable.frog,
            R.drawable.goose,
            R.drawable.gorilla,
            R.drawable.hippo,
            R.drawable.horse,
            R.drawable.hyena,
            R.drawable.impala,
            R.drawable.lemur,
            R.drawable.lion,
            R.drawable.lizard,
            R.drawable.orca,
            R.drawable.ostrich,
            R.drawable.panda,
            R.drawable.parrot,
            R.drawable.peacock,
            R.drawable.penguin,
            R.drawable.pig,
            R.drawable.platypus,
            R.drawable.puffin,
            R.drawable.seal,
            R.drawable.sloth,
            R.drawable.walrus,
            R.drawable.warthog,
            R.drawable.zebra
    };

    int currentImage = 0, lastImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalSound = MediaPlayer.create(this, R.raw.bear2);
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

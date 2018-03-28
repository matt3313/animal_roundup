package com.ourideas.android.animalroundup;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer animalSound;
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer animalSound) {
            animalSound.release();
        }
    };

    ImageView imageView;

    Random r;

    Integer[] images = {R.drawable.cow, R.drawable.hyena, R.drawable.lion, R.drawable.chimp,
            R.drawable.elephant, R.drawable.fox, R.drawable.hippo, R.drawable.peacock,
            R.drawable.pig, R.drawable.warthog};

    Integer[] sounds = {R.raw.cow, R.raw.hyena, R.raw.lion, R.raw.monkey, R.raw.elephant,
            R.raw.fox, R.raw.hippo, R.raw.peacock, R.raw.pig, R.raw.hog};

    int i = 0, lastImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalSound = MediaPlayer.create(this, R.raw.elephant);
        animalSound.start();
        animalSound.setOnCompletionListener(completionListener);

        imageView = findViewById(R.id.imageView);

        r = new Random();



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animalSound.release();

                do {
                    i = r.nextInt(images.length);

                } while (i == lastImage);

                lastImage = i;
                imageView.setImageResource(images[i]);

                animalSound = MediaPlayer.create(MainActivity.this, sounds[i]);
                animalSound.start();
                animalSound.setOnCompletionListener(completionListener);
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        animalSound.release();
    }
}

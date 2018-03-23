package com.ourideas.android.animalroundup;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //final MediaPlayer animalsound = MediaPlayer.create(this, sounds[i]);
   // private MediaPlayer animalSound;

    ImageView imageView;

    Random r;

    Integer[] images = {R.drawable.cow, R.drawable.hyena, R.drawable.lion, R.drawable.chimp,
            R.drawable.elephant, R.drawable.fox, R.drawable.hippo, R.drawable.peacock,
            R.drawable.pig, R.drawable.warthog};

    Integer[] sounds = {R.raw.cow, R.raw.hyena, R.raw.lion, R.raw.monkey, R.raw.elephant,
            R.raw.fox, R.raw.hippo, R.raw.peacock, R.raw.pig, R.raw.hog};

    //int currentImage = 0, lastImage = 0;      not used currently

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        r = new Random();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                int i = r.nextInt(images.length);


                imageView.setImageResource(images[i]);


                final MediaPlayer animalSound = MediaPlayer.create(MainActivity.this, sounds[i]);

                animalSound.start();

                /* does not work with current code
                do {
                    currentImage = r.nextInt(images.length);


                } while (currentImage == lastImage);

                lastImage = currentImage;
                imageView.setImageResource(images[currentImage]);
                */
            }

        });
    }
}

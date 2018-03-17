package com.ourideas.android.animalroundup;

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

    Integer[] images = {

            R.drawable.donkey,
            R.drawable.hyena,
            R.drawable.lion,

    };

    Integer[] sounds = {

            R.raw.monkey,
            R.raw.hyena,
            R.raw.lion
    };

    int currentImage = 0, lastImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     /*  Temporarily commented out to created media player in another spot.

        animalSound = MediaPlayer.create(this, R.raw.hyena);
        animalSound.start();
     */
        imageView = (ImageView) findViewById(R.id.imageView);

        r = new Random();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int i=r.nextInt(images.length);


                imageView.setImageResource(images[i]);

               /* doesnt work
                final MediaPlayer animalSound = MediaPlayer.create(this, sounds[i]);

                animalSound.start();
                */









               /*  temporarily commented out dur to redundency
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

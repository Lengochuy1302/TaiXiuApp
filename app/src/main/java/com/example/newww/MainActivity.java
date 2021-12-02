package com.example.newww;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 4000;



    //Vari
    Animation topAnim,bottomAnim;
    ImageView imageView2;
    TextView textView,textView2;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Animations
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        //
        imageView2 = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);

        imageView2.setAnimation(topAnim);
        textView.setAnimation(bottomAnim);
        textView2.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,ThemeLogin.class);



                    Pair[] pairs = new Pair[2];
                    pairs[0] = new Pair<View,String>(imageView2,"logo_image");
                    pairs[1] = new Pair<View,String>(textView,"logo_text");




                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                    startActivity(intent,options.toBundle());
                }


            }
        },SPLASH_SCREEN);


    }
}
package com.example.newww;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newww.ImageViewScrolling.IEventEnd;
import com.example.newww.ImageViewScrolling.ImageViewScrolling;

import java.util.Random;

public class JackPot extends AppCompatActivity implements IEventEnd {

    ImageView btn_up,btn_down;
    ImageViewScrolling image, image2,image3;
    TextView txt_score;

    int count_done=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jackpot);



        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        btn_down = (ImageView) findViewById(R.id.btn_down);
        btn_up = (ImageView) findViewById(R.id.btn_up);

        image = (ImageViewScrolling)findViewById(R.id.image);
        image2 = (ImageViewScrolling)findViewById(R.id.image2);
        image3 = (ImageViewScrolling)findViewById(R.id.image3);

        txt_score = (TextView)findViewById(R.id.txt_score);


        image.setEventEnd(JackPot.this);
        image2.setEventEnd(JackPot.this);
        image3.setEventEnd(JackPot.this);



        btn_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MoneyMoney.SCORE >= 50) {
                    btn_up.setVisibility(View.GONE);
                    btn_down.setVisibility(View.VISIBLE);

                    image.setValueRandom(new Random().nextInt(6), new Random().nextInt((15 - 5) + 1) + 5);
                    image2.setValueRandom(new Random().nextInt(6), new Random().nextInt((15 - 5) + 1) + 5);
                    image3.setValueRandom(new Random().nextInt(6), new Random().nextInt((15 - 5) + 1) + 5);

                    MoneyMoney.SCORE -= 50;
                    txt_score.setText(String.valueOf(MoneyMoney.SCORE));

                } else {
                    Toast.makeText(JackPot.this, "Bna khong du tien", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }


    @Override
    public void eventEnd(int result, int count) {
        if(count_done<2) //
            count_done++;
        else {
            btn_down.setVisibility(View.GONE);
            btn_up.setVisibility(View.VISIBLE);

            count_done = 0;

            if (image.getValue()==image2.getValue()&&image2.getValue()==image3.getValue()){
                Toast.makeText(this,"Woa thagn r ",Toast.LENGTH_SHORT);
                MoneyMoney.SCORE+=300;
                txt_score.setText(String.valueOf(MoneyMoney.SCORE));

            }
            else if(image.getValue()==image2.getValue()||image2.getValue()==image3.getValue()||image.getValue()==image3.getValue()){
                Toast.makeText(this,"May thang ",Toast.LENGTH_SHORT);
                MoneyMoney.SCORE +=100;
                txt_score.setText(String.valueOf(MoneyMoney.SCORE));


            }else{
                Toast.makeText(this,"May thua ",Toast.LENGTH_SHORT);
            }


        }
    }
}
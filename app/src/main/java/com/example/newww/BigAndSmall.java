package com.example.newww;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class BigAndSmall extends AppCompatActivity {
    MoneyMoney mo = new MoneyMoney();
    ImageView xs1, xs2, xs3, khuikhui;
    TextView moneyy, txttai, txtxiu;
    EditText betbig, betsmall;
    AnimationDrawable cdXingau1, cdXingau2, cdXingau3;
//   final Animation khuikhui_animation = AnimationUtils.loadAnimation(this,R.anim.khuikhui_animation);
    Animation topAnim,bottomAnim,khuikhuiAnim;
    Timer timer = new Timer();
    Handler handler;
    int value1, value2, value3;
    DecimalFormat formatmoney = new DecimalFormat("###,###,###");


    Handler.Callback callback = new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            Randomxs1();
            Randomxs2();
            Randomxs3();
            resultbig();
//            mp.start();
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_big_and_small);
        khuikhui = findViewById(R.id.khuikhui);
        moneyy = findViewById(R.id.moneyy);
        moneyy.setText(mo.tien+"VND");
        xs1 = findViewById(R.id.xs1);
        xs2 = findViewById(R.id.xs2);
        xs3 = findViewById(R.id.xs3);
        betbig = findViewById(R.id.betbig);
        betsmall = findViewById(R.id.betsmall);
        txttai = findViewById(R.id.txttai);
        txtxiu = findViewById(R.id.txtxiu);
        handler = new Handler(callback);

        betbig.setEnabled(false);
        betsmall.setEnabled(false);
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        khuikhuiAnim = AnimationUtils.loadAnimation(this,R.anim.khuikhui_animation);
        resultbig();

        txttai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                betsmall.setEnabled(false);
                betbig.setEnabled(true);
                betbig.setText("");


            }
        });

        txtxiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                betbig.setEnabled(false);
                betsmall.setEnabled(true);
                betsmall.setText("");

            }
        });

        moneyy.setText(mo.tien+"VND");


    }

    public void lacxs(View v) {
        xs1.setImageResource(R.drawable.xs_animation);
        xs2.setImageResource(R.drawable.xs_animation);
        xs3.setImageResource(R.drawable.xs_animation);



        cdXingau1 = (AnimationDrawable) xs1.getDrawable();
        cdXingau2 = (AnimationDrawable) xs2.getDrawable();
        cdXingau3 = (AnimationDrawable) xs3.getDrawable();

        cdXingau1.start();
        cdXingau2.start();
        cdXingau3.start();


        timer.schedule(new timerlacxs(), 3000);

        Pair[] pairs = new Pair[2];
        pairs[0] = new Pair<View,String>(khuikhui,"logo_image");
        pairs[1] = new Pair<View,String>(khuikhui,"logo_text");

        v.startAnimation(khuikhuiAnim);


    }

    class timerlacxs extends TimerTask {
        public void run() {
            handler.sendEmptyMessage(0);

        }
    }


    private void Randomxs1() {
        Random rnd = new Random();
        int n = rnd.nextInt(6);
        if ((n == 0)) {
            value1 = 1;
            xs1.setImageResource(R.drawable.mot);
        } else if (n == 1) {
            value1 = 2;
            xs1.setImageResource(R.drawable.hai);
        } else if (n == 2) {
            value1 = 3;
            xs1.setImageResource(R.drawable.ba);
        } else if (n == 3) {
            value1 = 4;
            xs1.setImageResource(R.drawable.bon);
        } else if (n == 4) {
            value1 = 5;
            xs1.setImageResource(R.drawable.nam);
        } else if (n == 5) {
            value1 = 6;
            xs1.setImageResource(R.drawable.sau);
        } else {

        }


    }


    private void Randomxs2() {
        Random rnd = new Random();
        int n = rnd.nextInt(6);
        if ((n == 0)) {
            value2 = 1;
            xs2.setImageResource(R.drawable.mot);
        } else if (n == 1) {
            value2 = 2;
            xs2.setImageResource(R.drawable.hai);
        } else if (n == 2) {
            value2 = 3;
            xs2.setImageResource(R.drawable.ba);
        } else if (n == 3) {
            value2 = 4;
            xs2.setImageResource(R.drawable.bon);
        } else if (n == 4) {
            value2 = 5;
            xs2.setImageResource(R.drawable.nam);
        } else if (n == 5) {
            value2 = 6;
            xs2.setImageResource(R.drawable.sau);
        } else {

        }


    }

    private void Randomxs3() {
        Random rnd = new Random();
        int n = rnd.nextInt(6);
        if ((n == 0)) {
            value3 = 1;
            xs3.setImageResource(R.drawable.mot);
        } else if (n == 1) {
            value3 = 2;
            xs3.setImageResource(R.drawable.hai);
        } else if (n == 2) {
            value3 = 3;
            xs3.setImageResource(R.drawable.ba);
        } else if (n == 3) {
            value3 = 4;
            xs3.setImageResource(R.drawable.bon);
        } else if (n == 4) {
            value3 = 5;
            xs3.setImageResource(R.drawable.nam);
        } else if (n == 5) {
            value3 = 6;
            xs3.setImageResource(R.drawable.sau);
        } else {

        }


    }


    public void datcuoctai() {
        DecimalFormat formatmoney = new DecimalFormat("###,###,###");
        String big = betbig.getText().toString().trim();
        int giatribig = new Integer(big).intValue();
        mo.SCORE =  mo.SCORE + giatribig;
        String tien = String.valueOf(formatmoney.format(mo.SCORE));
        moneyy.setText( tien + " Vnd");

    }
    private void datcuocxiu() {
        DecimalFormat formatmoney = new DecimalFormat("###,###,###");
        String big = betbig.getText().toString();
        int giatrixiu = new Integer(big).intValue();
        mo.SCORE =  mo.SCORE - giatrixiu;
        String tien = String.valueOf(formatmoney.format(mo.SCORE));
        moneyy.setText(tien + " Vnd");

    }

    public void resultbig() {
        int sum = value1 + value2 + value3;
        if (sum >= 11) {
           datcuoctai();
            Toast.makeText(this, "Tài", Toast.LENGTH_SHORT).show();
        } else if (sum <= 10) {
            Toast.makeText(this, "Xỉu", Toast.LENGTH_SHORT).show();
            datcuocxiu();
        }


    }


    }





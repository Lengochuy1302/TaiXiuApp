package com.example.newww;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Random;

public class OanTuXi extends AppCompatActivity {
    MoneyMoney mo = new MoneyMoney();
    String n1,n2;
    ImageView random,human,keo,bua,bao;
    Dialog dialog;
    TextView money;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oan_tu_xi);
         dialog = new Dialog(this);

        random = findViewById(R.id.random);
        human = findViewById(R.id.human);
        keo = findViewById(R.id.keo);
        bua = findViewById(R.id.bua);
        bao = findViewById(R.id.bao);
        money = findViewById(R.id.money);
        money.setText(mo.tien+"VND");


        keo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 n1 = "Keo";
                 human.setImageResource(R.drawable.scissor_hand);
                 display();
                 result();
             }
         });

        bua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = "Bua";
                human.setImageResource(R.drawable.rock_hand);
                display();
                result();
            }
        });
        bao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = "Bao";
                human.setImageResource(R.drawable.paper_hand);
                display();
                result();
            }
        });


    }



    public void display(){
        Random rnd = new Random();
        int n = rnd.nextInt(3);
        if(n==0){
            n2 = "Keo";
            random.setImageResource(R.drawable.scissor_hand);
            random.setRotation(180);
        }else if(n==1){
            n2 = "Bua";
            random.setImageResource(R.drawable.rock_hand);
            random.setRotation(180);
        }else if(n==2){
            n2 = "Bao";
            random.setImageResource(R.drawable.paper_hand);
            random.setRotation(180);
        }
    }

    public void result(){
        if(n1.equals(n2)){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    showtiedialog();
                }
            },1000);
        }else if(n1.equals("Keo")&&n2.equals("Bao")||n1.equals("Bua")&&n2.equals("Keo")||n1.equals("Bao")&&n2.equals("Bua")){
                DecimalFormat formatmoney = new DecimalFormat("###,###,###");
                MoneyMoney.SCORE = MoneyMoney.SCORE+100000;
                String tien = String.valueOf(formatmoney.format(MoneyMoney.SCORE));
                money.setText(tien +"VND");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    showwindialog();
                }
            },1000);
        }else {

            DecimalFormat formatmoney = new DecimalFormat("###,###,###");
            MoneyMoney.SCORE = MoneyMoney.SCORE-100000;
            String tien = String.valueOf(formatmoney.format(MoneyMoney.SCORE));
            money.setText(tien +"VND");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    showclossialog();
                }
            },1000);
        }
    }

    private void showclossialog() {

        dialog.setContentView(R.layout.close_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT))  ;
        ImageView close = dialog.findViewById(R.id.closs);
        dialog.show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Reset();
            }
        });
    }

    private void showtiedialog() {
        dialog.setContentView(R.layout.tie_diaglog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT))  ;
        ImageView close = dialog.findViewById(R.id.closs);
        dialog.show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Reset();
            }





        });


    }
    private void showwindialog() {
        dialog.setContentView(R.layout.win_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT))  ;
        ImageView close = dialog.findViewById(R.id.closs);
        dialog.show();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Reset();
            }





        });


    }
    private void Reset(){
        human.setImageResource(R.drawable.iconman);
        random.setImageResource(R.drawable.robot);
        random.setRotation(0);
    }



}